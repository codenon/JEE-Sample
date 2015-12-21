<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>J2EE-Sample</title>
</head>
<body>
	<a href="/J2EE-Sample/servlet/ServletSample">ServletSample</a>
	<br />
	<a href="/J2EE-Sample/servlet/HttpServletSample">HttpServletSample</a>
	<br />
	<a href="/J2EE-Sample/servlet/HttpServletSample2">HttpServletSample2</a>
	<br />
	<%=request.getAttribute("data")%>
</body>
</html>
