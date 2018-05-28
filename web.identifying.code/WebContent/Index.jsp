<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>

function cheak(){
	var img = document.getElementById("img");
	img.src = "imgservlet?a="+new Date();//获得一个变动的启动地址，也就是每次点击都会进行刷新
}

</script>

</head>
<body>
<input type="text"><br/>
<img src="imgservlet" id="img"/><br/>
<a href="#" onclick="cheak()">看不清换一张</a>


</body>
</html>