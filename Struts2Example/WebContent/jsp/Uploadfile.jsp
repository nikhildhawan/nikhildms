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
<title>SendMeFirst.com | Upload File</title>
<link rel="stylesheet"
	href="/Struts2Example/media/css/screen.css?v=12201316" type="text/css"
	media="screen, projection">
</head>
<body>
<% if(session.getAttribute("userkey")==null){ response.sendRedirect("/Struts2Example/jsp/Login.jsp"); } %>
	<s:action name='addcompactheader' executeResult='true' />
	<style type="text/css">
h1 {font-size: 28px;font-weight: normal;color: #479332;line-height: 32px;margin: 25px 0 18px 0;padding: 0 0 4px;background-color: transparent;border: none;border-bottom: 1px solid #CCCCCC;}
.meter-wrap{float:right;	position: relative;	border-radius: 10px;-moz-border-radius: 10px;	-webkit-border-radius: 10px;margin-top: 20px;	margin-left: 20px;}
.meter-wrap #usagetext{display:none;color: #479332;font-size: 13px;}
.meter-wrap:hover #usagetext {display:inline-block;color: #479332;font-size: 15px;}
.meter-wrap, .meter-value, .meter-text {	width: 180px; height: 30px;-webkit-border-top-left-radius: 10px;-webkit-border-bottom-left-radius: 10px;-moz-border-radius-topleft: 10px;	-moz-border-radius-bottomleft: 10px;	border-top-left-radius: 10px;	border-bottom-left-radius: 10px;}
.meter-wrap, .meter-value {	background: #bdbdbd;}
.meter-text {	position: absolute;top:0; left:0;padding-top: 5px;color: #fff;text-align: center;	width: 100%;}
.upload-box {	width: 550px;border: 1px solid #8ED17C;	float: center;	padding: 25px 18px;	margin-top: 65px;	margin-left: auto;	margin-right: auto;	-moz-border-radius: 5px;	-webkit-border-radius: 5px;}
</style>

</script>


	<div class="upload-box">
	<div class="meter-wrap">
    <div class="meter-value" style="background-color: #0a0; width:<%=session.getAttribute("percent") %>%;">
        <div class="meter-text">
            <%=session.getAttribute("percent") %>%
        </div>
    </div>
    <span id="usagetext"><%=session.getAttribute("usage") %> MB of 50 MB Used</span>
</div>

		<font color="red"><s:actionerror />
		<s:fielderror /></font>
		<s:form name="uploadform" action='uploadfile' method='post' style="margin-top:25px;" enctype="multipart/form-data">
			<h1	style="display:inline-block;margin: 0 0 15px; font-size: 24px; padding-bottom: 10px; border-bottom: 2px solid #44a62a;">Upload&nbsp;File</h1>
			<table>
				<tbody>
					<tr>
						<td><s:file name="upload" id="upload" label="File" /></td>
					</tr>
				</tbody>
			</table>

			<div style="margin: 0;">
				<input type="submit" value="Upload" style="padding: 2px 12px;" />
			</div>
		</s:form>
	</div>
</body>
</html>