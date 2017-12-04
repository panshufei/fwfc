<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/2 0002
  Time: 下午 3:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
    String path = request.getContextPath();
%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=path%>/static/plugin/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/static/plugin/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet">
<link href="<%=path%>/static/plugin/waves-0.7.5/waves.css" rel="stylesheet"/>
<link href="<%=path%>/static/plugin/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
<link href="<%=path%>/static/plugin/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>
<link href="<%=path%>/static/plugin/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
<style>
    /** 皮肤 **/
    #zheng-upms-server #header {background: #29A176;}
    #zheng-upms-server .content_tab{background: #29A176;}
    #zheng-upms-server .s-profile>a{background: url(<%=path%>/static/image/index.png) left top no-repeat;}
</style>
