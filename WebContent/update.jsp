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

	<s:form action="UpdateAction.action" method="post">
		<table>


			<input type="hidden" name="id" value='<s:property value="id"/>'>

			<tr>
				<td>Name</td>
				<td><input type="text" name="name"
					value='<s:property value="name"/>'></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"
					value='<s:property value="email"/>'></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pass"
					value='<s:property value="pass"/>'></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><input type="text" name="deg"
					value='<s:property value="deg"/>'></td>
			</tr>
		</table>
		<button name="submitType" class="button-register" value="update" type="submit">Update</button>
	</s:form>

	<a href="ReportAction">
		<button type="button" class="button-register">Report</button>
	</a>

</body>
</html>