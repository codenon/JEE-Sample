<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP '1.jsp' starting page</title>
</head>

<body>

	<jsp:useBean id="person" class="cn.conon.j2ee.sample.jsp.bean.Person" />

	<jsp:setProperty name="person" property="name" value="bbb" />

	<!-- 用请求参数name的值给bean赋值 -->
	<jsp:setProperty name="person" property="name" param="name" />

	<!-- 用所有的请求参数给 bean赋值   http://localhost:8080/day09/1.jsp?name=ddd&password=123&age=12 -->
	<jsp:setProperty name="person" property="*" />


	<jsp:getProperty name="person" property="name" />


</body>
</html>
