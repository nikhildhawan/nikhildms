<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="/Struts2Example/media/css/screen.css?v=12201316" type="text/css"
	media="screen, projection">
<title>SendMeFirst.com | Login</title>
<style type="text/css">
h1 {
	padding: 0;
	border: none;
	background-color: transparent;
	color: #227A0A;
	font-weight: bold;
}

td {
	padding-bottom: 10px;
}

td.label {
	width: 80px;
}

.login-box {
	width: 380px;
	border: 1px solid #8ED17C;
	align: center;
	padding: 25px 18px;
	margin-top: 65px;
	margin-left: auto;
	margin-right: auto;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
}
</style>
</head>
<body>

	<s:action name='addcompactheader' executeResult='true' />
	<div class="login-box">
		<s:actionerror />
		<s:fielderror />
		<s:form action='sayhello' method='post' style="margin-top:25px;">
			<h1 style="margin: 0 0 15px; font-size: 24px; padding-bottom: 10px; border-bottom: 2px solid #44a62a;">Login</h1>
			<table>
				<tbody>
					<tr>
						<td><s:textfield name="username" value="" id="username"
								label="Username" /></td>
					</tr>
					<tr>
						<td><s:password name="password" value="" id="password"
								label="Password" /></td>
					</tr>
				</tbody>
			</table>

			<div style="margin: 0;">
				<input type="submit" value="Login" style="padding: 2px 12px;" /> <input
					type="hidden" name="next" value="/accounts/profile/" />
				<div style="float: right; padding-top: 5px; text-align: right;">
					<a id="Forget" href="/accounts/password/reset/">Forgot password?</a><br />
						<a id="Forget" href="/Struts2Example/jsp/Register.jsp">Create an account now!</a>
				</div>
			</div>
		</s:form>
	</div>



</body>
</html>