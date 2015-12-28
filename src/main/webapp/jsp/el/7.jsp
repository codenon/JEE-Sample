<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.conon.jee.sample.jsp.el.domain.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jstl标签库</title>
</head>

<body>

	<br />
	---------- c:out标签:可以对内容转义输出 ，如果为null，输出默认值 --------------
	<br />
	<c:out value="${user.name}" default="xxx"></c:out>


	<br />
	---------- c:set标签:向域中保存数据 --------------
	<br />
	<c:set var="a" value="abc" scope="page"></c:set>
	${a }
	<c:set var="user" value="<%=new User()%>" scope="session"></c:set>
	${user.name }

	<br />
	---------- c:set标签:向map集合中保存数据 --------------
	<br />
	<%
		Map map = new HashMap();
		request.setAttribute("map", map);
	%>
	<c:set property="data" value="yyyy" target="${map}"></c:set>
	${map.data }

	<br />
	---------- c:catch标签:抓jsp页面异常，以避免异常直接抛给用户 --------------
	<br />
	<c:catch var="exce">
		<%
			int x = 1 / 0;
		%>
	</c:catch>
	${exce.message } ${exce.stackTrace }


	<br />
	---------- c:foreach标签 --------------
	<br />
	<c:forEach var="index" begin="1" end="20">
    	${index }
    </c:forEach>

	<br />
	---------- c:url标签(重要！！！！) --------------
	<br />

	<c:url var="url" value="/servlet/ServletDemo1">
		<c:param name="name" value="中国" />
		<c:param name="password" value="美国" />
	</c:url>
	<a href="${url }">结帐</a>


	<br />
	---------- c:forTokens标签(分隔字符串) --------------
	<br />
	<c:forTokens var="str" items="a.b.c" delims=".">
    	${str }
    </c:forTokens>


</body>
</html>
