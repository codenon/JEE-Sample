<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.apache.struts.action.ActionErrors"%>
<%@page import="org.apache.struts.action.ActionMessage"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'register.jsp' starting page</title>
</head>

<body>
	<%-- 
  		ActionErrors errors = (ActionErrors)request.getAttribute("org.apache.struts.action.ERROR");
  		Iterator it = errors.get("username");
  		while(it.hasNext())
  		{
  			ActionMessage message = (ActionMessage)it.next();
  			String key = message.getKey();
  			out.write(key);
  		}
  	--%>
	<html:errors />
	<!-- html:errors标签在工作时需要一个国际化资源文件的支持 -->
	<form action="${pageContext.request.contextPath }/register.do" method="post">
		用户名：
		<input type="text" name="username">
		<br />
		密码：
		<input type="password" name="password">
		<br />
		确认密码：
		<input type="password" name="password2">
		<br />
		邮箱：
		<input type="text" name="email">
		<br />
		<input type="submit" value="注册">
	</form>
</body>
</html>
