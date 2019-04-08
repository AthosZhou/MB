<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Bean.GCT" %>
<%@ page import="Bean.GC" %>
<%@ page import="Bean.GYS" %>
<%@ page import="CZ.CZService" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'CK.jsp' starting page</title>
    
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
  <div class="form-control" style="overflow: hidden;padding: 1px;">出库管理</div>
  <div class="form-control">入库操作</div>
  <form action="CK" method="post" class="form-inline" >
  <% ArrayList<GC> gc=new ArrayList<GC>();
  ArrayList<GYS> gys=new ArrayList<GYS>();
   CZService cz=new CZService();
   gc=cz.getGC(); 
   gys=cz.getGYS();%>
  <select class="selectpicker show-tick form-control" data-live-search="true" name="OGCN">
  <%for(int i=0;i<gc.size();i++) {%>
  <option><%=gc.get(i).getGCN() %></option>
  <%} %>
  </select>
  <input name="OGCM" class="form-control" onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="数量"></input>
  <Button class="btn btn-default" type="submit">出库</Button>
  </form>
  <div class="form-control">出库记录</div>
  <table class="table table-bordered" style="text-align: center;margin:0 auto;">
  <tr class="">
  <td class="active">订单号</td>
  <td class="active">操作名称</td>
  <td class="active">操作员</td>
  <td class="info">出库产品</td>
  <td class="success">单价</td>
  <td class="success">供应商</td>
  <td class="active">出库数量</td>
  <td class="active">出库时间</td>
  </tr>
  <%ArrayList<GCT> gct=new ArrayList<GCT>(); gct=cz.getCK(); %>
  <%for(int i=0;i<gct.size();i++) {%>
  <tr class="">
  <td class=""><%=gct.get(i).getOPN() %></td>
  <td class=""><%=gct.get(i).getOPR() %></td>
  <td class=""><%=gct.get(i).getOPC() %></td>
  <td class=""><%=gct.get(i).getOGCN() %></td>
  <td class=""><%=gct.get(i).getOGCP() %></td>
  <td class=""><%=gct.get(i).getOGCG() %></td>
  <td class=""><%=gct.get(i).getOGCM() %></td>
  <td class=""><%=gct.get(i).getOPT() %></td>
  </tr>
  <%} %>
  </body>
</html>
