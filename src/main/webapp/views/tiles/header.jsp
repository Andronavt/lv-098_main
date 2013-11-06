<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false"%>
<script type="text/javascript"
	src="<c:url value="/resources/js/content.js" />"></script>
<p align="right">

	<sec:authorize access="isAnonymous()">
    Welcome! Guest
   </sec:authorize>
	<sec:authorize access="isAuthenticated()">
   Welcome! <sec:authentication property="principal.username" />
	</sec:authorize>


	<sec:authorize access="isAnonymous()">
		<a href="#" id="getContentLogin">Login/Registration</a>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
	</sec:authorize>
</p>
<script>
	$(document).ready(function() {
		$('#getContentLogin').click(function() {
			getContentLogin();
		});
	});
</script>

<!-- </body> -->
<!-- </html> -->