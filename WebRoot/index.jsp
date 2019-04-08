<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  <style type="text/css">
  #THC
  {
  width:30%;
  height:46%;
  margin: auto;
  text-align:center;
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  }
  #TIT
  {height:30%;
  color:#5599FF;
  font-family: SimSun;
  font-size: 30px;
  }
  #RT1
  {height:30%;}
  #LF1
  {height:30%;}
  </style>
  <body background="img/BK1.jpg">
  <div id="THC">
  <div id="TIT">Hi!,请选择您的登录身份</div>
  <div id="RT1" class="text-center">
  <a href="C_Login.jsp">
  <button type="submit" class="btn btn-primary" >操作员</button></a></div>
  <div id="LF1" class="text-center">
  <a href="G_Login.jsp">
  <button type="submit" class="btn btn-danger">管理员</button></div></a>
  </div>
  </div>
  </body>
</html>
