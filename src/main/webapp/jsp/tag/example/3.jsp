<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="tagExample" prefix="itcast"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>输出复杂属性的标签</title>
</head>

<body>

	<!-- 
    	由于web服务器只会对基本数据类型进行转换，所以对于标签的复杂属性，
    	如果想给它赋值，就要赋予相应的类型
    -->

	<%
		request.setAttribute("date", new Date());
	%>

	<itcast:outDate date="${date}">

	</itcast:outDate>


	<itcast:outDate date="<%=new Date()%>">

	</itcast:outDate>

</body>
</html>
