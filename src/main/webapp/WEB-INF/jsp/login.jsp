<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/27 0027
  Time: 上午 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>防窜货溯源管理系统</title>
<head>
    <link href="<%=path%>/static/plugin/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path%>/static/css/login.css" rel="stylesheet"/>
    <link href="<%=path%>/static/plugin/waves-0.7.5/waves.css" rel="stylesheet"/>
    <link href="<%=path%>/static/plugin/checkbix/checkbix.min.css" rel="stylesheet"/>
    <link href="<%=path%>/static/plugin/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
    <link href="<%=path%>/static/plugin/toastr/toastr.css" rel="stylesheet"/>
</head>
<body>
<div id="login-window">
    <div class="input-group m-b-20">
        <span class="input-group-addon"><i class="zmdi zmdi-account"></i></span>
        <div class="fg-line">
            <input id="username" type="text" class="form-control" name="username" placeholder="帐号" required autofocus >
        </div>
    </div>
    <div class="input-group m-b-20">
        <span class="input-group-addon"><i class="zmdi zmdi-male"></i></span>
        <div class="fg-line">
            <input id="password" type="password" class="form-control" name="password" placeholder="密码" required >
        </div>
    </div>
    <div class="clearfix"></div>
    <div class="checkbox">
        <input id="rememberMe" type="checkbox" class="checkbix" data-text="自动登录" name="rememberMe">
    </div>
    <a id="login-bt" href="javascript:;" class="waves-effect waves-button waves-float"><i class="zmdi zmdi-arrow-forward"></i></a>
</div>
<script src="<%=path%>/static/plugin/jquery-3.2.1.min.js"></script>
<script src="<%=path%>/static/plugin/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="<%=path%>/static/plugin/waves-0.7.5/waves.min.js"></script>
<script src="<%=path%>/static/plugin/checkbix/checkbix.min.js"></script>
<script src="<%=path%>/static/plugin/toastr/toastr.js"></script>
<script src="<%=path%>/static/js/login.js"></script>
<script type="text/javascript">
    //在一个页面上一次性初始化所有弹出框的方式
    $(function () {
        //$('[data-toggle="popover"]').popover()
        //提示框初始化
        toastr.options = {
            "positionClass": "toast-top-center",
            "timeOut": "1000"
        };
    })
</script>
</body>
</html>
