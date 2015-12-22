<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="tagExample" prefix="itcast"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>when...otherwise标签</title>
</head>

<body>

	<itcast:choose>
		<itcast:when test="${user!=null}">
    		aaaa
    	</itcast:when>
		<itcast:otherwise>
    		bbbb
    	</itcast:otherwise>
	</itcast:choose>

</body>
</html>
