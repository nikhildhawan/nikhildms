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

.version-box {
	width: 500px;
	border: 1px solid #8ED17C;
	align: center;
	padding: 25px 18px;
	margin-top: 65px;
	margin-left: auto;
	margin-right: auto;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
}
.th-header {width: 150px;font-size: 28px;font-weight: normal;color: #479332;	line-height: 32px;margin: 25px 0 18px 0;padding: 0 0 4px;	background-color:transparent;border: none;	border-bottom:1px solid #CCCCCC; }
.td-data ,.td-download {vertical-align: text-top;;font-size: 16px;font-weight: normal;color: #479332;line-height: 20px;margin: 25px 0 18px 0;padding: 0 0 4px;background-color: transparent;border: none;}
.td-download .dlimage{vertical-align:sub;}
.td-data:hover {	background:#f2f7ff; }
.td-data .share {display:none;}
.td-data:hover .share {display:inline-block;cursor: pointer;}
.td-data .delete {display:none;}
.td-data:hover .delete {display:inline-block;cursor: pointer;}
.td-data .comment {display:none;}
.td-data:hover .comment {display:inline-block;cursor: pointer;}
.td-data .sharedby {display:none;}
.td-data:hover .sharedby {display:inline-block;cursor: default;}
</style>
</head>
<body>

	<s:action name='addcompactheader' executeResult='true' />
	<div class="version-box">
		<font color="red"><s:actionerror />
		<s:fielderror /></font>
		<table style="position: relative;float: center;top: 20px;">
					<tr>
						<th class="th-header" style="width:500px;">Files</th>
						<th class="th-header">Version</th>
					</tr>
<%-- 					<% if(session.getAttribute("usercurrentdirid") != session.getAttribute("userrootdirid")) { System.out.println("current folder id:"+session.getAttribute("usercurrentdirid")+": and root id:"+session.getAttribute("userrootdirid")+": are different"); %> --%>
					<tr>
					<td  class="td-data" style="width: 500px; color:peru"><img	src="/Struts2Example/media/images/go-to-parent.gif" />&nbsp&nbsp<a href="homepage?option=changedirectory&currentfid=<%= session.getAttribute("usercurrentdirid") %> "><s:property value="foldername"/></a></td>
					</tr>
<%-- 					<%	} %> --%>
					<s:iterator value="allversions">
						<tr>
							<td class="td-data" style="width: 500px"><s:property	value="filename" />
								<span class="share"  onclick="location.href='/Struts2Example/jsp/Sharefile.jsp?sharedfileid=<s:property value="fileid" />&filename=<s:property value="filename" />' ">&nbsp;&nbsp;&nbsp;&nbsp;<img src="/Struts2Example/media/images/sharing.gif" title="Share this file"></span>
								<span class="comment"  >&nbsp;&nbsp;&nbsp;&nbsp;<a href="comment?fileid=<s:property value="fileid" />"><img src="/Struts2Example/media/images/commentsmall.png" title="View Comments"></a></span>
								<span class="delete"   >&nbsp;&nbsp;&nbsp;&nbsp;<a href="deletefile?fileid=<s:property value="fileid" />"><img src="/Struts2Example/media/images/delete.gif" title="Delete File"></a></span>
							</td>
							
							<td class="td-download"><a href="downloadfile?fileid=<s:property value="fileid" />"><img class="dlimage" src="/Struts2Example/media/images/dl_original.png" title="Download this Version"><s:property value="version" /></a></td>
						</tr>
					</s:iterator>
				</table>
	</div>
</body>
</html>