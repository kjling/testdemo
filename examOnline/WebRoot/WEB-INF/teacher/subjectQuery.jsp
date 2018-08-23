<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--
TODO:题目的查询界面
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>老师登陆成功</title>
</head>
	<body>
		<form action="querySubjectLike.action" method="post">
			<table border="0" cellspacing="10" cellpadding="0">
				<tr>
					<td>
						试题题目:
					</td>
					<td>
						<input name="subjectTitle" size="50">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center">
							<input type="submit" name="Submit" value="查询">
							<input type="reset" name="Submit2" value="重置">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>