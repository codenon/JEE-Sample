<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- Struts 2 标签库 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录页面login.jsp</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->

</head>

<body>

	<s:form name="form1" action="login.action" method="post">
		<s:textfield name="user.username" label="用户名" />
		<s:textfield name="user.password" label="密 码" />
		<s:submit value="登录" />
	</s:form>

	<form name="form1" action="login.action">
		<input type="text" name="username">
		<br>
		<input type="password" name="password">
		<br>
		<input type="submit" value="登录">
	</form>

</body>
</html>
