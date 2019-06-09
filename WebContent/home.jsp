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
</head>
<body>
	<table border="2px">
		<thead bgcolor="#00FF00">
			<tr>
				<td>User Name</td>
				<td>Email</td>
				<td>Password</td>
				<td>Designation</td>
				<td colspan="2">Operations</td>

			</tr>
		</thead>

		<s:iterator value="users">
			<s:hidden value="id" />
			<tr>
				<td><s:property value="name" /></td>
				<td><s:property value="email" /></td>
				<td><s:property value="pass" /></td>
				<td><s:property value="deg" /></td>
				<td><a
					href="UpdateAction.action?submitType=retrieve&id=<s:property value="id" />">Update</a></td>
				<td><a href="DeleteAction.action?id=<s:property value="id" />">Delete</a></td>
			</tr>

		</s:iterator>
	</table>
	<a href="LogoutAction">
		<button type="button" id="button-logout">Logout</button>
	</a>
	<a href="SearchUser"><button class="button-register" type="button">Search
			User</button> </a>

</body>
</html>