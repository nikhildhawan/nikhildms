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
<title>SendMeFirst.com | Share File</title>
<link rel="stylesheet" href="/Struts2Example/media/css/screen.css" type="text/css" />
</head>
<body>
<%-- <% if(session.getAttribute("userkey")==null){ response.sendRedirect("/Struts2Example/jsp/Login.jsp"); } %> --%>
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
		<div class="two-tiers">
			<div class="content-title">
				<h1>Error 404 - We are Sorry but this page doesn't exist !</h1>
			</div>
			
		Don't worry !, you aren't here for nothing<br><br>
		We give you 2 drink recipes<br><br>
		<b>1. Pina Colada recipe : </b><br>
		
		<ul class="recipe">
			<li>» 2 oz light rum</li>
			<li>» 3 oz pineapple juice</li>
			<li>» 2 oz Coco Lopez coconut cream</li>
			<li>» Ice</li>
		</ul>
		<br>
		 Mix in blender and pour into colada glass. Serve with cherry and pineapple spear.<br><br><br>		 
		 
		 
		 <b>2. Martini Cocktail, Dry recipe :</b><br>
		 <ul class="recipe">
			<li>» 1 oz gin</li>
			<li>» 1/2 oz French dry vermouth</li>
			<li>» 2 dashes orange bitters</li>
			<li>» Olive</li>
		</ul>
		<br>
		In a shaker filled with ice, combine liquids and stir. Strain into cocktail glass. Garnish with olive.<br><br>
		
		So happy ?


		<h3><a href="homepage">Check Our Home Page for more fun</a></h3>
		<ul class="gallery archive">
		
				<ul>


	</ul></ul></div>
	</div>
</body>
</html>