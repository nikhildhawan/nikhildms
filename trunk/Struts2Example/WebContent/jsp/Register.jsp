<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/Struts2Example/media/css/screen.css"
	type="text/css" media="screen, projection" />
<title>SendMeFirst.com | SignUp</title>
<style type="text/css">
body td {	padding: 6px;}

.error {	margin-bottom: 0px;}

input.error {	border-color: #D70B0B;	border-style: solid;}

label.error {	padding-left: 5px;	color: #D70B0B;	border: none; 	background: none;}

form td.label {	width: 120px;}

form input {	width: 150px;}

form h4 {	padding-bottom: 4px;	border-bottom: 1px solid #CCCCCC;	margin-right: 25px; }
</style>

<script type="text/javascript">
function validateUser() 
{
	var username=document.getElementById("Username").value;
	if(username=="")
		{
			alert("Username Empty");
			return false ;
		}
	xmlHttp=GetXmlHttpObject();
	var url="validateuser.action";
	url=url+"?option=validateuser&username="+username;
	xmlHttp.onreadystatechange=stateChanged;
	xmlHttp.open("GET",url,true);
	xmlHttp.send(null);
}

function stateChanged() 
{ 
	if(xmlHttp.readyState==4 || xmlHttp.readyState=="complete")
	{ 
    	var showdata = xmlHttp.responseText; 
    	if(showdata=='Exists')
    		{
    			alert('Username is not available','Error');
    			return false ;
    		}
    	else if(showdata=='Doesnt Exist')
    		{
    			alert('Username is available','Congrats');
    			return true ;
    		}
    	else
    		{
    			alert(showdata);
    		}
    	
	}	 
}

function GetXmlHttpObject()
{
	var xmlHttp=null;
	try 
	{
	  xmlHttp=new XMLHttpRequest();
	}
	catch (e) 
	{
		try
		{
	  		xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	  	}
	 	catch (e)
	 	{
	  		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	  	}
	 }
	return xmlHttp;
}
</script>



</head>
<body>

	<s:action name='addcompactheader' executeResult='true' />


	<style type="text/css">
h1 {	font-size: 28px;	font-weight: normal;	color: #479332;	line-height: 32px;	margin: 25px 0 18px 0;	padding: 0 0 4px;	background-color: transparent;	border: none;	border-bottom: 1px solid #CCCCCC;}

#SignUpPanel {	width: 550px;border: 1px solid #8ED17C;float:none;padding: 25px 18px;margin-top: 65px;margin-left: auto;margin-right: auto;-moz-border-radius: 5px;-webkit-border-radius: 5px;}
</style>

	<div id="SignUpPanel" class="span-14 suffix-1 free">
		<h1>Sign Up</h1>
		<p
			style="margin-bottom: 24px; color: rgb(102, 102, 102); font-size: 16px; font-weight: bold;">
			Once you create your account, you will be able to manage all of your
			folders and documents from one central location.</p>

		<div id="AccountPanel">
			<s:form class="AccountForm" id="AccountForm" style="margin:0 0 30px 0;" action="register" method="POST" >
				<!--
			<h4>Pick a user name</h4>
			-->
				<table>
				<font color="red"> <s:actionerror/><s:fielderror /></font>
					<tbody>
						<tr>
							<td><s:textfield class="username" name="username" value=""	id="Username" label="Username:" onblur="validateUser()" /></td>
						</tr>
						<tr>
							<td><s:textfield name="email" value="" id="Email"	label="Email:" /></td>
						</tr>
						<tr>
							<td><s:password name="password" class="password" value="" id="Password" label="Password:" /></td>
						</tr>
						<tr>
							<td><s:password class="password2" name="password2" value="" 	id="Password2" label="Confirm password:" /></td>
						</tr>
						<tr>
							<td><s:submit id="submit" type="image" src="/Struts2Example/media/images/create-account.png" /></td>
						</tr>
					</tbody>
				</table>
			</s:form>

			<div style="margin-top: 10px;">
				<div id="Spinner" style="display: none;">
					<img src="/media/images/spinner3.gif" /> <span
						style="font-size: 18px; color: #666666; padding-left: 3px; display: none;">Creating Account</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>