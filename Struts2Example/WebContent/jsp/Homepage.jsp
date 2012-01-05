<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script src='jquery.js' type='text/javascript'></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SendMeFirst.com | Homepage</title>
<link rel="stylesheet" href="/Struts2Example/media/css/screen.css" type="text/css" />
<style type="text/css">
h1 {	padding: 0;	border: none;	background-color: transparent;	color: #227A0A;	font-weight: bold;}
td {	padding-bottom: 10px;}
td.label {	width: 80px; }
.meter-wrap{float:right;	position: relative;	border-radius: 10px;-moz-border-radius: 10px;	-webkit-border-radius: 10px;margin-top: 20px;	margin-left: 20px;}
.meter-wrap #usagetext{display:none;color: #479332;font-size: 13px;}
.meter-wrap:hover #usagetext {display:inline-block;color: #479332;font-size: 15px;}
.meter-wrap, .meter-value, .meter-text {	width: 180px; height: 30px;-webkit-border-top-left-radius: 10px;-webkit-border-bottom-left-radius: 10px;-moz-border-radius-topleft: 10px;	-moz-border-radius-bottomleft: 10px;	border-top-left-radius: 10px;	border-bottom-left-radius: 10px;}
.meter-wrap, .meter-value {	background: #bdbdbd;}
.meter-text {	position: absolute;top:0; left:0;padding-top: 5px;color: #fff;text-align: center;	width: 100%;}
.user-content {width: 1000px;border: 1px solid #8ED17C;align: center;padding: 25px 18px;margin-top: 65px;margin-left: auto;margin-right: auto;-moz-border-radius: 5px;-webkit-border-radius: 5px;}
.user-content .th-header {width: 150px;font-size: 28px;font-weight: normal;color: #479332;	line-height: 32px;margin: 25px 0 18px 0;padding: 0 0 4px;	background-color:transparent;border: none;	border-bottom:1px solid #CCCCCC; }
.user-content .td-data ,.td-download {font-size: 16px;font-weight: normal;color: #479332;line-height: 20px;margin: 25px 0 18px 0;padding: 0 0 4px;background-color: transparent;border: none;}
.user-content .td-data:hover {	background:#f2f7ff; }
.user-content .td-data .share {display:none;}
.user-content .td-data:hover .share {display:inline-block;cursor: pointer;}
.user-content .td-data .sharedby {display:none;}
.user-content .td-data:hover .sharedby {display:inline-block;cursor: default;}
.current-folder {font-size: 20px;margin-bottom:10px ;padding-left: 30px;background: url(/Struts2Example/media/images/folder-large.gif) no-repeat 0px 3px;}
.share-box{display: none}

/* background-image: url(http://crocodoc.com/media/images/explorer/folder-large.gif);background-repeat-x: no-repeat;background-repeat-y: no-repeat;background-attachment: initial;background-position-x: 0px;background-position-y: 3px;background-origin: initial;background-clip: initial;background-color: initial; */

</style>
</head>
<body>
<% if(session.getAttribute("userkey")==null){ response.sendRedirect("/Struts2Example/jsp/Login.jsp"); } %>
	<s:action name='addcompactheader' executeResult='true' />

		<%@ page import="java.util.ArrayList, model.*"%>

			
			<div class="user-content">
				<div class="meter-wrap">
				    <div class="meter-value" style="background-color: #0a0; width:<%=session.getAttribute("percent") %>%;">
				        <div class="meter-text">
				            <%=session.getAttribute("percent") %>%
				        </div>
				    </div>
				    <span id="usagetext"><%=session.getAttribute("usage") %> MB of 50 MB Used</span>
				</div>
				<div class="folder-header">
					<span class="current-folder"><%=session.getAttribute("usercurrentdirid") %></span>
				</div>
				
				<style type="text/css">
	.toolbar button span { padding-bottom:2px; line-height:15px; }
	#AddDocBtn, #UploadSplitBtn { display:inline-block;float:none;text-decoration: none;}
	#UploadSplitBtn { padding-right:4px; padding-left:4px; width:20px; }
	#AddDocBtn span { padding-left:20px; padding-right:4px; background:url(/Struts2Example/media/images/upload.gif) no-repeat 0px 0px; ;text-decoration: none;}
	.toolbar .has-subnav { float:left; height:13px; width:10px;
		background:url(/media/images/explorer/dropdown-arrow.gif) no-repeat center -2px; }
	.new-folder span { padding-left:20px; background:url(/Struts2Example/media/images/create-folder.gif) no-repeat 0px 0px; ;text-decoration: none;}
	
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
				<div class="toolbar buttons">
				<a href="/Struts2Example/jsp/Uploadfile.jsp"><button id="AddDocBtn" class="gray-button"><span>Add Document</span></button></a>
				<a href="homepage?option=newfolder"><button class="new-folder gray-button"><span>New Folder</span></button></a>
				<a href="/Struts2Example/jsp/Search.jsp"><button class="search gray-button"><span>Search Files</span></button></a>
				</div>
				<div class="listview selectable" style="min-height: 36px;position: relative ">
				<s:actionerror/>
				<table style="position: relative;float: center;top: 20px;">
					<tr>
						<th class="th-header" style="width:500px;">Name</th>
						<th class="th-header">Download</th>
					</tr>
					<% if(session.getAttribute("usercurrentdirid") != session.getAttribute("userrootdirid")) { System.out.println("current folder id:"+session.getAttribute("usercurrentdirid")+" and root id"+session.getAttribute("userrootdirid")+" are different"); %>
					<tr>
					<td  class="td-data" style="width: 500px; color:peru"><img	src="/Struts2Example/media/images/go-to-parent.gif" />&nbsp&nbsp<a href="homepage?option=parentdirectory&currentfid=<%= session.getAttribute("usercurrentdirid") %> ">Parent Folder </a></td>
					</tr>
					<%	} %>
					<s:iterator value="directories">
						<tr>
							<td class="td-data" style="width: 500px; color:peru"><img	src="/Struts2Example/media/images/folder.gif" />&nbsp&nbsp<a href="homepage?option=changedirectory&currentfid=<s:property value="folderid" />"><s:property	value="foldername" /></a></td>
						</tr>
					</s:iterator>
					<s:iterator value="files">
						<tr>
							<td class="td-data" style="width: 500px"><s:property	value="filename" /><span class="share"  style="color:blue" onclick="location.href='/Struts2Example/jsp/Sharefile.jsp?fileid=<s:property value="fileid" />&filename=<s:property value="filename" />' ">&nbsp&nbspshare this file</span></td>
							
							<td class="td-download"><a href="downloadfile?fileid=<s:property value="fileid" />">Download</a></td>
						</tr>
					</s:iterator>
				</table>
				</div>
				<div class="shared">
					<br><br><br>
					<hr>
					<h3>Files shared by other users</h3>
					<table>
					<s:iterator value="sharedfiles">
						<tr>
							<td class="td-data" style="width: 500px"><s:property	value="filename" /><span class="sharedby"  style="color:blue" >&nbsp&nbspshared by <s:property	value="filetype" /></span></td>
							<td class="td-data"><a href="downloadfile?fileid=<s:property value="fileid" />&shareduid=<s:property value="filesize" />">Download</a></td>
						</tr>
					</s:iterator>
					</table>
				</div>
			</div>

</body>
</html>