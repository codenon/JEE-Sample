<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.conon.jee.sample.jsp.el.domain.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>el运算符</title>
</head>

<body>

	<%
		Map map = new HashMap();
		map.put("aa", "bb");
		map.put("111", "2222");
		request.setAttribute("map", map);
	%>

	<!--开发中，经常使用empty运算符检查集合或数组是否有数据  -->
	<c:choose>
		<c:when test="${!empty(map)}">
			<c:forEach var="entry" items="${map}">
  				${entry.key } = ${entry.value }<br />
			</c:forEach>
		</c:when>

		<c:otherwise>
  			对不起，您还没有购买任何商品
  		</c:otherwise>
	</c:choose>


	<!-- 二元表达式 -->
	欢迎您：${user!=null?user.name : '' }

	<br />
	<br />


	<!-- 二元表达式经常用于在页面中回显数据库的数据 -->
	<%
		//从数据库中取出用户数据
		User user = new User();
		user.setGender("女");
		request.setAttribute("user", user);
	%>

	<input type="radio" name="gender" value="male" ${user.gender=='男'?'checked' : '' }>
	男
	<input type="radio" name="gender" value="female" ${user.gender=='女'?'checked' : '' }>
	女


	<!-- el的[]运算符可以取.号运算符取不出来的数据  -->
	${map['111'] }

	<br />
	<br />
	欢迎您：${user!=null?user.name : '' }

	<br />
	<br />
</body>
</html>
