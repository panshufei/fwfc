var $dealerTable = $('#dealerTable');
$(function() {
    // bootstrap table初始化
    $dealerTable.bootstrapTable({
        url: '/fwfc/dealerList',
        striped: true,
        height:getHeight(),
        search: true,
        showRefresh: true,
        showColumns: true,
        minimumCountColumns: 2,
        clickToSelect: true,
        detailView: true,
        detailFormatter: 'detailFormatter',
        pagination: true,
        paginationLoop: false,
        sidePagination: 'server',
        silentSort: false,
        sortName:'dealerId',
        sortOrder:'asc',
        smartDisplay: false,
        escape: true,
        singleSelect:true,
        searchOnEnterKey: true,
        idField: 'dealerId',
        maintainSelected: true,
        toolbar: '#toolbar',
        columns: [
            {field: 'ck', checkbox: true},
            {field: 'dealerId', title: '经销商编号', sortable: true, align: 'center'},
            {field: 'dealerCode', title: '经销商代码'},
            {field: 'dealerName', title: '经销商名称'},
            {field: 'dealerGrade', title: '经销商级别'},
            // {field: 'avatar', title: '头像', align: 'center', formatter: 'avatarFormatter'},
            {field: 'dealerContact', title: '联系人'},
            {field: 'dealerNum', title: '联系方式'},
            {field: 'dealerSheng', title: '省份'},
            {field: 'dealerShi', title: '市区'},
            {field: 'dealerXian', title: '区县'},
            {field: 'firmCode', title: '公司编码',visible:false},
            // {field: 'sex', title: '性别', formatter: 'sexFormatter'},
            // {field: 'locked', title: '状态', sortable: true, align: 'center', formatter: 'lockedFormatter'},
            {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
        ]
    });
});
// 格式化操作按钮
function actionFormatter(value, row, index) {
    return [
        '<a class="update" href="javascript:;" onclick="updateAction()" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
        '<a class="delete" href="javascript:;" onclick="deleteAction()" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
    ].join('');
}
// 格式化图标
function avatarFormatter(value, row, index) {
    return '<img src="${basePath}' + value + '" style="width:20px;height:20px;"/>';
}
// 格式化性别
function sexFormatter(value, row, index) {
    if (value == 1) {
        return '男';
    }
    if (value == 2) {
        return '女';
    }
    return '-';
}
// 格式化状态
function lockedFormatter(value, row, index) {
    if (value == 1) {
        return '<span class="label label-default">锁定</span>';
    } else {
        return '<span class="label label-success">正常</span>';
    }
}
// 新增
var createDialog;
function createAction() {
    createDialog = $.dialog({
        animationSpeed: 300,
        title: '新增用户',
        content: 'url:${basePath}/manage/user/create',
        onContentReady: function () {
            initMaterialInput();
            initUploader();
        }
    });
}
// 编辑
var updateDialog;
function updateAction() {
    var rows = $table.bootstrapTable('getSelections');
    if (rows.length != 1) {
        $.confirm({
            title: false,
            content: '请选择一条记录！',
            autoClose: 'cancel|3000',
            backgroundDismiss: true,
            buttons: {
                cancel: {
                    text: '取消',
                    btnClass: 'waves-effect waves-button'
                }
            }
        });
    } else {
        updateDialog = $.dialog({
            animationSpeed: 300,
            title: '编辑用户',
            content: 'url:${basePath}/manage/user/update/' + rows[0].userId,
            onContentReady: function () {
                initMaterialInput();
                initUploader();
            }
        });
    }
}
// 删除
var deleteDialog;
function deleteAction() {
    var rows = $table.bootstrapTable('getSelections');
    if (rows.length == 0) {
        $.confirm({
            title: false,
            content: '请至少选择一条记录！',
            autoClose: 'cancel|3000',
            backgroundDismiss: true,
            buttons: {
                cancel: {
                    text: '取消',
                    btnClass: 'waves-effect waves-button'
                }
            }
        });
    } else {
        deleteDialog = $.confirm({
            type: 'red',
            animationSpeed: 300,
            title: false,
            content: '确认删除该用户吗？',
            buttons: {
                confirm: {
                    text: '确认',
                    btnClass: 'waves-effect waves-button',
                    action: function () {
                        var ids = new Array();
                        for (var i in rows) {
                            ids.push(rows[i].userId);
                        }
                        $.ajax({
                            type: 'get',
                            url: '${basePath}/manage/user/delete/' + ids.join("-"),
                            success: function(result) {
                                if (result.code != 1) {
                                    if (result.data instanceof Array) {
                                        $.each(result.data, function(index, value) {
                                            $.confirm({
                                                theme: 'dark',
                                                animation: 'rotateX',
                                                closeAnimation: 'rotateX',
                                                title: false,
                                                content: value.errorMsg,
                                                buttons: {
                                                    confirm: {
                                                        text: '确认',
                                                        btnClass: 'waves-effect waves-button waves-light'
                                                    }
                                                }
                                            });
                                        });
                                    } else {
                                        $.confirm({
                                            theme: 'dark',
                                            animation: 'rotateX',
                                            closeAnimation: 'rotateX',
                                            title: false,
                                            content: result.data.errorMsg,
                                            buttons: {
                                                confirm: {
                                                    text: '确认',
                                                    btnClass: 'waves-effect waves-button waves-light'
                                                }
                                            }
                                        });
                                    }
                                } else {
                                    deleteDialog.close();
                                    $table.bootstrapTable('refresh');
                                }
                            },
                            error: function(XMLHttpRequest, textStatus, errorThrown) {
                                $.confirm({
                                    theme: 'dark',
                                    animation: 'rotateX',
                                    closeAnimation: 'rotateX',
                                    title: false,
                                    content: textStatus,
                                    buttons: {
                                        confirm: {
                                            text: '确认',
                                            btnClass: 'waves-effect waves-button waves-light'
                                        }
                                    }
                                });
                            }
                        });
                    }
                },
                cancel: {
                    text: '取消',
                    btnClass: 'waves-effect waves-button'
                }
            }
        });
    }
}
// 用户组织
var organizationDialog;
var organizationUserId;
function organizationAction() {
    var rows = $table.bootstrapTable('getSelections');
    if (rows.length != 1) {
        $.confirm({
            title: false,
            content: '请选择一条记录！',
            autoClose: 'cancel|3000',
            backgroundDismiss: true,
            buttons: {
                cancel: {
                    text: '取消',
                    btnClass: 'waves-effect waves-button'
                }
            }
        });
    } else {
        organizationUserId = rows[0].userId;
        organizationDialog = $.dialog({
            animationSpeed: 300,
            title: '用户组织',
            content: 'url:${basePath}/manage/user/organization/' + organizationUserId,
            onContentReady: function () {
                initMaterialInput();
                $('select').select2({
                    placeholder: '请选择用户组织',
                    allowClear: true
                });
            }
        });
    }
}
// 用户角色
var roleDialog;
var roleUserId;
function roleAction() {
    var rows = $table.bootstrapTable('getSelections');
    if (rows.length != 1) {
        $.confirm({
            title: false,
            content: '请选择一条记录！',
            autoClose: 'cancel|3000',
            backgroundDismiss: true,
            buttons: {
                cancel: {
                    text: '取消',
                    btnClass: 'waves-effect waves-button'
                }
            }
        });
    } else {
        roleUserId = rows[0].userId;
        roleDialog = $.dialog({
            animationSpeed: 300,
            title: '用户角色',
            content: 'url:${basePath}/manage/user/role/' + roleUserId,
            onContentReady: function () {
                initMaterialInput();
                $('select').select2({
                    placeholder: '请选择用户角色',
                    allowClear: true
                });
            }
        });
    }
}
// 用户权限
var permissionDialog;
var permissionUserId;
function permissionAction() {
    var rows = $table.bootstrapTable('getSelections');
    if (rows.length != 1) {
        $.confirm({
            title: false,
            content: '请选择一条记录！',
            autoClose: 'cancel|3000',
            backgroundDismiss: true,
            buttons: {
                cancel: {
                    text: '取消',
                    btnClass: 'waves-effect waves-button'
                }
            }
        });
    } else {
        permissionUserId = rows[0].userId;
        permissionDialog = $.dialog({
            animationSpeed: 300,
            title: '用户授权',
            columnClass: 'large',
            content: 'url:${basePath}/manage/user/permission/' + permissionUserId,
            onContentReady: function () {
                initMaterialInput();
                initTree();
            }
        });
    }
}
// 动态高度
function getHeight() {
    return $(window).height() - 20;
}
// 数据表格展开内容
function detailFormatter(index, row) {
    var html = [];
    $.each(row, function (key, value) {
        html.push('<p><b>' + key + ':</b> ' + value + '</p>');
    });
    return html.join('');
}
// 初始化input特效
function initMaterialInput() {
    $('form input[type="text"]').each(function () {
        if ($(this).val() != '') {
            $(this).parent().find('label').addClass('active');
        }
    });
}