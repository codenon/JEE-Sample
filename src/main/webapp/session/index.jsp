<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
</head>

<body>
	欢迎您：${user.username }
	<a href="${pageContext.request.contextPath }/servlet/LogoutServlet">退出登陆</a>
</body>
</html>
