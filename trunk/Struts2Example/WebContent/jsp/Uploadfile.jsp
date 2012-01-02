<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload File</title>

</head>
<body>
<s:action name='addcompactheader' executeResult='true' />
<style type="text/css">
h1 { font-size:28px; font-weight:normal; color:#479332; line-height:32px; margin:25px 0 18px 0; 
		padding:0 0 4px; background-color:transparent; border:none; border-bottom:1px solid #CCCCCC; }
		.upload-box {width:550px; border:1px solid #8ED17C; float:center ; padding:25px 18px; margin-top:65px; margin-left:auto; margin-right:auto ; -moz-border-radius:5px; -webkit-border-radius:5px;}


</style>
<div class="upload-box">
	<s:form action='uploadfile' method='post' style="margin-top:25px;" enctype="multipart/form-data">
		<h1 style="margin:0 0 15px; font-size:24px; padding-bottom:10px; border-bottom:2px solid #44a62a;">Upload File</h1>
<!-- 		<h1>Upload File</h1> -->
		<table>
			<tbody>
			<s:actionerror/>
			<s:fielderror />
				<tr><td><s:file name="upload"  id="upload" label="File"/></td></tr>	
			</tbody>
		</table>
		
		<div style="margin:0;">
			<input type="submit" value="Upload" style="padding:2px 12px;" />
			
			<div style=" display:none;float:right; padding-top:5px; text-align:right;">
                <a id="Forget" href="/accounts/password/reset/">Forgot password?</a><br/>
                <a id="Forget" href="/jsp/Register.jsp">Create an account now!</a>
            </div>
		</div>
	</s:form>
</div>
</body>
</html>