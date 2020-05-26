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
		      <a class="nav-link " href="Customer.jsp">请输入客户信息</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="DealData.jsp">开始运算</a>
		    </li>
		  </ul>

</nav>

<%-- <form class="form" action="CustomerServlet" >--%>
	<form action="CustomerServlet">
		<div align="center">
			<br/><br/>
			<br/> 请输入客户名称: <input class="in text-center" type="text" name="Cname" id="Cname1"
				placeholder="客户名称"><br/> <br/> 
				输入客户需求量: <input class="in text-center" type="text"
				name="Cnumber" id="Cnumber1" onkeyup="value=value.replace(/^\D*(\d*(?:\.\d{0,2})?).*$/g, '$1')" placeholder="客户需求量"><br /> <br />
				输入客户横坐标: <input class="in text-center" type="text" onkeyup="value=value.replace(/^\D*(\d*(?:\.\d{0,2})?).*$/g, '$1')" name="Left" id="Left" placeholder="横坐标"><br />
			<br/> 
				输入客户纵坐标: <input class="in text-center" type="text" onkeyup="value=value.replace(/^\D*(\d*(?:\.\d{0,2})?).*$/g, '$1')" name="Right" id="Right"
				placeholder="纵坐标"><br/> <br/>
			<br/>
			<button onclick="return submitChecka();" class="ctn" value="提交">提交</button>
			<%--<input type="botton" class="ctn" onclick="javascript:this.form.action='CustomerServlet';" value="提交">--%>
			<br/>
		</div>
	</form>
	<script>
function submitChecka(){

		
			 
	        //获取表单对象
	        var cname=document.getElementById("Cname1");
	        var cnumber=document.getElementById("Cnumber1");
	        var left=document.getElementById("Left");
	        var right=document.getElementById("Right");
	 
	        //验证项目是否为空
	        if(cname.value.length==0){
	            alert("请输入客户名称！");
	            return false;
	        } else if(cnumber.value.length==0){
	            alert("请输入客户需求量！");
	            return false;
	        } else if(left.value.length==0){
	            alert("请输入客户横坐标！");
	            return false;
	        } else if(right.value.length==0){
	            alert("请输入客户纵坐标！");
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