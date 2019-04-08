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
	<script type="text/javascript">
	function changeG()
	{
	<%for(int k=0;k<1000;k++){%>
	document.forms['form<%=k%>'].action="GCch";
	document.forms['form<%=k%>'].submit();
	<%}%>
	}
	function deleteG()
	{
	<%for(int j=0;j<1000;j++){%>
	document.forms['form<%=j%>'].action="GCde";
	document.forms['form<%=j%>'].submit();
	<%}%>
	}
	</script>
  </head>
  
  <body>
  <div class="form-control">添加钢材信息</div>
  <form action="GCAd" method="post" class="form-inline">
    <input name="GCN" class="form-control" placeholder="请输入钢材名"></input>
    <input name="GCB" class="form-control" placeholder="请输入备注信息（相关用途）"></input>
    <input name="GCL" class="form-control" placeholder="请输入最低库存量"></input>
    <button class="btn btn-primary">添加钢材</button>
  </form>
  
  <div class="form-control">钢材信息管理</div>
    <table class="table table-striped" style="text-align: center;width: 100%;margin:0 auto;">
  <tr class="">
  <td class="">钢材名</td>
  <td class="">备注</td>
  <td class="">库存量</td>
  <td class="">最低库存</td>
  <td class="">操作</td>
  </tr>
  <%ArrayList<GC> gc=new ArrayList<GC>(); CZService cz=new CZService(); gc=cz.getGC();%>
  <%for(int i=0;i<gc.size();i++) {%>
  <tr class="">
  <form action="" method="post" name="form<%=i %>" class="form-control">
  <td><input class="form-control" name="GCN" value="<%=gc.get(i).getGCN() %>" readonly="readonly"></td>
  <td><input class="form-control" name="GCB" value="<%=gc.get(i).getGCB() %>"></td>
  <td><input class="form-control" name="GCM" value="<%=gc.get(i).getGCM()%>" readonly="readonly"></td>
  <td><input class="form-control" name="GCL" value="<%=gc.get(i).getGCL()%>"></td>
  <td class="btn-group"><button class="btn btn-success" onclick="changeG()">修改</button><button class="btn btn-danger" onclick="deleteG()">删除</button></td>
  </form>
  </tr>
  <%} %>
  </table><br>
  </body>
</html>
