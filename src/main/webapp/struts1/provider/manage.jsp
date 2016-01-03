<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/struts1/provider/video/manage.do" method="post" enctype="multipart/form-data">
		视频名称:
		<input type="text" name="title" />
		<br />
		时长:
		<input type="text" name="timelength" />
		<br />
		<input type="hidden" name="method" value="save" />
		视频文件:
		<input type="file" name="videofile" />
		<br />
		<input type="submit" value=" 提 交 " />
	</form>
</body>
</html>