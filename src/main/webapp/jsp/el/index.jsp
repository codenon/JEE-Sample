<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
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
	<h1>
		<font color="red">
			<%=new Date().toLocaleString()%>
		</font>
	</h1>
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/jsp/el/el.jsp">el.jsp</a>
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/jsp/el/1.jsp">1.jsp</a>
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/jsp/el/2.jsp">2.jsp</a>
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/jsp/el/3.jsp">3.jsp</a>
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/jsp/el/4.jsp">4.jsp</a>
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/jsp/el/5.jsp">5.jsp</a>
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/jsp/el/6.jsp">6.jsp</a>
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/jsp/el/7.jsp">7.jsp</a>
	<br />
</body>