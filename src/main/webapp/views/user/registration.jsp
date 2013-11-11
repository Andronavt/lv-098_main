<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<script type="text/javascript"
	src="<c:url value="/resources/js/ajax.js" />"></script>
</head>
<body>
	<h3 style="color: green" align="center">Registration</h3>

	<table align="center">

		<tr>
			<th>User name:</th>
			<th><input type="text" id="user_name" /></th>
		</tr>

		<tr>
			<th>First name:</th>
			<th><input type="text" id="first_name" /></th>
		</tr>

		<tr>
			<th>Last name:</th>
			<th><input type="text" id="last_name" /></th>
		</tr>

		<tr>
			<th>E-mail:</th>
			<th><input type="text" id="email" /></th>
		</tr>

		<tr>
			<th>Password:</th>
			<th><input type="password" id="pass" /></th>
		</tr>

		<tr>
			<th><input type="button" value="Registration"
				onclick="doAjaxPostRegistration()" /></th>
		</tr>
		<tr>
			<td colspan="2"><div id="info" style="color: green;"></div></td>
		</tr>
	</table>
</body>
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<script type="text/javascript"
	src="<c:url value="/resources/js/ajax.js" />"></script>

<!-- 	validation -->
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.5.2.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/validation.js" />"></script>
	
<script type="text/javascript"
	src="<c:url value="/resources/js/rulesRegForm.js" />"></script>

<link href="<c:url value="/resources/css/validation.css" />"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<form method="post" id="loginform" action="" name="login-form">
		<fieldset>
			<legend style="color: green" align="left">
				Registration
			</legend>
			
			<div align="left">
			<div align="left">User name:</div><input type="text" id="user_name" name="userName" />
			<div align="left">First name:</div><input type="text" id="first_name" name="firstName" />
			<div align="left">Last name:</div> <input type="text" id="last_name" name="lastName" />
			<div align="left">E-mail:</div><input type="text" id="e-mail" name="email" />
			<div align="left">Password: </div><input type="password" id="pass" name="password" />
			<div id="info" style="color: green;"></div>
			</div>
			
		</fieldset>
		<input id="btn" type="button" name="registration" value="Registration" />
	</form>
	
<script type="text/javascript">
$(document).ready(function() { validateRegForm();});
</script>

</body>
</html>