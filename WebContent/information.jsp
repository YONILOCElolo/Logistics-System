<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>客户信息输入页</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<style>
.ctn {
	width:110px;
	height:45px;
	-khtml-border-radius: 30px;
	-moz-border-radius: 30px;
	-webkit-border-radius: 30px;
	border-radius: 30px;
}
.in {
	width:300px;
	height:80px;
	-khtml-border-radius: 30px;
	-moz-border-radius: 30px;
	-webkit-border-radius: 30px;
	border-radius: 30px;
}
.footer {
        position: absolute;
        bottom: 0;  width: 100%;
        /* Set the fixed height of the footer here */
        height: 70px;
        background-color:#343a40;
}
.bold {
	font-weight: bold;
	font-size: 350%;
	color:#343a40;
}
</style>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" style="color:white"> 欢迎进入“快配送”系统 ! </a>
		  <ul  class="nav navbar-nav ml-auto justify-content-end">
		    <li class="nav-item">
		      <a class="nav-link" href="Maxdistance.jsp">请输入汽车最大距离限制</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="Trucks.jsp">请输入卡车信息</a>
		    </li>
		    <li class="nav-item active">
		      <a class="nav-link active" href="information.jsp">请输入客户信息</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="DealData.jsp">开始运算</a>
		    </li>
		  </ul>

</nav>
<div class = "linear">
<div class = "center-in-center">
	<div id="container">
		<div id="content">
			<div align="center">
	<form action="Customer1Servlet">
	<br/><br/><br/><br/><br/><br/>
	<font color="black" size="5">请输入客户名称：</font><input class="in text-center"  type="text" name="Cname2" id="Cname2"  style="width:260px;height:40px;">
		<br/><br/>
	<font color="black" size="5">输入客户需求量：</font><input class="in text-center"  type="text" name="Cnumber2" id="Cnumber2"  style="width:260px;height:40px;">
		<br/><br/><br/>
	<button onclick="return submitChecka();" class="ctn" value="提交">提交</button>
	<%--<input type="button" class="ctn" onclick="javascript:this.form.action='Customer1Servlet';" value="提交">--%>
	</form>
	</div></div></div></div></div>
<script>
function submitChecka(){

	        //获取表单对象
	        var cname=document.getElementById("Cname2");
	        var cnumber=document.getElementById("Cnumber2");

	        //验证项目是否为空
	        if(cname.value.length==0){
	            alert("请输入客户名称！");
	            return false;
	        } else if(cnumber.value.length==0){
	            alert("请输入客户需求量！");
	            return false;
	        }
	        return true;


}
</script>
<footer class="footer">
    <font class="text-center" color="white" size="10">  </font>
</footer>     
     
</body>
</html>