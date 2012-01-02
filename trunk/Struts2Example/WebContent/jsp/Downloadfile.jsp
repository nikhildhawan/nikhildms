<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Download file</title>
<script type="text/javascript">
function downloadfile()
{
	alert('hello');
	var fileid=document.getElementById("download");
	  var elemIF = document.createElement("iframe"); 
	  elemIF.src = "downloadfile.action?fileid="+fileid; 
	  elemIF.style.display = "none"; 
	  document.body.appendChild(elemIF); 
}
</script>
</head>
<body>
	<s:action name='addcompactheader' executeResult='true' />
	<s:textfield name='download' id='download' onblur="downloadfile()"></s:textfield>
</body>
</html>