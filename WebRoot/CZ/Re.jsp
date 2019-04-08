<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Re.jsp' starting page</title>
    
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
  height:350px;
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
	
	<script type="text/javascript">
	function registerCheck(){
	    var myreg=/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/; 
		if(document.getElementById("CNo").value.length==0){
			window.alert("工号不能为空！")
			return false;
		}
		if(document.getElementById("CName").value.length==0){
			window.alert("姓名不能为空！")
			return false;
		}
		if(document.getElementById("CPass").value.length==0){
			window.alert("密码不能为空！")
			return false;
		}
		if(document.getElementById("CTel").value.length==0){
			window.alert("手机号不能为空！")
			return false;
		}
		if(document.getElementById("CPass").value!==document.getElementById("CPass1").value){
			window.alert("密码不相等！")
			return false;
		}
		if(myreg.test(document.getElementById("CTel").value))
		{
		    window.alert("号码格式不正确！")
			return false;
		}
		return true;
	}


</script>
  </head>
  
  <body>
    <div id="TheA" class="form-control">
    <form id="TheForm" method="post" action="CRe">
    <div id="theTitle1" >欢迎使用注册系统</div><br>
    <div class="form-group">
    <div class="col-sm-0">
    <input id="CNo" name="CNo" type="text" class="form-control" placeholder="请输入工号"></div>
    </div>
    <div class="form-group">
    <div class="col-sm-0">
    <input id="CName" name="CName" type="text" class="form-control" placeholder="请输入真实姓名"></div>
    </div>
    <div class="form-group">
    <div class="col-sm-0">
    <input id="CPass" name="CPass" type="password" class="form-control" placeholder="请输入密码"></div>
    </div>
    <div class="form-group">
    <div class="col-sm-0">
    <input id="CPass1" name="CPass1" type="password" class="form-control" placeholder="请再次输入密码"></div>
    </div>
    <div class="form-group">
    <div class="col-sm-0">
    <input id="CTel" name="CTel" type="text" class="form-control" placeholder="请输入手机号" onkeyup="this.value=this.value.replace(/\D/g,'')"></div>
    </div>
    <button type="submit" class="col-sm-offset-0 btn btn-success" onclick="return registerCheck();">申请注册</button>
    </form>
    </div>
  </body>
</html>
