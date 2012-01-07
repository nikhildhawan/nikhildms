<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<%		
		response.setHeader("Cache-Control","no-store"); // HTTP 1.1 
		response.setHeader("Pragma","no-cache"); //HTTP 1.0 
		response.setHeader("Expires","0");
		response.setDateHeader ("Expires", -1); 
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SendMeFirst.com | Comments</title>
<link rel="stylesheet"
	href="/Struts2Example/media/css/screen.css?v=12201316" type="text/css"
	media="screen, projection">
</head>
<body>
<% if(session.getAttribute("userkey")==null){ response.sendRedirect("/Struts2Example/jsp/Login.jsp"); } %>
<style type="text/css">
.comment-box {	width: 550px;border: 1px solid #8ED17C;	float: center;	padding: 25px 18px;	margin-top: 65px;	margin-left: auto;	margin-right: auto;	-moz-border-radius: 5px;	-webkit-border-radius: 5px;}
.comment-text{width: 500px;height: 25px;margin-left: auto;margin-right: auto}
.commentbutton{ width: 150px ;height:29px; padding: 20px;margin-right: auto;margin-left: auto}
h5 {margin:1px}
h6 {margin:1px;color: black;margin-left: 20px}
</style>
	<s:action name='addcompactheader' executeResult='true' />
	<div class="comment-box">
	<table>
		<s:iterator value="filemetadata">
		<tr>
			<td><h5>Name: <s:property value="filename"/></h5></td>
		</tr>
		<tr>
			<td><h5>Size:&nbsp; <s:property value="filesize"/> KB </h5></td>
		</tr>
		<tr>
			<td><h5>Type: <s:property value="filetype"/></h5> </td>
		</tr>
		</s:iterator>
	</table>
	<form class="search-form" action="comment" method="post">
		<input class="comment-text" type="text" name="commenttext"  value="Enter Your Comment"  onfocus="this.value=''"/>
		<input name="intfileid" type="hidden" value="<s:property value='intfileid' />">
		<br><br>
		<button class="commentbutton" type="submit" value="Post">Post Comment</button>
	</form>
	<br><br><br><br><br><br>
	<table>
		<s:iterator value="commentlist">
		<tr>
			<td>
				<h5>
			by <s:property value="username"/>  at <s:property value="timestamp"/>
				</h5> 
			</td>
		</tr>
		<tr>
			<td>
				<h6 ><s:property value="comment"/></h6>
			</td>
		</tr>
		</s:iterator>
	
	
	</table>
	
	</div>


</body>
</html>