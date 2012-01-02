<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SendMeFirst.com | Homepage</title>
<link rel="stylesheet" href="/Struts2Example/media/css/screen.css"
	type="text/css" />
<script src="http://cdn.jquerytools.org/1.2.6/full/jquery.tools.min.js"></script>
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

.user-content {
	width: 560px;
	border: 1px solid #8ED17C;
	align: center;
	padding: 25px 18px;
	margin-top: 65px;
	margin-left: auto;
	margin-right: auto;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
}

.user-content .th-header {
	width: 150px;
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

.user-content .td-data {
	font-size: 16px;
	font-weight: normal;
	color: #479332;
	line-height: 20px;
	margin: 25px 0 18px 0;
	padding: 0 0 4px;
	background-color: transparent;
	border: none;
}
</style>
</head>
<body>
	<s:action name='addcompactheader' executeResult='true' />
	<div class="span-24 last" style="padding-bottom: 20px;">
		<!--todo-->
	</div>
	<h1>This is homepage.</h1>
	<h2>
		user logged in is
		<s:property value="%{#session['userkey']}" />
	</h2>
	<%@ page import="java.util.ArrayList, model.*"%>
	<div class="user-content">
		<a href="/Struts2Example/jsp/Uploadfile.jsp"><img
			src="/Struts2Example/media/images/browse.png" /></a>

		<table>

			<tr>
				<th class="th-header">Name</th>
				<th class="th-header">Size</th>
			</tr>

			<s:iterator value="directories">
				<tr>
					<td class="td-data" style="width: 150px"><s:property
							value="foldername" /></td>
				</tr>
			</s:iterator>

			<s:iterator value="files">
				<tr>
					<td class="td-data" style="width: 150px"><s:property
							value="filename" /></td>
				</tr>
			</s:iterator>
		</table>

	</div>
</body>
</html>