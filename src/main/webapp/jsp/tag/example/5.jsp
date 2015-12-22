<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="tagExample" prefix="itcast"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>迭代标签1(只能迭代实现Collection接口的集合)</title>
</head>

<body>

	<%
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		request.setAttribute("list", list);
	%>


	<!-- var 属性指定的是pageContext域里面的关键字 -->
	<itcast:foreach var="str" items="${list}">
    	${str }
    </itcast:foreach>

</body>
</html>
