<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	type="text/javascript"></script>

</head>
<body>
	<%-- 	<script type="text/javascript">
		function report() {
			var ajaxRequest;

			ajaxRequest = new XMLHttpRequest();
			var name = document.getElementById("name").value;
			var queryString = "?name=" + name;
			ajaxRequest.onreadystatechange = function() {

				if (this.readyState == 4 && this.status == 200) {
					console.log("done");
				}
			}
			ajaxRequest.open("GET", "SearchUser.action" + queryString, true);
			ajaxRequest.send();
		}
	</script>
 --%>


	<form action="SearchUser" id="myForm">
		<table>
			<tr>

				<td><s:textfield label="Name" name="name"></s:textfield></td>
			</tr>
			<tr>
				<td><input type="submit" value="search" /></td>
			</tr>

		</table>

	</form>
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
	<a href="RegisterAction?from=Report">
		<button type="button" class="button-register">Register</button>
	</a>


</body>
</html>