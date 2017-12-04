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
    String user = (String)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <title>防窜货溯源管理系统</title>
    <link href="<%=path%>/static/css/index.css" rel="stylesheet"/>
</head>
<body>
<div class="modal fade" id="loginOutModal" tabindex="-1" role="dialog" aria-labelledby="loginOutModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="loginOutModalLabel">退出系统</h4>
            </div>
            <div class="modal-body">
                您确定要退出该系统吗？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">否</button>
                <button type="button" onclick="loginOut1()" class="btn btn-primary">是</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="passwordModal" tabindex="-1" role="dialog" aria-labelledby="passwordModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="passwordModalLabel">Modal title</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="newPassword">新密码</label>
                    <input type="text" class="form-control" id="newPassword" placeholder="新密码">
                    <span id="help_newPassword" class="help-block"></span>
                </div>
                <div class="form-group">
                    <label for="oldPassword">旧密码</label>
                    <input type="text" class="form-control" id="oldPassword" placeholder="旧密码">
                    <span id="help_oldPassword" class="help-block"></span>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" onclick="modifyPassword()" class="btn btn-primary">确定</button>
            </div>
        </div>
    </div>
</div>
<header id="header">
    <ul id="menu">
        <%--<li id="guide" class="line-trigger">--%>
            <%--<div class="line-wrap">--%>
                <%--<div class="line top"></div>--%>
                <%--<div class="line center"></div>--%>
                <%--<div class="line bottom"></div>--%>
            <%--</div>--%>
        <%--</li>--%>
        <li id="logo" class="hidden-xs">
            <a href="<%=path%>/index">
                <img src="<%=path%>/static/image/logo.png"/>
            </a>
            <span id="system_title">防窜货溯源管理系统</span>
        </li>
        <li class="pull-right">
            <ul class="hi-menu">
                <li class="dropdown">
                    <a class="waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
                        <i class="him-icon zmdi zmdi-more-vert"></i>
                    </a>
                    <ul class="dropdown-menu dm-icon pull-right">
                        <li>
                            <a class="waves-effect" id="modifyPassword" data-toggle="modal" data-target="#passwordModal" href="javascript:;"><i class=" zmdi zmdi-edit"></i>修改密码</a>
                        </li>
                        <li>
                            <a class="waves-effect" id="loginOut" data-toggle="modal" data-target="#loginOutModal" href="#"><i class=" zmdi zmdi-power "></i> 退出登录</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>
</header>
<section id="main">
    <!-- 左侧导航区 -->
    <aside id="sidebar">
        <!-- 个人资料区 -->
        <div class="s-profile">
            <a class="waves-effect waves-light" href="javascript:;">
                <div class="sp-pic">
                    <img src="<%=path%>/static/image/avatar.jpg"/>
                </div>
                <div class="sp-info">
                    <%=user%>，您好！
                    <i class="zmdi zmdi-caret-down"></i>
                </div>
            </a>
        </div>
        <!-- /个人资料区 -->
        <!-- 菜单区 -->
        <ul class="main-menu">
            <li>
                <a class="waves-effect" href="javascript:Tab.addTab('首页', 'home');"><i class="zmdi zmdi-home"></i> 首页</a>
            </li>
            <li class="sub-menu system_menus system_1 0">
                <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-accounts-list"></i> 基础资料</a>
                <ul>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('经销商管理', '/fwfc/dealer');">经销商管理</a></li>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('组织管理', '/manage/organization/index');">组织管理</a></li>
                </ul>
            </li>
            <li class="sub-menu system_menus system_1 3">
                <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-accounts"></i> 角色用户管理</a>
                <ul>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('角色管理', '/manage/role/index');">角色管理</a></li>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('用户管理', '/manage/user/index');">用户管理</a></li>
                </ul>
            </li>
            <li class="sub-menu system_menus system_1 6">
                <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-lock-outline"></i> 权限资源管理</a>
                <ul>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('权限管理', '/manage/permission/index');">权限管理</a></li>
                </ul>
            </li>
            <li class="sub-menu system_menus system_1 7">
                <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-more"></i> 其他数据管理</a>
                <ul>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('公共码表', '/manage/coder/index');">公共码表</a></li>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('会话管理', '/manage/session/index');">会话管理</a></li>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('日志记录', '/manage/log/index');">日志记录</a></li>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('键值设置', '/manage/map/index');">键值设置</a></li>
                </ul>
            </li>
            <li class="sub-menu system_menus system_2 12" style="display:none;">
                <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-menu"></i> 标签类目管理</a>
                <ul>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('标签管理', '/manage/tag/index');">标签管理</a></li>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('类目管理', '/manage/category/index');">类目管理</a></li>
                </ul>
            </li>
            <li class="sub-menu system_menus system_2 15" style="display:none;">
                <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-collection-text"></i> 文章内容管理</a>
                <ul>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('文章管理', '/manage/article/index');">文章管理</a></li>
                    <li><a class="waves-effect" href="javascript:Tab.addTab('回收管理', '/manage/article/recycle');">回收管理</a></li>
                </ul>
            </li>
            <li>
                <div class="upms-version">
                    &copy; 安徽博实远亿信息科技有限公司 V4.0.0
                </div>
            </li>
        </ul>
        <!-- /菜单区 -->
    </aside>
    <!-- /左侧导航区 -->
    <section id="content">
        <div class="content_tab">
            <div class="tab_left">
                <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-left"></i></a>
            </div>
            <div class="tab_right">
                <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-right"></i></a>
            </div>
            <ul id="tabs" class="tabs">
                <li id="tab_home" data-index="home" data-closeable="false" class="cur">
                    <a class="waves-effect waves-light">首页</a>
                </li>
            </ul>
        </div>
        <div class="content_main">
            <div id="iframe_home" class="iframe cur">
                <p><h4>首页</h4></p>
            </div>
        </div>
    </section>
</section>
<footer id="footer"></footer>
<jsp:include page="footer.jsp"/>
<script src="<%=path%>/static/js/index.js"></script>
</body>
</html>
