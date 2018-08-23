<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>老师登陆成功</title>
	</head>
	<body>
		<form action="studentAdd.action" method="post">
			<table border="0" cellspacing="10" cellpadding="0">
				<tr>
					<td>学生编号：</td>
					<td>
						<input type="text" name="studentID">
					</td>
				</tr>
				<tr>
					<td>学生姓名：</td>
					<td>
						<input type="text" name="studentName">
					</td>
				</tr>
				<tr>
					<td>所属班级:</td>
					<td>
						<input type="text" name="sclass">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center">
							<input type="submit" value="录入">
							<input type="reset" value="重置">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>