<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function(e) {
		$("#contactEmail").blur(function(event) {
			$("#dupEmail").html("");
			var emailId = $("#contactEmail").val();
			$.ajax({
				url : 'validateEmail?email=' + emailId,
				success : function(abc) {
					if (abc == 'Duplicate') {
						$("#dupEmail").html("Email already registered");
						$("#contactEmail").focus();
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<h1 align="center">Contact Form</h1>
	<p style="color: green" align="center">${sucMsg}</p>
	<p style="color: red" align="center">${errMsg}</p>
	<form:form action="registration" id="registration" modelAttribute="contact" method="POST">
		<table align="center">
			<tr>
				<td><form:hidden path="contactId" /></td>
			</tr>
			<tr>
				<td>Contact Name</td>
				<td><form:input path="contactName"  /></td>
			</tr>
			<tr>
				<td>Contact Email</td>
				<td><form:input path="contactEmail" />
				<font color='red'>
						<div id="dupEmail"></div>
					</font>	</td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><form:input path="contactNumber"  /></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
		<p align="center">
			<a href="viewAllContacts">View All Contacts</a>
		</p>
	</form:form>
</body>
</html>

