<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>web计算器</title>
</head>

<body style="text-align: center;">
	<br />
	<br />

	<jsp:useBean id="bean" class="cn.conon.j2ee.sample.jsp.bean.CalculatorBean" />
	<jsp:setProperty name="bean" property="*" />
	<%
		bean.calculate();
	%>

	计算结果：
	<jsp:getProperty name="bean" property="firstNum" />
	<jsp:getProperty name="bean" property="operator" />
	<jsp:getProperty name="bean" property="secondNum" />
	=
	<jsp:getProperty name="bean" property="result" />

	<br />
	<br />

	<form action="/J2EE-Sample/jsp/bean/calculator.jsp" method="post">
		<table width="40%" border="1">
			<tr>
				<td colspan="2">简单的计算器</td>
			</tr>

			<tr>
				<td>第一个参数</td>
				<td>
					<input type="text" name="firstNum">
				</td>
			</tr>

			<tr>
				<td>运算符</td>
				<td>
					<select name="operator">
						<option value="+">+</option>
						<option value="-">-</option>
						<option value="*">*</option>
						<option value="/">/</option>
					</select>
				</td>
			</tr>

			<tr>
				<td>第二参数</td>
				<td>
					<input type="text" name="secondNum">
				</td>
			</tr>

			<tr>
				<td colspan="2">
					<input type="submit" value="计算">
				</td>
			</tr>

		</table>

	</form>


</body>
</html>
