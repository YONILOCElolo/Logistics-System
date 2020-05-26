<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>客户信息输入选择页</title>
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
	height:40px;
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
	font-size: 320%;
	color:#343a40;
}
.l:hover {
	font-size: 40px;
	color: #3e3;
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
		    <li class="nav-item">
		      <a class="nav-link" href="choice.jsp">请输入客户信息</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="DealData.jsp">开始运算</a>
		    </li>
		  </ul>

</nav>
<!-- <div class = "linear">
<div class = "center-in-center">
<div id="container">
<div id="content">-->
<div align = center>
 	<form>	
 		<br/><br/><br/><br/><br/>
		<div class="bold">请选择输入用户信息方式！</div>
		<br/> <br/> 
	<!--  a class="l" href="../First/Customer.jsp">手动输入客户信息</a>  -->
<a class="l" href="Customer.jsp">手动输入客户信息</a> 
		<br/>
	<br/>
		<a class="l" href="LExcel.jsp">导入客户信息表</a><br/>
		<br/>
	</form>
	</div>
	
<footer class="footer">
    <font class="text-center" color="white" size="10">  </font>
</footer>     
     
     
</body>
</html>