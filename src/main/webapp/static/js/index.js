
$(function() {
    // 侧边栏操作按钮
    // $(document).on(click, '#guide', function() {
    //     $(this).toggleClass('toggled');
    //     $('#sidebar').toggleClass('toggled');
    // });
	// 侧边栏二级菜单
	$(document).on('click', '.sub-menu a', function() {
		$(this).next().slideToggle(200);
		$(this).parent().toggleClass('toggled');
	});
	// 个人资料
	$(document).on('click', '.s-profile a', function() {
		$(this).next().slideToggle(200);
		$(this).parent().toggleClass('toggled');
	});
	// Waves初始化
	Waves.displayEffect();
	// 滚动条初始化
	$('#sidebar').mCustomScrollbar({
		theme: 'minimal-dark',
		scrollInertia: 100,
		axis: 'yx',
		mouseWheel: {
			enable: true,
			axis: 'y',
			preventDefault: true
		}
	});
	//显示cookie菜单
	var systemid = $.cookie('zheng-upms-systemid') || 1;
	var systemname = $.cookie('zheng-upms-systemname') || 'zheng-upms-server';
	var systemtitle = $.cookie('zheng-upms-systemtitle') || '防窜货溯源管理系统';
	$('.system_menus').hide(0, function () {
		$('.system_' + systemid).show();
	});
	$('body').attr('id', systemname);
	$('#system_title').text(systemtitle);
});
// iframe高度自适应
function changeFrameHeight(ifm) {
	ifm.height = document.documentElement.clientHeight - 118;
}
function resizeFrameHeight() {
	$('.tab_iframe').css('height', document.documentElement.clientHeight - 118);
	$('md-tab-content').css('left', '0');
}
window.onresize = function() {
	resizeFrameHeight();
	initScrollShow();
	initScrollState();
};

// ========== 选项卡操作 ==========
$(function() {
	// 选项卡点击
	$(document).on('click', '.content_tab li', function() {
		// 切换选项卡
		$('.content_tab li').removeClass('cur');
		$(this).addClass('cur');
		// 切换iframe
		$('.iframe').removeClass('cur');
		$('#iframe_' + $(this).data('index')).addClass('cur');
		var marginLeft = ($('#tabs').css('marginLeft').replace('px', ''));
		// 滚动到可视区域:在左侧
		if ($(this).position().left < marginLeft) {
			var left = $('.content_tab>ul').scrollLeft() + $(this).position().left - marginLeft;
			$('.content_tab>ul').animate({scrollLeft: left}, 200, function() {
				initScrollState();
			});
		}
		// 滚动到可视区域:在右侧
		if(($(this).position().left + $(this).width() - marginLeft) > document.getElementById('tabs').clientWidth) {
			var left = $('.content_tab>ul').scrollLeft() + (($(this).position().left + $(this).width() - marginLeft) - document.getElementById('tabs').clientWidth);
			$('.content_tab>ul').animate({scrollLeft: left}, 200, function() {
				initScrollState();
			});
		}
	});
	// 控制选项卡滚动位置 
	$(document).on('click', '.tab_left>a', function() {
		$('.content_tab>ul').animate({scrollLeft: $('.content_tab>ul').scrollLeft() - 300}, 200, function() {
			initScrollState();
		});
	});
	// 向右箭头
	$(document).on('click', '.tab_right>a', function() {
		$('.content_tab>ul').animate({scrollLeft: $('.content_tab>ul').scrollLeft() + 300}, 200, function() {
			initScrollState();
		});
	});
	// 初始化箭头状态
	
	// 选项卡右键菜单
	var menu = new BootstrapMenu('.tabs li', {
		fetchElementData: function(item) {
			return item;
		},
		actionsGroups: [
			['close', 'refresh'],
			['closeOther', 'closeAll'],
			['closeRight', 'closeLeft']
		],
		actions: {
			close: {
				name: '关闭',
				iconClass: 'zmdi zmdi-close',
				onClick: function(item) {
					Tab.closeTab($(item));
				}
			},
			closeOther: {
				name: '关闭其他',
				iconClass: 'zmdi zmdi-arrow-split',
				onClick: function(item) {
					var index = $(item).data('index');
					$('.content_tab li').each(function() {
						if ($(this).data('index') != index) {
							Tab.closeTab($(this));
						}
					});
				}
			},
			closeAll: {
				name: '关闭全部',
				iconClass: 'zmdi zmdi-swap',
				onClick: function() {
					$('.content_tab li').each(function() {
						Tab.closeTab($(this));
					});
				}
			},
			closeRight: {
				name: '关闭右侧所有',
				iconClass: 'zmdi zmdi-arrow-right',
				onClick: function(item) {
					var index = $(item).data('index');
					$($('.content_tab li').toArray().reverse()).each(function() {
						if ($(this).data('index') != index) {
							Tab.closeTab($(this));
						} else {
							return false;
						}
					});
				}
			},
			closeLeft: {
				name: '关闭左侧所有',
				iconClass: 'zmdi zmdi-arrow-left',
				onClick: function(item) {
					var index = $(item).data('index');
					$('.content_tab li').each(function() {
						if ($(this).data('index') != index) {
							Tab.closeTab($(this));
						} else {
							return false;
						}
					});
				}
			},
			refresh: {
				name: '刷新',
				iconClass: 'zmdi zmdi-refresh',
				onClick: function(item) {
					var index = $(item).data('index');
					var $iframe = $('#iframe_' + index).find('iframe');
					$iframe.attr('src', $iframe.attr('src'));
				}
			}
		}
	});
});

// 选项卡对象
var Tab = {
	addTab: function(title, url) {
		var index = url.replace(/\./g, '_').replace(/\//g, '_').replace(/:/g, '_').replace(/\?/g, '_').replace(/,/g, '_').replace(/=/g, '_').replace(/&/g, '_');
		// 如果存在选项卡，则激活，否则创建新选项卡
		if ($('#tab_' + index).length == 0) {
			// 添加选项卡
			$('.content_tab li').removeClass('cur');
			var tab = '<li id="tab_' + index +'" data-index="' + index + '" class="cur"><a class="waves-effect waves-light">' + title + '</a></li>';
			$('.content_tab>ul').append(tab);
			// 添加iframe
			$('.iframe').removeClass('cur');
			var iframe = '<div id="iframe_' + index + '" class="iframe cur"><iframe class="tab_iframe" src="' + url + '" width="100%" frameborder="0" scrolling="auto" onload="changeFrameHeight(this)"></iframe></div>';
			$('.content_main').append(iframe);
			initScrollShow();
			$('.content_tab>ul').animate({scrollLeft: document.getElementById('tabs').scrollWidth - document.getElementById('tabs').clientWidth}, 200, function() {
				initScrollState();
			});
		} else {
			$('#tab_' + index).trigger('click');
		}
	},
	closeTab: function($item) {
		var closeable = $item.data('closeable');
		if (closeable != false) {
			// 如果当前时激活状态则关闭后激活左边选项卡
			if($item.hasClass('cur')) {
				$item.prev().trigger('click');
			}
			// 关闭当前选项卡
			var index = $item.data('index');
			$('#iframe_' + index).remove();
			$item.remove();
		}
		initScrollShow();
	}
}
function initScrollShow() {
	if (document.getElementById('tabs').scrollWidth > document.getElementById('tabs').clientWidth) {
		$('.content_tab').addClass('scroll');
	} else {
		$('.content_tab').removeClass('scroll');
	}
}
function initScrollState() {
	if ($('.content_tab>ul').scrollLeft() == 0) {
		$('.tab_left>a').removeClass('active');
	} else {
		$('.tab_left>a').addClass('active');
	}
	if (($('.content_tab>ul').scrollLeft() + document.getElementById('tabs').clientWidth) >= document.getElementById('tabs').scrollWidth) {
		$('.tab_right>a').removeClass('active');
	} else {
		$('.tab_right>a').addClass('active');
	}
}
//退出登录
$('#loginOut').click(function(){
    $("#loginOutModal").modal(options);
});
function loginOut1() {
    window.location.href = "/fwfc/loginOut";
}

//修改密码
$('#modifyPassword').click(function(){
    $('#newPassword').val("");
    $('#newPassword').parent().removeClass('has-success has-error');
    $('#oldPassword').val("");
	$('#oldPassword').parent().removeClass('has-success has-error');
    $('#help_newPassword').text("");
    $('#help_oldPassword').text("");
    $("#passwordModal").modal(options);
});
function modifyPassword() {
	if($('#newPassword').val() == ""){
        $('#newPassword').parent().removeClass('has-success');
		$('#newPassword').parent().addClass('has-error').focus();
		$('#help_newPassword').text("请输入新密码！");
		return false;
	}else {
        $('#newPassword').parent().removeClass('has-error');
        $('#newPassword').parent().addClass('has-success');
        $('#help_newPassword').text("");
	}
    if($('#oldPassword').val() == ""){
        $('#oldPassword').parent().removeClass('has-success');
        $('#oldPassword').parent().addClass('has-error').focus();
        $('#help_oldPassword').text("请输入旧密码！");
        return false;
    }else {
        $('#oldPassword').parent().removeClass('has-error');
        $('#oldPassword').parent().addClass('has-success');
        $('#help_oldPassword').text("");
	}
    $.ajax({
        url: '/fwfc/modifyPassword',
        type: 'POST',
        data: {
            new_password: $.trim($('#newPassword').val()),
            old_password: $.trim($('#oldPassword').val())
        },
        success: function(json){
            if (json.modifyFlag == 1) {
                $('#passwordModal').modal('hide');
               toastr.success('新密码修改成功！');
            } else if (json.modifyFlag == -1){
                toastr.error('新密码修改失败！');
            }else {
                toastr.error('旧密码输入有误！');
            }
        },
        error: function(){
            toastr.error('系统异常，请重新修改！');
        }
    });
}
//模态框垂直居中
function centerModals() {
    $('.modal').each(
        function(i) {
            var $clone = $(this).clone().css('display', 'block')
                .appendTo('body');
            var top = Math.round(($clone.height() - $clone.find(
                '.modal-content').height()) / 2);
            top = top > 0 ? top : 0;
            $clone.remove();
            $(this).find('.modal-content').css("margin-top",
                top - 50);
        });
}
$('.modal').on('show.bs.modal', centerModals);
$(window).on('resize', centerModals);