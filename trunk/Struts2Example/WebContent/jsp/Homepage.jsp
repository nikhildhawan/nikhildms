<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SendMeFirst.com</title>
<link rel="stylesheet" href="/Struts2Example/media/css/screen.css" type="text/css" media="screen, projection" /> 
<script src="http://cdn.jquerytools.org/1.2.6/full/jquery.tools.min.js"></script>
</head>
<body>
<s:action name='addcompactheader' executeResult='true' />
<div class="span-24 last" style="padding-bottom:20px;">
	<!--todo-->
</div>
<h1>This is homepage.</h1>
<h2> user logged in is <s:property value="%{#session['userkey']}"/></h2>
<%@ page import="java.util.ArrayList, model.*"  %>

<table>
<tr> 
</tr>

<s:iterator value="directories" >
<tr>
<td> <s:checkbox name="checkbox" /></td>
<td> <s:property value="foldername" /></td>
</tr>
</s:iterator>

</table>


</body>
</html>