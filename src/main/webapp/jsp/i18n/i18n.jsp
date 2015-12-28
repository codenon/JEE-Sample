<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户注册</title>
</head>

<body>

	<%
		ResourceBundle bundle = ResourceBundle.getBundle("cn.conon.jee.sample.jsp.i18n.resource.myresource", request.getLocale());
	%>

	<form action="">
		<%=bundle.getString("username")%><input type="text" name="username">
		<br />
		<%=bundle.getString("password")%><input type="password" name="password">
		<br />
		<input type="submit" value='<%=bundle.getString("submit")%>'>
		<br />
	</form>

</body>
</html>
