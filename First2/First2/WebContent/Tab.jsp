<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Tab</title>
    <style type="text/css">
        <!--
        * {
            margin: 0; padding:0
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
        #container #title {
            height: 28px;
        }
        #container #title li {
            float: left;
            list-style-type: none;
            height: 28px;
            line-height: 28px;
            text-align: center;
            margin-right: 1px;
        }
        #container #title ul {
            height: 28px;
        }
        #container #title a {
            text-decoration: none;
            color: #000000;
            display: block;
            width: auto;
        }
        #container #title a span{
            display: block;
            padding: 0 15px 0 15px;
        }
        #container #title #tag1 a:hover {
            text-decoration: none;
      	    display: block;
            width: auto;
        }
        #container #title #tag1 a:hover span{
            display: block;
            background-color: dodgerblue;
            padding: 0 15px 0 15px;
        }
        #container #title #tag2 a:hover {
            text-decoration: none;
            display: block;
            width: auto;
        }
        #container #title #tag2 a:hover span{
            background-color: dodgerblue;
            display: block;
            padding: 0 15px 0 15px;
        }
        #container #title #tag3 a:hover {
            text-decoration: none;
            display: block;
            width: auto;
        }
        #container #title #tag3 a:hover span{
            background-color: dodgerblue;
            display: block;
            padding: 0 15px 0 15px;
        }
        #container #title #tag4 a:hover {
            text-decoration: none;
            display: block;
            width: auto;
        }
        #container #title #tag4 a:hover span{
            background-color: dodgerblue;
            display: block;
            padding: 0 15px 0 15px;
        }
        #container #title #tag5 a:hover {
       text-decoration: none;
            display: block;
            width: auto;
        }
        #container #title #tag5 a:hover span{
            background-color: dodgerblue;
            display: block;
            padding: 0 15px 0 15px;
        }
        #container #title .selectli1 {
            text-decoration: none;
            color: #ffffff;
            display: block;
            width: auto;
        }
        #container #title a .selectspan1 {
            display: block;
            padding: 0 15px 0 15px;
        }
        #container #title .selectli2 {
            text-decoration: none;
            color: #ffffff;
            display: block;
            width: auto;
        }
        #container #title a .selectspan2 {
            display: block;
            padding: 0 15px 0 15px;
        }
        #container #title .selectli3 {
            text-decoration: none;
            color: #ffffff;
            display: block;
            width: auto;
        }
        #container #title a .selectspan3 {
            display: block;
            padding: 0 15px 0 15px;
        }
        #container #title .selectli4 {
            text-decoration: none;
            color: #ffffff;
            display: block;
            width: auto;
        }
        #container #title a .selectspan4 {
            display: block;
            padding: 0 15px 0 15px;
        }
        #container #title .selectli5 {
            text-decoration: none;
            color: #ffffff;
            display: block;
            width: auto;
        }
        #container #title a .selectspan5 {
            display: block;
            padding: 0 15px 0 15px;
        }
        #container #content ul {margin: 10px;}
        #container #content li {margin: 5px; }
        #container #content li img {margin: 5px;display:block;}
        #container #content {
            height: 320px;
            width: 439px;
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
        .content1 {
         
        }
        .content2 {
           
        }
        .content3 {
            
        }
        .content4 {
    
        }
        .hidecontent {display:none;}
        -->
    </style>
    <script language="javascript">
        function switchTag(tag,content)
        {
//    alert(tag);
//    alert(content);
            for(i=1; i < 6; i++)
            {
                if ("tag"+i==tag)
                {
                    document.getElementById(tag).getElementsByTagName("a")[0].className="selectli"+i;
                    document.getElementById(tag).getElementsByTagName("a")[0].getElementsByTagName("span")
                        [0].className="selectspan"+i;
                }else{
                    document.getElementById("tag"+i).getElementsByTagName("a")[0].className="";
                    document.getElementById("tag"+i).getElementsByTagName("a")[0].getElementsByTagName("span")
                        [0].className="";
                }
                if ("content"+i==content)
                {
                    document.getElementById(content).className="";
                }else{
                    document.getElementById("content"+i).className="hidecontent";
                }
                document.getElementById("content").className=content;
            }
        }
    </script>
</head>
<body>


  <%-- String id_1=(String)request.getAttribute("id");--%>
       <%-- if(id_1=="tag2"){ --%>
    
    	  <%-- }<scripe language="javascript"> switchTag('tag2','content2');</script>--%>
<div id="container">
    <div id="title">
        <ul>
    
    
            <li id="tag1"><a href="?id=1" onclick="switchTag('tag1','content1');this.blur();" class="selectli1"><span
                    class="selectspan1">请输入汽车最大距离限制</span></a></li>
                     
            <li id="tag2"><a href="?id=2"  onclick="switchTag('tag2','content2');this.blur();"><span>请输入卡车信息</span></a></li>
            <li id="tag3"><a href="?id=3" onclick="switchTag('tag3','content3');this.blur();"><span>请输入客户信息</span></a></li>
            <li id="tag4"><a href="?id=4" onclick="switchTag('tag4','content4');this.blur();"><span>开始运算</span></a></li>
        </ul>
    </div>
    
    <div id="content" class="content1">
     
        <div id="content1" ><jsp:include page="Maxdistance.jsp"/></div> 
        <div id="content2" class="hidecontent"><jsp:include page="Trucks.jsp"/></div>
        <div id="content3" class="hidecontent"><jsp:include page="Customer.jsp"/></div>
        <div id="content4" class="hidecontent"><jsp:include page="DealData.jsp"/></div>
    </div>
  <script>
// 获取页面 A 访问的 url
var ur =location.href;
// 获取页面 A 访问的 url 的 = 后面的 数字 （对应着这个页面的 id）
var type=ur.split('?')[1].split("=")[1];
 switchTag('tag'+type,'content'+type);
</script>
</div>
</body>
</html>