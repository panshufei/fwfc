$(function() {
	// Waves初始化
	Waves.displayEffect();
	// 输入框获取焦点后出现下划线
	$('.form-control').focus(function() {
		$(this).parent().addClass('fg-toggled');
	}).blur(function() {
		$(this).parent().removeClass('fg-toggled');
	});
});
Checkbix.init();
$(function() {
	// 点击登录按钮
	$('#login-bt').click(function() {
        if($('#username').val()==""){
            toastr.warning('请输入账号！');
            $('#username').focus();
            return false;
        }
        if($('#password').val()==""){
            toastr.warning('请输入密码！');
            $('#password').focus();
            return false;
        }
		login();
	});
	// 回车事件
	$('#username, #password').keypress(function (event) {
		if (13 == event.keyCode) {
			login();
		}
	});
});
// 登录
function login() {
	$.ajax({
		url: '/fwfc/loginCheck',
		type: 'POST',
		data: {
			user_name: $.trim($('#username').val()),
            user_password: $.trim($('#password').val()),
			rememberMe: $('#rememberMe').is(':checked')
		},
		success: function(json){
			if (json.status == 1) {
				location.href = '/fwfc/index';
			} else if (json.status == -1){
                toastr.error('密码输入错误！');
			}else {
                toastr.error('账号不存在或输入有误！');
			}
		},
		error: function(){
            toastr.error('系统异常，请重新登录！');
		}
	});
}