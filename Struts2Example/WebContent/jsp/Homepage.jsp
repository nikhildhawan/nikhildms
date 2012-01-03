<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SendMeFirst.com | Homepage</title>
<link rel="stylesheet" href="/Struts2Example/media/css/screen.css" type="text/css" />
<style type="text/css">
h1 {	padding: 0;	border: none;	background-color: transparent;	color: #227A0A;	font-weight: bold;}
td {	padding-bottom: 10px;}
td.label {	width: 80px; }

.user-content {width: 1000px;border: 1px solid #8ED17C;align: center;padding: 25px 18px;margin-top: 65px;margin-left: auto;margin-right: auto;-moz-border-radius: 5px;-webkit-border-radius: 5px;}
.user-content .th-header {width: 150px;font-size: 28px;font-weight: normal;color: #479332;	line-height: 32px;margin: 25px 0 18px 0;padding: 0 0 4px;	background-color:transparent;border: none;	border-bottom:1px solid #CCCCCC; }
.user-content .td-data {	font-size: 16px;font-weight: normal;color: #479332;line-height: 20px;margin: 25px 0 18px 0;padding: 0 0 4px;background-color: transparent;border: none;}
.current-folder {font-size: 20px;margin: 0;padding-left: 30px;background: url(/Struts2Example/media/images/folder-large.gif) no-repeat 0px 3px;}
/* background-image: url(http://crocodoc.com/media/images/explorer/folder-large.gif);background-repeat-x: no-repeat;background-repeat-y: no-repeat;background-attachment: initial;background-position-x: 0px;background-position-y: 3px;background-origin: initial;background-clip: initial;background-color: initial; */

</style>
</head>
<body>
	<s:action name='addcompactheader' executeResult='true' />
	<div class="span-24 last">
		<%@ page import="java.util.ArrayList, model.*"%>
		<div class="folder-header">
			<span class="current-folder">Root</span>
			<div class="user-content">
				<a href="/Struts2Example/jsp/Uploadfile.jsp"><img	src="/Struts2Example/media/images/browse.png" /></a>

				<table>
					<tr>
						<th class="th-header" style="width:500px;">Name</th>
						<th class="th-header">Size</th>
					</tr>

					<s:iterator value="directories">
						<tr>
							<td class="td-data" style="width: 500px; color:peru"><img	src="/Struts2Example/media/images/folder.gif" />&nbsp&nbsp<s:property	value="foldername" /></td>
						</tr>
					</s:iterator>
		
					<s:iterator value="files">
						<tr>
							<td class="td-data" style="width: 500px"><s:property	value="filename" /></td>
							<td class="td-data"><a href="downloadfile?fileid=<s:property value="fileid" />">Download</a></td>
						</tr>
					</s:iterator>
					
				</table>
			</div>
		</div>
	</div>
</body>
</html>