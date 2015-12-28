<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.conon.jee.sample.jsp.el.domain.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>sun公司的el函数</title>
</head>

<body>
	${fn:toLowerCase('AAA')  } ${fn:length('aaaa') }


	<br>
	----------别外一种迭代形式-----------------------
	<br>
	<%
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		request.setAttribute("list", list);
	%>


	<c:forEach var="index" begin="0" end="${fn:length(list)}">
    	${list[index] }
    </c:forEach>



	<br>
	----------回显用户的爱好-----------------------
	<br>
	<%
		User user = new User();
		request.setAttribute("user", user);
	%>
	<form action="">
		<input type="checkbox" name="likes" value="sing" ${fn:contains(fn:join(user.likes,","),"sing")==true?'checked' : '' }>
		唱歌
		<input type="checkbox" name="likes" value="dance" ${fn:contains(fn:join(user.likes,","),"dance")==true?'checked':'' }>
		跳舞
		<input type="checkbox" name="likes" value="basketball" ${fn:contains(fn:join(user.likes,","),"basketball")==true?'checked':'' }>
		蓝球
		<input type="checkbox" name="likes" value="football" ${fn:contains(fn:join(user.likes,","),"football")==true?'checked':'' }>
		足球
	</form>

</body>
</html>
