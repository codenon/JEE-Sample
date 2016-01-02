<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- Struts 2 ±êÇ©¿â -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>µÇÂ¼Ò³Ãælogin.jsp</title>

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
		<s:textfield name="user.username" label="ÓÃ»§Ãû" />
		<s:textfield name="user.password" label="ÃÜ Âë" />
		<s:submit value="µÇÂ¼" />
	</s:form>

	<form name="form1" action="login.action">
		<input type="text" name="username">
		<br>
		<input type="password" name="password">
		<br>
		<input type="submit" value="µÇÂ¼">
	</form>

</body>
</html>
