<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP '6.jsp' starting page</title>
</head>

<body>

	<%
		request.setAttribute("name", "xxx");
	%>

	<%
		String name = request.getParameter("name");
		out.write(StringUtils.isEmpty(name) ? "parameter name is empty" : name);
	%>
	<br />
	<%
		String password = request.getParameter("password");
		out.write(StringUtils.isEmpty(password) ? "parameter password is empty" : password);
	%>
</body>
</html>
