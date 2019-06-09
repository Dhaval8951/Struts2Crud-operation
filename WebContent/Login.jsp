<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/Forms.css"
	type="text/css" rel="stylesheet" />
<script
	src="${pageContext.request.contextPath}/resources/validation2.js"
	type="text/javascript"></script>

<link href="${pageContext.request.contextPath}/resources/Custom.css"
	type="text/css" rel="stylesheet" />
</head>
<body class="center">

	<table>

		<s:form action="ValidateUserLogin" id="myForm"
			onsubmit="return LoginDetails()">
			<tr>
				<s:textfield name="email" id="email" label="Enter User Email"></s:textfield>
			</tr>
			<tr>
				<s:password name="pass" id="pass" label="Enter Password"></s:password>
			</tr>
			<tr>

				<td><s:submit value="Login" id="login"></s:submit></td>

			</tr>

		</s:form>
		<s:actionerror cssClass="isa_error" />

	</table>
	<a href="RegisterAction?from=Report"><button>Register</button> </a>
</body>
</html>