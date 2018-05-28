<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入jquery -->
<script type="text/javascript" src="static/js/jquery-3.1.1.min.js">
</script>

<!--  引入样式-->
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script> 

</head>
<body>
hello word!
<form action="/ssm_base/person/list" method="post">
账号：<input type="text" name="user" >
<input type="submit" class="btn btn-info" value="提交">
</form>
</body>
</html>