<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>JEE-Sample</title>
</head>
<body>
	<a href="/JEE-Sample/servlet/ServletSample">ServletSample</a>
	<br />
	<a href="/JEE-Sample/servlet/HttpServletSample">HttpServletSample</a>
	<br />
	<a href="/JEE-Sample/servlet/HttpServletSample2">HttpServletSample2</a>
	<br />
	<br />

	<%=request.getAttribute("data")%>

	<br />
	<br />
	<br />
	<a href="/JEE-Sample/jsp/index.jsp">JSP</a>
</body>
</html>
