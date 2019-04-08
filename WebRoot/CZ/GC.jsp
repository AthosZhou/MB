<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Bean.GC" %>
<%@ page import="CZ.CZService" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'GC.jsp' starting page</title>
    
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
    <div class="form-control" style="overflow: hidden;padding: 1px;">钢材信息</div>
    <div style="height: 20px;"></div>
    <% ArrayList<GC> gc=new ArrayList<GC>(); CZService cz=new CZService();gc=cz.getGC(); %>
    <table class="table table-bordered" style="text-align: center;width: 50%;margin:0 auto;">
  <tr class="">
  <td class="active">钢材名称</td>
  <td class="success">单位</td>
  <td class="info">备注</td>
  <td class="active">现有库存</td>
  <td class="danger">最低库存</td>
  </tr>
  <%for(int i=0;i<gc.size();i++) {%>
  <tr class="">
  <td class=""><%=gc.get(i).getGCN() %></td>
  <td class="">根</td>
  <td class=""><%=gc.get(i).getGCB() %></td>
  <td class=""><%=gc.get(i).getGCM() %></td>
  <td class=""><%=gc.get(i).getGCL() %></td></tr><%} %>
  </table>
  
  </body>
</html>
