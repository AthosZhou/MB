<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>My JSP 'GYS.jsp' starting page</title>
    
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
	<script type="text/javascript">
	
	function changeG()
	{
	<%for(int j=0;j<1000;j++){%>
	document.forms['form<%=j%>'].action="Gch";
	document.forms['form<%=j%>'].submit();
	<%}%>
	}
	function deleteG()
	{
	<%for(int j=0;j<1000;j++){%>
	document.forms['form<%=j%>'].action="Gde";
	document.forms['form<%=j%>'].submit();
	<%}%>
	}
	</script>
  </head>
  
  <body>
    <div class="form-control" style="overflow: hidden;padding: 1px;">供应商管理</div>
    <div>供应商信息查询</div>
    <form class="form-inline" action="GYCX" method="post">
    <input name="GM" class="form-control" placeholder="请输入供货商"></input>
    <button class="btn btn-primary">查询</button>
    </form>
    <div>添加供应商信息</div>
  <form action="GYAd" method="post" class="form-inline">
    <input name="GYN" class="form-control" placeholder="请输入供货商名"></input>
    <input name="GYT" class="form-control" placeholder="请输入联系电话"></input>
    <input name="GYA" class="form-control" placeholder="请输入供应商地址"></input>
    <input name="GYF" class="form-control" placeholder="请输入主营范围"></input>
    <button class="btn btn-primary">添加供应商</button>
  </form>
    <div>信息显示</div>
    <table class="table table-striped" style="text-align: center;width: 100%;margin:0 auto;">
    <%ArrayList<GYS> gys=new ArrayList<GYS>(); gys=(ArrayList<GYS>)request.getAttribute("GYS");%>
  <tr class="">
  <td class="active">供货商名</td>
  <td class="success">联系电话</td>
  <td class="info">供应商地址</td>
  <td class="active">主营范围</td>
  <td class="active">操作</td>
  </tr>
  <%if(gys==null){CZService cz=new CZService(); gys=cz.getGYS();} %>
  <%for(int i=0;i<gys.size();i++) {%>
  <tr class="">
  <form name="form<%=i %>" method="post" class="form-control">
  <td class=""><input readonly="readonly" name="GYN_1" class="form-control" value="<%=gys.get(i).getGYN() %>"></td>
  <td class=""><input class="form-control" name="GYT_1" value="<%=gys.get(i).getGYT() %>"></td>
  <td class=""><input class="form-control" name="GYA_1" value="<%=gys.get(i).getGYA() %>"></td>
  <td class=""><input class="form-control" name="GYF_1" value="<%=gys.get(i).getGYF() %>"></td>
  <td class="btn-group">
  <div class="">
  <button id="sb1" name="sb1" class="btn btn-primary" onclick="changeG()">修改</button>
  <button id="sb2" name="sb2" class="btn btn-danger" onclick="deleteG()">删除</button></form>
  </div>
  </td></tr>
  <%} %>
  </table>  	
  </body>
</html>
