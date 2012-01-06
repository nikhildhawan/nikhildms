<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SendMeFirst.com | Share File</title>
<link rel="stylesheet" href="/Struts2Example/media/css/screen.css" type="text/css" />
</head>
<body>
<% if(session.getAttribute("userkey")==null){ response.sendRedirect("/Struts2Example/jsp/Login.jsp"); } %>
	<s:action name='addcompactheader' executeResult='true' />
	<style type="text/css">
h1 {
	font-size: 28px;
	font-weight: normal;
	color: #479332;
	line-height: 32px;
	margin: 25px 0 18px 0;
	padding: 0 0 4px;
	background-color: transparent;
	border: none;
	border-bottom: 1px solid #CCCCCC;
}

.share-box {
	width: 550px;
	border: 1px solid #8ED17C;
	float: center;
	padding: 25px 18px;
	margin-top: 65px;
	margin-left: auto;
	margin-right: auto;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
}

td {
	padding-bottom: 10px;
}

td.label {
	width: 80px;
}
</style>
	<div class="share-box">
		<s:actionerror />
		<s:fielderror />
		<s:form action='sharefile'   method='post' style="margin-top:25px;" >
			<h1	style="display:inline-block;margin: 0 0 15px; font-size: 24px; padding-bottom: 10px; border-bottom: 2px solid #44a62a;">Share&nbspFile</h1>
			<input type="hidden" name="sharedfileid" value="<%=request.getParameter("sharedfileid") %>">
			<input type="hidden" name="filename" value="<%=request.getParameter("filename") %>">
			<table>
				<tbody>
					<tr>
						<td><h2>File Name:</h2><h2 style="font-size: 10"><i><%=request.getParameter("filename") %></i></h2></td>
					</tr>
					<tr>
					<s:textfield name="shareuser" label="Enter Username" />
					</tr>
				</tbody>
			</table>

			<div style="margin: 0;">
				<input type="submit" value="Share File" style="padding: 2px 12px;" />
			</div>
		</s:form>
	</div>
</body>
</html>