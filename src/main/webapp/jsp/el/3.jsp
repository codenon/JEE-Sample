<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>使用${param }回显数据</title>
</head>

<body>

	<form action="${pageContext.request.contextPath }/jsp/el/RegisterServlet" method="post">
		用户名：
		<input type="text" name="username" value="${param.username }">
		密码：
		<input type="text" name="password" value="${param.password }">
		<input type="submit">
	</form>

</body>
</html>
