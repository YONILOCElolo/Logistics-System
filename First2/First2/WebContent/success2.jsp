<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.ctn {
	width: 200px;
	margin-top: 10px;
	padding: 10px;
	background-color: #428bca;
	border-color: #357ebd;
	color: #fff;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	border-radius: 10px; /* future proofing */
	-khtml-border-radius: 10px; /* for old Konqueror browsers */
	text-align: center;
	vertical-align: middle;
	border: 1px solid transparent;
	font-weight: 900;
	font-size: 120% display: inline-block;
	padding-left: 5px;
	padding-right: 5px;
	border: 1px solid;
	margin-left: 5px;
	margin-right: 5px;
}

.bold {
	font-weight: bold;
	font-size: 250%
}

body {
	margin-top: 10px;
	margin-right: 10%;
	margin-bottom: 10px;
	margin-left: 10%;
	text-align: center;
	height: auto;
	width: auto;
	background-color: #666666;
	font-size: 12px;
	color: #000000;
}

#container {
	text-align: left;
	width: 760px;
	height: 400px;
	padding: 20px;
}

#container #content {
	margin-top: 28px;
	width: 439px;
	height: 320px;
	padding: 10px;
	border-top-width: 6px;
	border-right-width: 6px;
	border-bottom-width: 6px;
	border-left-width: 6px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
	border-top-color: #3A81C8;
	border-right-color: #3A81C8;
	border-bottom-color: #3A81C8;
	border-left-color: #3A81C8;
	background-color: #DFEBF7;
}
</style>
	<div id="container">
		<div id="content">
			<div align="center">
				<form action="Tag2Servlet">
					<br/><br/><br/><br/><br/>
					<div class="bold">提交成功 !</div>
					<br/><br/><br/>
					<input type="submit" class="ctn" name="page1" value="点击继续" /></br>
				</form>
			</div>
		</div>
	</div>
</body>
</html>