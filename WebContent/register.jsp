<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/style.css"
	type="text/css" rel="stylesheet" />
<script
	src="${pageContext.request.contextPath}/resources/validation2.js"
	type="text/javascript"></script>

</head>
<body>


	<s:form action="RegisterAction.action" method="post" class="form"
		id="registrationform" onsubmit=" return validateRegistrationDetails()">
		<s:textfield label="Full Name" name="name" id="name"></s:textfield>
		<s:textfield label="Email" name="email" id="email"></s:textfield>
		<s:password label="Password" name="pass" id="pass"></s:password>
		<s:textfield label="User Designation" name="deg" id="deg"></s:textfield>
		<s:submit value="Register" cssClass="button-register"></s:submit>
	</s:form>
	<s:if test="isRegistered==true">
		<span style="color: green;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>

<!-- 	<a href="ReportAction"><button class="button-register"
			type="button">All Users</button> </a>
	<a href="SearchUser"><button class="button-register" type="button">Search
			User</button> </a>
 --></body>
</html>