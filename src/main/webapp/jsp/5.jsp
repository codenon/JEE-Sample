<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP '5.jsp' starting page</title>
</head>

<body>


	<jsp:forward page="/jsp/6.jsp">
		<jsp:param name="name" value="abc" />
		<jsp:param name="password" value="123" />
	</jsp:forward>



</body>
</html>
