<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'GMain.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
  </head>
  <%String Gno=(String)session.getAttribute("login_G"); %>
  <body>
  <%if(Gno==null){ %><a href="G_Login.jsp" class="form-control">您尚未登录！请点击此返回登录页！</a><%}else{ %>
  <div class="form-control" style="background-color: black;overflow: hidden;padding: 1px;">
    <div style="color: white;display: inline;">工号<%=Gno %>，欢迎使用上海闽斌物资有限公司钢材仓库管理系统！</div>
    <div style="float: right;display: inline; height:30px;"> <a href="Gout" class="btn btn-danger btn-s" style="float: right;">注销</a></div>
    </div>
    <div class="container" style="width:10%;height:100%;background-color:#888; float:left;">
    <div class="row">
        <div class="span2">
            <ul class="nav nav-pills nav-stacked" style="font-size: 15px;">
                <li><a href="./GL/ZC.jsp" target="mainFrame" style="color: white;">注册管理</a></li>
                <li><a href="./GL/YG.jsp" target="mainFrame" style="color: white;">员工信息管理</a></li>
                <li><a href="./CZ/GYS.jsp" target="mainFrame" style="color: white;">供应商管理</a></li>
                <li><a href="./CZ/BB.jsp" target="mainFrame" style="color: white;">报表管理</a></li>
                <li><a href="./GL/GC.jsp" target="mainFrame" style="color: white;">钢材管理</a></li>
                <li><a href="./GL/XX.jsp" target="mainFrame" style="color: white;">个人信息管理</a></li>
            </ul>
        </div>
    </div>
    </div>
    <div><iframe src="./GL/ZC.jsp" name="mainFrame" frameborder="0" marginheight="0" marginwidth="0" height="100%" width="90%"></iframe></div>
  <%} %>
  </body>
</html>
