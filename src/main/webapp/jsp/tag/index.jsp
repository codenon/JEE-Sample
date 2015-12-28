<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>

</head>

<body>
	<a href="${pageContext.request.contextPath }/jsp/tag/example/1.jsp">看情书</a>

	<br />
	<br />
	<a href="${pageContext.request.contextPath }/jsp/tag/jstl.jsp">jstl.jsp</a>
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/jsp/tag/tag/index.jsp">tag</a>
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/jsp/tag/simple/index.jsp">simple</a>
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/jsp/tag/example/index.jsp">example</a>
	<br />
	<br />

</body>
</html>
