<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter your name</title>
</head>
<body>
	<s:form action="sayhello" method="POST">
		<s:textfield name="userId" label="Your name:" />
		<s:textfield name="password" label="Password:" />
		<s:submit />
	</s:form>
</body>
</html>