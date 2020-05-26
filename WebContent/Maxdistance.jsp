<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>汽车限制距离输入页</title>
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
		    <li class="nav-item active">
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


<form action="MaxdistanceServlet">
	 <br/><br/><br/><br/><br/><br/><br/>
	 <div align="center">
	 	<font color="black" size="4">请输入最大行驶距离： </font>
		<input class="in text-center" type="text" id="max" name="Maxdistance"
			onkeyup="value=value.replace(/^\D*(\d*(?:\.\d{0,2})?).*$/g, '$1')"  placeholder="请输入最大距离"><br /> <br />
		<br/> <br/>
		<div class="a">
			<button onclick="return txt();" class="ctn" value="确定">确定</button>
			<%-- 	<input type=botton class="ctn" value="确定"><br />--%>
		</div>
	</div>
</form>
<script>
	var str = "0123456789";
		function press() {
			var str1 = document.all.b1.value;
			if (str.indexOf(str1) != -1) {
				return true;
			} else {
				alert("只能问输入数字答！");
				document.all.b1.value = "";
				return false;
			}
		}
		function txt() {

			//获取表单对象
			var m = document.getElementById("max");

			//验证项目是否为空
			if (m.value == '' || m.value == null) {
				alert("请输入数据！");
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