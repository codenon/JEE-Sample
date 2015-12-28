<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>el隐式对象</title>
</head>

<body>
	<%
		pageContext.setAttribute("aaa", "bbb"); //map\
		request.setAttribute("aaa", "bbb"); //map  ${requestScope}
	%>

	${pageContext.request.contextPath }
	<br />

	${pageScope.aaa }
	<br />

	<!-- 获取一个请求参数 -->
	${param.name }
	<br />

	<!-- 获取多个同名的请求参数 -->
	${paramValues.like[0] }
	<br />

	${paramValues.like[1] }
	<br />

	${initParam.webroot }
</body>
</html>
