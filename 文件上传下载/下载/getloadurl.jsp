<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <!-- 遍历Map集合 -->

 <c:forEach var="up" items="${fileNameMap}">
	 <c:url value="dowload" var="downurl">
		<c:param name="filename" value="${up.key}"></c:param>
	</c:url> 
	 <br /> 
 <form action="${downurl}" method="post">
 ${up.value}
 <input type="submit" value="提交">
 </form>
 
</c:forEach> 

</body>
</html>