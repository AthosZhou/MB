<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'C_Login.jsp' starting page</title>
    
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
	<style type="text/css">
	#TheA
  {
  width:430px;
  height:330px;
  margin: auto;
  text-align:center;
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  }
  #theTitle1
  {
  font-size: large;
  font-family: SimSun;
  }
	</style>
  </head>
  
  <body background="img/BK1.jpg">
  <div id="TheA" class="form-control">
    <form id="TheForm" method="post" action="CLogin">
    <div id="theTitle1" >欢迎使用操作员系统</div><br>
    <div class="form-group">
    <div class="col-sm-0">
    <label for="exampleInputName2">工号</label>
    <input name="CNo" type="text" class="form-control" placeholder="请输入工号"></div>
    </div>
    <br>
    <label class="control-label">密码</label>
    <div class="col-sm-0">
    <input name="CPass" type="password" class="form-control" placeholder="请输入密码"></div>
    <br><br>
    <a href="./CZ/Re.jsp" class="col-sm-offset-0 btn btn-primary">注册</a>
    <button type="submit" class="col-sm-offset-1 btn btn-default">登录</button>
    </form>
   </div>
   </body>
</html>
