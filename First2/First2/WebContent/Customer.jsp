<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="shape.css">
</head>
<style type="text/css">
.ctn{ text-align: center;}
</style>
<body>
	<form class="form" action="" onsubmit="return submitCheck();">
	<div align="center">
	<br/><br/>
	请输入客户名称: <input type="text" name="Cname" id="Cname"><br/>
	<br/>
	输入客户需求量: <input type="text" name="Cnumber" id="Cnumber"><br/>
	<br/>
	输入客户横坐标: <input type="text" name="Left" id="Left"><br/>
	<br/>
	输入客户纵坐标: <input type="text" name="Right" id="Right"><br/>
	<br/><br/>
	<input type="submit" class="ctn" onclick="javascript:this.form.action='CustomerServlet';" value="提交"><br/></div>
	</form>
<script>
    function submitCheck(){
 
        //获取表单对象
        var cname=document.getElementById("Cname");
        var cnumber=document.getElementById("Cnumber");
        var left=document.getElementById("Left");
        var right=document.getElementById("Right");
 
        //验证项目是否为空
        if(cname.value==='' || cname.value===null){
            alert("客户名称不能为空！");
            return false;
        } else if(cnumber.value==='' || cnumber.value===null){
            alert("客户需求量为空！");
            return false;
        } else if(left.value==='' || left.value===null){
            alert("客户横坐标不能为空！");
            return false;
        } else if(right.value==='' || right.value===null){
            alert("客户纵坐标不能为空！");
            return false;
        } 
        return true;
    }
    
</script>
</body>
</html>

