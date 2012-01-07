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
	href="/Struts2Example/media/css/screen.css?v=12201316" type="text/css" 	media="screen, projection">
<title>SendMeFirst.com | Search</title>
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
.search-image{background:url(/Struts2Example/media/images/newgoogle.png) no-repeat center center;height:150px;width:450px;margin-left: auto;margin-right: auto; }
.search-text{padding: 0;	border: none;	background-color: transparent; font-weight: bold;width: 500px;height: 25px;margin-left: auto;margin-right: auto}
.search-box {	width: 800px;height:200px;		align: center;	padding: 25px 18px;	margin-top: 65px;	margin-left: auto;	margin-right: auto;}
.searchbutton1{ width: 96px ;height:29px; padding: 20px;margin-right: 20px;margin-left: 130px}
.searchbutton2{ width: 130px;height:29px; padding: 20px;;margin-left: 20px}
.searchresults {width: 1000px;align: center;padding: 25px 18px;margin-top: 65px;margin-left: auto;margin-right: auto;}
.searchresults .th-header {width: 150px;font-size: 28px;font-weight: normal;color: #479332;	line-height: 32px;margin: 25px 0 18px 0;padding: 0 0 4px;	background-color:transparent;border: none;	border-bottom:1px solid #CCCCCC; }
.searchresults .td-data {		font-size: 16px;font-weight: normal;color: #479332;line-height: 20px;margin: 25px 0 18px 0;padding: 0 0 4px;background-color: transparent;border: none;}
.searchresults .td-data:hover {	background:#f2f7ff; }
</style>
</head>
<body>
<% if(session.getAttribute("userkey")==null){ response.sendRedirect("/Struts2Example/jsp/Login.jsp"); } %>
	<s:action name='addcompactheader' executeResult='true' />
<div class="search-box">
<div class="search-image" style="margin-left: auto;margin-right: auto"></div>
<div class="search-text" >
<form class="search-form" action="search" method="post">
<input class="search-text" type="text" name="searchtext"  value="<s:property value="searchtext" />" />
<br><br>
<button class="searchbutton1" type="submit" value="Search" title="Search Files">Search</button>
<button class="searchbutton2" type="submit" value="Search" title="If you are feeling lazy download the first file directly(under construction)">I'm Feeling Lazy</button>
</form>
<div class="searchresults">
<table>
	<s:iterator value="searchfilelist">
		<tr>
			<td class="td-data" style="width: 500px"><s:property	value="filename" /></td>
			<td class="td-data"><a href="downloadfile?fileid=<s:property value="fileid" />">Download</a>
				<span class="comment"  >&nbsp;&nbsp;&nbsp;&nbsp;<a href="comment?fileid=<s:property value="fileid" />"><img src="/Struts2Example/media/images/commentsmall.png" title="View Comments"></a></span>
			</td>
		</tr>
	</s:iterator>
</table>
</div>
</div>
</div>
</body>
</html>