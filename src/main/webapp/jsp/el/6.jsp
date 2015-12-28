<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="cn.conon.jee.sample.jsp.el.domain.User"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP '6.jsp' starting page</title>
</head>

<body>${fn:escapeXml("<a href=\"\">xxx</a>") }

</body>
</html>
