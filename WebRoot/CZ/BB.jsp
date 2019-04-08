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
    
    <title>My JSP 'BB.jsp' starting page</title>
    
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
	function TheNext()
	{
	document.forms['form1'].action="Next_BB";
	document.forms['form1'].submit();
	}
	function ThePrior()
	{
	document.forms['form1'].action="Prior_BB";
	document.forms['form1'].submit();
	}
	
	</script>
  </head>
  
  <body>
    <div class="form-control" style="overflow: hidden;padding: 1px;">报表检索</div>
     <form action="TimeBB" method="post" class="form-inline">
    <select class="form-control" name="CRK">
    <option>入库操作</option>
    <option>出库操作</option>
    </select> 
    	起始日期：<input type="date" name="start_time" class="form-control" />终止日期：<input type="date" name="end_time" class="form-control" /><button class="btn btn-primary">查询</button>
    </form>
    <!-- <form action="TBB" method="post" class="form-inline"><button class="btn btn-default">报表下载</button></form> -->
    <div class="form-control" style="overflow: hidden;padding: 1px;">报表展示</div>
    <table class="table table-bordered" style="text-align: center;margin:0 auto;">
  <tr class="">
  <td class="active">订单号</td>
  <td class="active">操作名称</td>
  <td class="active">操作员</td>
  <td class="info">操作钢材</td>
  <td class="success">单价</td>
  <td class="success">供应商</td>
  <td class="active">操作数量</td>
  <td class="active">操作时间</td>
  </tr>
  <%
  int page_now=0;
  if(request.getAttribute("pageN")==null){page_now=1;}else{page_now=Integer.parseInt(request.getAttribute("pageN").toString());}
  int pagecount=5;
  int num=0;
  int pagenum=0;
  ArrayList<GCT> gct=new ArrayList<GCT>();
  CZService cz=new CZService();
  if(request.getAttribute("CRK1")!=null&&request.getAttribute("start_time1")!=null&&request.getAttribute("end_time1")!=null){
  String CRK=request.getAttribute("CRK1").toString();
  String start_time=request.getAttribute("start_time1").toString();
  String end_time=request.getAttribute("end_time1").toString();
  gct=cz.getGCT(CRK, start_time, end_time,page_now); 
  num=cz.getGN(CRK, start_time, end_time);
  }
  else{
  gct=cz.getGCT(page_now,pagecount);
  num=cz.getGCTPC(pagecount); }
  if(num%5==0)
  {
  pagenum=num/5;
  }
  else
  {pagenum=(num/5)+1;}
  %>
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
  </table>
  <form class="form-inline" style="text-align: center;" name="form1" action="" method="post">
  <input type="hidden" value="<%=page_now %>" name="pageinfo">
  <%if(request.getAttribute("CRK1")!=null&&request.getAttribute("start_time1")!=null&&request.getAttribute("end_time1")!=null){%>
  <input type="hidden" value="<%=request.getAttribute("CRK1").toString() %>" name="CRK2">
  <input type="hidden" value="<%=request.getAttribute("start_time1").toString() %>" name="start_time2">
  <input type="hidden" value="<%=request.getAttribute("end_time1").toString() %>" name="end_time2">
  <%} %>
  <%if(page_now!=1){ %><button class="btn btn-default" onclick="ThePrior()">上一页</button><%} %>当前第<%=page_now %>页
  <%if(page_now!=pagenum){%><button class="btn btn-default" onclick="TheNext()">下一页</button><%} %>共<%=pagenum %>页
  </form>
  </body>
</html>
