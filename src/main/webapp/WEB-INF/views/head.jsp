<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.apache.log4j.Logger" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<title>Insert title here</title>
</head>
<body>
	<% Logger loggerHead=Logger.getLogger("infoLog"); %>
	<%loggerHead.info("create head page");%>
	<p align="right">
		<sec:authorize access="isAnonymous()">
			<a href="#" id="getContentLogin">Login/Registration</a>
			<!--  a href="signin">login</a-->
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
		</sec:authorize>
</p>
</body>
</html>