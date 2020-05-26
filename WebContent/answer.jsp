<%@page import="deal.dealData"%>
<%@page import="com.sun.javafx.scene.traversal.WeightedClosestCorner"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Sevlet.DealDataServlet"%>
<%@page import="data.finPath"%>
<%@page import="data.ListfinPath"%>
<!DOCTYPE html>
<html>
<head>
<title>开始运算页</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<style>
.ctn {
	width: 110px;
	height: 45px;
	-khtml-border-radius: 30px;
	-moz-border-radius: 30px;
	-webkit-border-radius: 30px;
	border-radius: 30px;
}

.in {
	width: 300px;
	height: 40px;
	-khtml-border-radius: 30px;
	-moz-border-radius: 30px;
	-webkit-border-radius: 30px;
	border-radius: 30px;
}

.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	/* Set the fixed height of the footer here */
	height: 70px;
	background-color: #343a40;
}

.bold {
	font-weight: bold;
	font-size: 200%;
	color: #343a40;
}

.show {
	font-weight: 520;
	font-size: 120%;
	width: 320px;
	border: 1px solid #000;
	font-family: "Times New Roman", Times, serif;
	margin: 0 auto;
	text-align: left;
}

span {
	font-size: 90%;
	font-weight: bold;
}

.biankuang {
	padding-bottom: 0px;
	display: block;
	white-space: nowrap;
}

.biankuang::-webkit-scrollbar {
	display: none;
}

#divA {
	width: 1000px;
	height: 400px;
	overflow-x: hidden;
	overflow-y: scroll;

background: rgba(0, 0, 0, 0.1);
	text-align: left;

}

#divA::-webkit-scrollbar {
	display: none;
}

body {
	background-image: url('https://s1.ax1x.com/2020/05/24/tSJNWR.jpg');
	background-repeat: no-repeat;
	width: 100%;
	height: auto;
}
.L{
align:center;
font-size: 110%;
}
.show1{
font-family: sans-serif;
}
.color{
color:green;
}
.color1{
color:green;
}
</style>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" style="color: white"> 欢迎进入“快配送”系统 ! </a>
		<ul class="nav navbar-nav ml-auto justify-content-end">
			<li class="nav-item"><a class="nav-link" href="Maxdistance.jsp">请输入汽车最大距离限制</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="Trucks.jsp">请输入卡车信息</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="choice.jsp">请输入客户信息</a>
			</li>
			<li class="nav-item"><a class="nav-link active"
				href="DealData.jsp">开始运算</a></li>
		</ul>

	</nav>
	<!--<div class = "linear">
<div class = "center-in-center">
	<div id="container">https://s1.ax1x.com/2020/05/24/tSJaS1.jpg
		<div id="content">-->
	<div align="center" class="biankuang">
		<%
			List<finPath> finPathList = ListfinPath.getInstance();
			int a = finPathList.size();// 线路数量
			int[] i = new int[a];
			String[] way = new String[a];
			double[] weight = new double[a];
			double[] car = new double[a];
			Iterator<finPath> iterator = finPathList.iterator();
			int j = 0;
			while (iterator.hasNext()) {
				finPath fin = iterator.next();
				i[j] = fin.getI();//第？条路线
				way[j] = fin.getWay();//路线
				weight[j] = fin.getWeigth();//行驶里程
				car[j] = fin.getCar();//汽车
				j++;
			}
		%>
		<br /> <br />
		<div id="divA">
			<div class="show show1" >
				一共有
				<%=dealData.length%>个客户
			</div>
			<br />
			<div class="show">最终输出：</div>
			<br />
			<%
				for (int k = 0; k < j; k++) {
					//	 System.out.println("i得长度："+i.length);
					//	 System.out.println("k："+k);
			%>
			<div class="show">
				第<span class="color"><%=i[k]%></span>条路线：<span class="color1"><%=way[k]%></span>
			</div>

			<div class="show">
				行驶里程：<span><%=weight[k]%> </span> km
			</div>

			<div class="show">
				选用载重量为     <span> <%=car[k]%> </span>t      的客车
			</div>
			<%
				}
			%>
			<br />
			<div class="show">
				总行驶里程：<span><%=dealData.Routecount%></span> km
			</div>
		</div>
		<br/>
			<a class="l" href="LastPage.jsp">结束</a>

	</div>

	<footer class="footer">
		<font class="text-center" color="white" size="10"> </font>
	</footer>
</body>

</html>