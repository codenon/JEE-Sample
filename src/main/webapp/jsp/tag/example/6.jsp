<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="tagExample" prefix="itcast"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>对所有集合进行迭代的标签</title>
</head>

<body>

	<%
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		request.setAttribute("list", list);

		Map map = new HashMap();
		map.put("aa", "111");
		map.put("bb", "222");
		map.put("cc", "333");
		request.setAttribute("map", map);

		String args[] = new String[]{"ssss1", "ssss2", "ssss3"};
		request.setAttribute("ssss", args);

		int num[] = new int[]{1, 2, 3};
		request.setAttribute("num", num);
	%>

	<c:foreach></c:foreach>
	<!--  -->

	<itcast:foreach2 var="str" items="${list}">
 		${str }
 	</itcast:foreach2>
	<br />
	<br />

	<itcast:foreach2 var="entry" items="${map}">
 		${entry.key } = ${entry.value } <br />
	</itcast:foreach2>

	<br />
	<br />

	<itcast:foreach2 var="ss" items="${ssss}">
 		${ss }
 	</itcast:foreach2>


	<br />
	<br />

	<itcast:foreach2 var="i" items="${num}">
 		${i }
 	</itcast:foreach2>
</body>
</html>
