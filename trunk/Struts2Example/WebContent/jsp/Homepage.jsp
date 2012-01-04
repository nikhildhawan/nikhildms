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
			<span class="current-folder"><%=session.getAttribute("usercurrentdirid") %></span>
			<div class="user-content">
			
				
				<style type="text/css">
	.toolbar button span { padding-bottom:2px; line-height:15px; }
	#AddDocBtn, #UploadSplitBtn { display:inline-block; }
	#UploadSplitBtn { padding-right:4px; padding-left:4px; width:20px; }
	#AddDocBtn span { padding-left:20px; padding-right:4px; background:url(/Struts2Example/media/images/upload.gif) no-repeat 0px 0px; }
	.toolbar .has-subnav { float:left; height:13px; width:10px;
		background:url(/media/images/explorer/dropdown-arrow.gif) no-repeat center -2px; }
	.new-folder span { padding-left:20px; background:url(/Struts2Example/media/images/create-folder.gif) no-repeat 0px 0px; }
	
	.toolbar .edit-sharing span { padding-left:20px; background:url(/Struts2Example/media/images/folder-shared.gif) no-repeat 0px 0px; }
	.at-home .edit-sharing { display:none; }
	.sub-has-perms .edit-sharing { color:#999; }
	
	.toolbar .new-shared-folder span { padding-left:20px; background:url(/Struts2Example/media/images/folder-shared.gif) no-repeat 0px 0px; }
	.new-shared-folder { display:none; }
	.at-home .new-shared-folder { display:inline-block; }
	
	.toolbar .delete-all-selected span { padding-left:20px; background:url(/Struts2Example/media/images/delete.gif) no-repeat 0px 0px; }
	.delete-all-selected { display:none; }
	.single-selected .delete-all-selected { display:inline-block; }
	
	.toolbar ul { margin:0; }
	.toolbar .subnav { z-index:10; position:absolute; left:0; top:23px; background:#F5F5F5; display:none; border: 1px solid #D1D1D1; }
	.toolbar .subnav li { width:160px; margin:0; padding:2px 0 2px 4px; list-style:none; position:relative; z-index:10; cursor:pointer; }
	.toolbar .subnav li:hover { background-color:#f2f7ff; }
	.toolbar .subnav li span { padding-bottom:2px; }
	.toolbar .subnav .upload { padding-left:20px; background:url(/Struts2Example/media/images/upload.gif) no-repeat 0px 0px; }
	.toolbar .subnav .url { padding-left:20px; background:url(/Struts2Example/media/images/internet.gif) no-repeat 0px -2px; }
	
	.ui-dialog-titlebar { display:none !important; }
	.ui-dialog { border-width: 6px !important; }
	.ui-widget-content { background: white !important; }
	
	#UploadButton { position:absolute; width:1px; height:1px; top:23px; left:1px; }
	
	.plupload, .plupload input { cursor: pointer; }
	
	.gray-button.left-split {border-top-right-radius: 0;border-bottom-right-radius: 0;-moz-border-radius-topright: 0;-moz-border-radius-bottomright: 0;-webkit-border-top-right-radius: 0;-webkit-border-bottom-right-radius: 0;margin-right:0;padding-right:0;}
	.gray-button.right-split {border-top-left-radius: 0;border-bottom-left-radius: 0;-moz-border-radius-topleft:0;-moz-border-radius-bottomleft: 0; -webkit-border-top-left-radius: 0; -webkit-border-bottom-left-radius: 0;margin-left:-1px;padding-left:0;padding-right:0;}
</style>
				<div id="UploadButton"></div>
				<a href="/Struts2Example/jsp/Uploadfile.jsp"><button id="AddDocBtn" class="gray-button"><span>Add Document</span></button></a>
				<a href="homepage?option=newfolder"><button class="new-folder gray-button"><span>New Folder</span></button></a>
				<div></div>
				<table>
					<tr>
						<th class="th-header" style="width:500px;">Name</th>
						<th class="th-header">Download</th>
					</tr>

					<s:iterator value="directories">
						<tr>
							<td class="td-data" style="width: 500px; color:peru"><img	src="/Struts2Example/media/images/folder.gif" />&nbsp&nbsp<a href="homepage?option=changedirectory&currentfid=<s:property value="folderid" />"><s:property	value="foldername" /></a></td>
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