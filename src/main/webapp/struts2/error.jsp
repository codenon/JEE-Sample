<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>µÇÂ¼Ê§°ÜÒ³Ãæerror.jsp</title>

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
	<div>
		<p align="center">
			µÇÂ½Ê§°Ü£¡£¡£¡
			<a href="login.jsp">·µ»ØµÇÂ¼Ò³Ãæ</a>
		</p>
	</div>
	<div>
		<p align="center">${requestScope.error }</p>
	</div>
</body>
</html>
