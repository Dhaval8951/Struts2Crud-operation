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

	<s:property value="msg" />
	<br>
	<br>
	<a href="ReportAction">
		<button type="button" class="button-register">Report</button>
	</a>
</body>
</html>