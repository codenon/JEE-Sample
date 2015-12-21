<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP '3.jsp' starting page</title>
</head>

<body>

	<%
		pageContext.setAttribute("name", "pagecontext");
		request.setAttribute("name", "request");
	%>


	<%
		String name = (String) pageContext.getAttribute("name");
		out.write(name);

		name = (String) pageContext.getAttribute("name", PageContext.REQUEST_SCOPE);
		out.write(name);

		pageContext.findAttribute("name"); //pageContext request session application
	%>


</body>
</html>
