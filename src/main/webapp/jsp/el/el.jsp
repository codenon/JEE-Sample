<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.conon.jee.sample.jsp.bean.Person"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>el表达式</title>
</head>

<body>

	<%
		request.setAttribute("name", "abc");

		Person p = new Person();
		p.setName("aaa");
		request.setAttribute("person", p);

		//list
		List list = new ArrayList();
		list.add("aaaa");
		list.add("bbbb");
		list.add("cccc");
		request.setAttribute("list", list);

		//map
		Map map = new HashMap();
		map.put("aa", "123");
		map.put("1", "123");
		request.setAttribute("map", map);
	%>


	${name }
	<br />

	<!-- 取出bean的数据显示 -->
	${person.name } //pagecontext.findAttribute("person") ${person.address.city }
	<br />

	<!-- 取list集合中的指定位置的元素 -->
	${list[2] }

	<!-- 取map集合的数据 -->
	${map.aa }

	<!-- 取map集合的数据要注意的问题,关键字最好不要用数字 -->
	${map['1'] }
</body>
</html>