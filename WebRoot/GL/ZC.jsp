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
    
    <title>My JSP 'ZC.jsp' starting page</title>
    
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
  <form action="QK" method="post">
  <button class="btn btn-danger">清空所有申请信息</button></form>
  <%ArrayList<CC> ccg=new ArrayList<CC>(); CZService cz=new CZService(); ccg=cz.getCCG();%>
  <%if(ccg.size()==0){ %>
  <div class="form-control">没有注册信息</div>
  <%}else{ %>
  <table class="table table-stripped" style="text-align: center;margin:0 auto;">
  <tr class="">
  <td class="active">申请人工号</td>
  <td class="active">申请人姓名</td>
  <td class="active">申请人密码</td>
  <td class="active">申请人手机号</td>
  <td class="active">操作</td>
  </tr>
  <tr>
  <%for(int i=0;i<ccg.size();i++) {%>
  <form action="SQ" method="post">
  <td><input type="hidden" name="CNo" value="<%=ccg.get(i).getCNo() %>"><%=ccg.get(i).getCNo() %></td>
  <td><input type="hidden" name="CName" value="<%=ccg.get(i).getCName() %>"><%=ccg.get(i).getCName() %></td>
  <td><input type="hidden" name="CPass" value="<%=ccg.get(i).getCPass() %>"><%=ccg.get(i).getCPass() %></td>
  <td><input type="hidden" name="CTel" value="<%=ccg.get(i).getCTel() %>"><%=ccg.get(i).getCTel() %></td>
  <td><button class="btn btn-success">通过</button></td></form>
  </tr><%} %>
  <%} %>
  </body>
</html>
