<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Bean.CC" %>
<%@ page import="CZ.CZService" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'XX.jsp' starting page</title>
    
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
  
  <body>
    <div class="form-control" style="overflow: hidden;padding: 1px;">个人信息管理</div>
  <table class="table table-border">
  <tr class="">
  <td class="">工号</td>
  <td class="">密码</td>
  </tr>
  <tr class="">
  <%ArrayList<CC> cc=new ArrayList<CC>(); CZService cz=new CZService(); cc=cz.getGG(session.getAttribute("login_G").toString());%>
  <form action="GGCH" method="post">
  <td><input class="form-control" name="CNo" value="<%=cc.get(0).getCNo() %>" readonly="readonly"></td>
  <td><input class="form-control" name="CPass" value="<%=cc.get(0).getCPass()%>" type="password"></td>
  <td><button class="btn btn-info">确认修改</button></td>
  </form>
  </tr>
  </table>
  </body>
</html>
