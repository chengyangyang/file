<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网页模糊查询</title>
<style>
#div01 {
	border: 1px solid;
	width: 170px;
	display: none;
}
</style>

<script>
	var xml;
	var div01;
	function checkmessage() {
		var username = document.getElementById("username").value;//得到username中的值
		div01 = document.getElementById("div01");//获得一个地址
		if (username == "") {//如果没有这一步，当输入的值删掉都，还有模糊查询
			div01.style.display = "none";
		} else {
			xml = new XMLHttpRequest();//创建一个对象
			var url = "queryServlet?search=" + username;//创建一个url地址
			var method = "post";//创建一个post
			xml.open(method, url, true);//初始化http 参数
			xml.onreadystatechange = returnmessage;//存有服务器响应的函数
			xml.send(null); //发送 HTTP 请求，使用传递给 open() 方法的参数，以及传递给该方法的可选请求体。
			div01.innerHTML = "";//每输入一次就进行清空一下，否则在模糊查询中就会出现重复
		}
	}
	function returnmessage() {
		if (xml.status == 200 && xml.readyState == 4) {//同时满足时，则响应完成
			var message = xml.responseXML;//函数从PHP页面得到XML形式的数据
			var node = message.getElementsByTagName("word");//获得节点的名称  返回的应该为一个数组
			if (node.length > 0) {
				for (var i = 0; i < node.length; i++) {//不要将i的值写成int型
					var result = node[i].firstChild.nodeValue;//获得节点的值

					var childDiv = document.createElement("div");//创建一个div形式的元素

					childDiv.onmousemove = function() {//鼠标在上面显红色
						this.style.background = "red";

					}
					childDiv.onmouseout = function() {//鼠标移开呈现白色
						this.style.background = "white";
					}
					childDiv.onclick = function() {//鼠标点击
						var username = document.getElementById("username");
						username.value = this.innerHTML;
						div01 = document.getElementById("div01");
						div01.innerHTML = "";
						div01.style.display = "none";
					}
					childDiv.innerHTML = result;//将结果放到模糊查询中
					div01.appendChild(childDiv);//将创建的div加入到这个div中
				}
			}
			div01.style.display = "block";//显示
		}
	}
</script>
</head>
<body>
	<input type="text" name="user" id="username" onkeyup="checkmessage()">搜索
	<br />
	<!--name 中的名字和id中的名字不能相同，也不能不写name 否则就会发生冲突  -->
	<div id="div01"></div>
	<!-- 创建一个模糊查询的元素地址 -->


</body>
</html>