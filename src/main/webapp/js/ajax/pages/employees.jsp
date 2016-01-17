<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ajax/scripts/jquery.js"></script>
<script type="text/javascript">
	$(function() {

		$("select[name=city]")
				.change(function() {
					var val = $(this).val();

					if (val != "") {
						var url = "${pageContext.request.contextPath }/employees.do?method=showDepts";
						var args = {
						random : Math.random(),
						locationId : val
						};

						$
								.getJSON(url, args, function(data) {
									if (data.length == 0) {
										alert("没有部门!");
									} else {
										for (var i = 0; i < data.length; i++) {
											$("<option value='" + data[i].departmentId + "'>" + data[i].departmentName + "</option>")
													.appendTo($("select[name=dept]"));
										}
									}
								});
					}
				}, "json");

	})
</script>
</head>
<body>

	<center>
		<br />
		<br />
		City:
		<select name="city">
			<option value="">请选择</option>
			<c:forEach items="${locations}" var="location">
				<option value="${location.locationId }">${location.city }</option>
			</c:forEach>
		</select>

		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Department:
		<select name="dept">
			<option value="">请选择</option>
		</select>
	</center>

</body>
</html>