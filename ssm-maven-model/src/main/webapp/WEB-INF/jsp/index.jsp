<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/success?locale=zh_CN">中文</a> <br> 
<a href="${pageContext.request.contextPath}/success?locale=en_us">英文</a><br>  
	<form:form modelAttribute="tblUser" action="success" method="Post">
		id:<form:input path="id" id="id"/><form:errors path="id"></form:errors><br>
		name:<form:input path="name" id="name"/><form:errors path="name"></form:errors><br>
		email:<form:input path="email" id="email"/><form:errors path="email"></form:errors><br>
		date:<form:input path="date" id="date"/><form:errors path="date"></form:errors><br>
	<input type="submit" value="submit">
	</form:form>
</body>
</html>