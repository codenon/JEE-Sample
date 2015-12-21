<%@ page language="java" import="java.util.*,java.net.URLEncoder" pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>get的中文乱码问题</title>
<meta http-equiv="content-type" content="text/html; charset=gb2312">
</head>
<body>
	<!-- url地址后面如果跟中文参数，这个参数必须要经过url编码 -->
	<a href="/day06/servlet/RequestDemo7?username=<%=URLEncoder.encode("中国", "gb2312")%>">点点</a>
	<form action="/day06/servlet/RequestDemo7" method="get">
		用户名：
		<input type="text" name="username">
		<br />
		<!-- 输入项 -->
		<input type="submit" value="提交">
		<br />
	</form>
</body>
</html>
