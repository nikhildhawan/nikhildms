<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<%		
		response.setHeader("Cache-Control","no-store"); // HTTP 1.1 
		response.setHeader("Pragma","no-cache"); //HTTP 1.0 
		response.setHeader("Expires","0");
		response.setDateHeader ("Expires", -1); 
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="/Struts2Example/media/css/screen.css?v=12201316" type="text/css"
	media="screen, projection">
<title>SendMeFirst.com | Create New Folder</title>
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

.createfolder-box {
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
	<div class="createfolder-box">
		<font color="red"><s:actionerror />
		<s:fielderror /></font>
		<s:form action='homepage?option=newfolder' method='post' style="margin-top:25px;">
			<h1 style="margin: 0 0 15px; font-size: 24px; padding-bottom: 10px; border-bottom: 2px solid #44a62a;">Create New Folder</h1>
			<table>
				<tbody>
					<tr>
						<td><s:textfield name="newfoldername" value="" id="newfoldername"	label="Enter Folder name" /></td>
					</tr>
				</tbody>
			</table>

			<div style="margin: 0;">
				<input type="submit" value="Create" style="padding: 2px 12px;" /> 
			</div>
		</s:form>
	</div>



</body>
</html>