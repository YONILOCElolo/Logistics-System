<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>货车信息输入失败页</title>
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
		    <li class="nav-item active">
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


<div class="container">
<form action="TrucksServlet" >
	<br/><br/><br/><br/><br/><br/>
	<div class="container">
	<div align="center">
	<font color="black" size="4">请输入货车型号：</font>
	<input class="in text-center" type="text" name="model" id="Cnum" placeholder="货车型号"><br/>
	<br/><br/><br/>
	<font color="black" size="4">输入货车载重量：</font>
	<input class="in text-center" type="text" name="load" id="Cload" onkeyup="value=value.replace(/^\D*(\d*(?:\.\d{0,2})?).*$/g, '$1')" placeholder="货车载重量"><br/>
	<br/><br/><br/>
	 <button  onclick="return submitCheck();" class="ctn"   value="提交">提交</button>
<%--	<input type="button" class="ctn" onclick="javascript:this.form.action='TrucksServlet';" value="提交"> --%></div></div>
	</form>

<script>
function submitCheck(){

		
			 
        //获取表单对象
        var cnumber=document.getElementById("Cnum");
        var cload=document.getElementById("Cload");
       
 
        //验证项目是否为空
        if(cnumber.value.length==0){
            alert("请输入汽车型号！");
            return false;
        } else if(cload.value.length==0){
            alert("请输入载重量！");
            return false;
        }
        
        return true;
    }
</script>
</div>

<footer class="footer">
    <font class="text-center" color="white" size="10">  </font>
</footer>     
     
</body>
</html>