<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/2 0002
  Time: 下午 3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <title>防窜货溯源管理系统</title>
</head>
<body>
<div id="main">
    <div id="toolbar">
        <a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增用户</a>
        <a class="waves-effect waves-button" href="javascript:;" onclick="updateAction()"><i class="zmdi zmdi-edit"></i> 编辑用户</a>
        <a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction()"><i class="zmdi zmdi-close"></i> 删除用户</a>
        <a class="waves-effect waves-button" href="javascript:;" onclick="organizationAction()"><i class="zmdi zmdi-accounts-list"></i> 用户组织</a>
        <a class="waves-effect waves-button" href="javascript:;" onclick="roleAction()"><i class="zmdi zmdi-accounts"></i> 用户角色</a>
        <a class="waves-effect waves-button" href="javascript:;" onclick="permissionAction()"><i class="zmdi zmdi-key"></i> 用户权限</a>
    </div>
    <table id="dealerTable"></table>
    <div></div>
</div>
<jsp:include page="footer.jsp"/>
<script src="<%=path%>/static/js/dealer.js"></script>
</body>
</html>
