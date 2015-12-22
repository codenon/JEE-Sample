<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'jstl.jsp' starting page</title>
</head>

<body>


	<%
		//list
		List list = new ArrayList();
		list.add("aaaa");
		list.add("bbbb");
		list.add("cccc");
		request.setAttribute("list", list);

		Map map = new HashMap();
		map.put("aa", "123");
		map.put("bb", "123");
		request.setAttribute("map", map);
	%>


	<c:forEach var="str" items="${list}">
   		${str }  <br />
	</c:forEach>

	<br />
	<br />
	<br />

	<c:forEach var="entry" items="${map}">  map.entrySet ---->  Set(Map.Entry)
   	${entry.key } = ${entry.value }  <br />
	</c:forEach>

	<c:if test="${user==null}">  
   		用户名：<input type="text" name="username">
	</c:if>
	<c:if test="${user!=null}">
   		欢迎您：${user.uesrname }
   </c:if>


	<br />
	<br />
	<a href="${pageContext.request.contextPath }/servlet/...">点点</a>


</body>
</html>
