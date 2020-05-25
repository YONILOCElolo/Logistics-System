<%@page import="deal.dealData"%>
<%@page import="com.sun.javafx.scene.traversal.WeightedClosestCorner"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="Sevlet.DealDataServlet" %>
    <%@page import="data.finPath" %>
    <%@page import="data.ListfinPath" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.show{
font-weight:bold;
font-size:110%
}

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
	font-size: 200%
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
	overflow:auto;
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

</head>
<body>
	<div id="container">
		<div id="content">
		<%
		List<finPath> finPathList = ListfinPath.getInstance();
		int a= finPathList.size();// 线路数量
		int []i=new int[a];
		String []way=new String[a];
		double []weight=new double[a];
		double []car=new double[a];
		Iterator<finPath> iterator = finPathList.iterator();
		int j=0;
		while (iterator.hasNext()) {
			finPath fin = iterator.next();
			i[j]=fin.getI();//第？条路线
			way[j]=fin.getWay();//路线
			weight[j]=fin.getWeigth();//行驶里程
			car[j]=fin.getCar();//汽车
			j++;
		}%>
		
		<div class="show">一共有 <%=dealData.length %>个客户</div>
		<br/>
		<div class="show">最终输出： </div>
		<br/>
		<% for(int k=0;k<j;k++){  
	//	 System.out.println("i得长度："+i.length);
	//	 System.out.println("k："+k);
		 
		 %>
		<div class="show">第<%=i[k] %>"条路线：<span><%=way[k] %></span></div>
			
		<div class="show">	行驶里程：<span><%=weight[k] %></span></div>
			
		<div class="show">选用的货车是：<span>><%=car[k]%></span></div>
		<% }
		%>
	  </br>
		<div class="show">总形式里程：<span><%=dealData.Routecount%></span></div>
		</div>
		</div>

	
</body>
</html>