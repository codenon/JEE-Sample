<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="elFuction" prefix="el"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>自定义el函数</title>
</head>

<body>

	<!-- el函数与自定义标签最大的区别：自定义标签可以获得页面的pagecontext，而el函数不能 -->
	<!-- el函数可以封装jsp页面中不涉及到web对象的java代码 -->
	<!-- 则自定义标签可以封装jsp页面所有java代码  -->


	${el:filter("<a href=\"\">点点</a>") }

</body>
</html>
