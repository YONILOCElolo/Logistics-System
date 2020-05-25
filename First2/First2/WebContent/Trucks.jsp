<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="shape.css">
</head>
<body>
<style type="text/css">
.ctn{ text-align: center;}
</style>
	<form action="">
	<br/><br/>
	<div align="center">
	请输入货车型号：<input type="text" name="model"><br/>
	<br/><br/>
	输入货车载重量：<input type="text" name="load"><br/>
	<br/><br/><br/>
	<input type="submit" class="ctn" onclick="javascript:this.form.action='TrucksServlet';" value="提交"><br/></div>
	</form>
	

</body>
</html>