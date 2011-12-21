<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:action name='addcompactheader' executeResult='true' />




<div id="SignUpPanel" class="span-14 suffix-1 free">
	<h1>Sign Up</h1>
	<p style="margin-bottom:24px;color: rgb(102, 102, 102); font-size: 16px; font-weight:bold;">
		Once you create your account, you will be able to manage all of your folders and documents from one central location.
	</p>
	<s:form class="form" id="AccountForm" style="margin:0 0 30px 0;">
		<div id="AccountPanel">
			<!--
			<h4>Pick a user name</h4>
			-->
			<table>
				<tbody>
					<tr><td class="label">User name:</td><td><input type="text" class="username" name="username" value="" id="Username"></td></tr>
					<tr><td>Email:</td><td><input type="text" name="email" value="" id="Email"></td></tr>
					<tr><td>Password:</td><td><input type="password" name="password" class="password" value="" id="Password"></td></tr>
					<tr><td>Confirm password:</td><td><input type="password" class="password2" name="password2" value="" id="Password2"></td></tr>
				</tbody>
			</table>
		</div>
	</s:form>
</div>
</body>
</html>