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

	<div id="wrap">
		<div id="main" class="clearfix">
			<style type="text/css">
.header {
	background: url(/Struts2Example/media/images/header-gradient.png) #f5f5f5 repeat-x left
		bottom;
	height: 60px;
	border-bottom: 1px solid #ccc;
}

.header .content {
	margin: 0 auto;
	width: 950px;
	padding: 0 26px 0 26px;
	text-align: left;
}

.header .logo {
	float: left;
}

.header .logo a {
	padding: 0px;
}

.header #logo {
	margin: 14px 0 0;
}

.header .navbar {
	float: right;
	margin-top: 24px;
	font-size: 13px;
	font-weight: bold;
	cursor: default;
	font-family: Helvetica, Arial;
	text-shadow: 0 1px 0 #fff;
}

.header .navbar ul {
	margin: 0;
}

.header .navbar li {
	margin: 0;
	float: left;
	list-style: none;
	position: relative;
	z-index: 10;
}

.header .navbar a {
	margin-left: 12px;
	padding-left: 6px;
	color: #615f5d;
}

.header .navbar .divider {
	color: #888;
}

.header a.user {
	
}

.navbar li:hover .has-subnav {
	text-decoration: none;
	background-color: #F0F0F0;
	padding-bottom: 5px;
}

/*fixes hover hit-area*/
.navbar li:hover .subnav {
	display: block;
}

.navbar .subnav {
	z-index: 10;
	position: absolute;
	left: 12px;
	top: 20px;
	background: #F5F5F5;
	display: none;
	border: 1px solid #D1D1D1;
}

.navbar .subnav li {
	width: 125px;
	margin: 1px;
}

.navbar .subnav a {
	padding: 2px 0;
	margin: 0;
	display: block;
	text-decoration: none;
}

.navbar .subnav a:hover {
	background-color: #dae8f9;
}

.feedback .has-subnav {
	padding-right: 16px;
	background: url(/Struts2Example/media/images/down-arrow.png) no-repeat
		right 3px;
	_background: none !important;
	_padding-right: 0;
}

.feedback .subnav a {
	padding-left: 8px;
}

.navbar .subnav .no-chatback a {
	color: #aaa;
}

.navbar .subnav .no-chatback a:hover {
	background-color: transparent;
	cursor: default;
}

.navbar .subnav .chatback a {padding-left: 25px;background-position: 5px 4px;background-repeat: no-repeat;background-image: url("/media/images/bullet-green.png");}

/*Compact Header Styles*/
.compact-header {background:url(/Struts2Example/media/images/compact-header-gradient.png) #f5f5f5 repeat-x;height: 36px;border-bottom: 1px solid #d1d1d1;position: relative;}

.compact-header a {
	text-decoration: none;
}

.compact-header a:hover {
	text-decoration: underline;
}

.compact-header #logo {
	margin-top: 0px;
}

.compact-header .navbar {
	margin-top: 10px;
}

.compact-header a.mydocs-tab {
	font-weight: bold;
}

.compact-header a.feedback-tab:hover {
	text-decoration: none;
}
</style>
<div class="header">
		<div class="header compact-header">
			<div class="content clearfix">
				<div class="logo">
					<a href="/Struts2Example/jsp/Homepage.jsp"><img id="logo"
						border="0" src="/Struts2Example/media/images/logo-small.png"
						alt="sendmefirst" width="200" height="42" /> </a>
				</div>
				<div class="navbar">
					<ul>

						<li><a class="mydocs-tab" href="/accounts/profile/">My Documents</a></li>

						<!-- 							<li><a href="/partner-program/">Partner Program</a></li> -->
						<!-- 							<li><a href="/api/">API</a></li> -->

						<li class="feedback">
							<!--Feedback dropdown for normal header-->
							<a class="has-subnav" href="javascript:{}">Support</a>
							<ul class="subnav">
								<li><a class="email-feedback" href="javascript:{}" onclick="">Send Feedback</a></li>
								<li><a href="http://crocodoc.uservoice.com"	target="_blank">User Forum</a></li>
								<li class="no-chatback"><a href="javascript:{}">Chat Offline</a></li>
								<li class="chatback" style="display: none;"><a href="javascript:{}">Live Chat</a></li>
							</ul>
						</li>

						<li>
						
						<% if(session.getAttribute("userkey")!=null)
						{ %>
							<a class="user" href="/accounts/profile/"><s:property value="%{#session['userkey']}"/></a>
							<span class="divider"> | </span>
							<a href="logout.action" style="margin-left: 0; padding-left: 0;">Logout</a>
						
					<% } 
						else 
						{ %>
							 <a href="/Struts2Example/jsp/Login.jsp">Login</a>
							 <span class="divider"> | </span>
							<a href="/Struts2Example/jsp/Register.jsp" style="margin-left: 0; padding-left: 0;">Signup</a>
					<%	} %>
					</li>
					</ul>
				</div>
			</div>
		</div>
		</div>
	</div>
</div>
</body>
</html>