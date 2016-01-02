<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>JEE-Sample</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/servlet/ServletSample">ServletSample</a>
	<br />
	<a href="${pageContext.request.contextPath }/servlet/HttpServletSample">HttpServletSample</a>
	<br />
	<a href="${pageContext.request.contextPath }/servlet/HttpServletSample2">HttpServletSample2</a>
	<br />
	<br />

	<%=request.getAttribute("data")%>

	<br />
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/jsp/index.jsp">JSP</a>

	<br />
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/struts2/index.jsp">Struts2</a>


	<br />
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/websers/rs/jersey/index.jsp">JAX-RS</a>

</body>
</html>
