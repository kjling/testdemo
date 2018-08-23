<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="../css/student.css" type="text/css" />
		<title>学生登陆成功</title>
	</head>
<body >

<div class="container">
			
			<div class="header">
				<div class="logo">
					<a href="dashboard.html"><img src="../images/logo.png" alt="" /></a>
				</div>
				<div class="headerinner">
					<ul class="headmenu">

						<li class="right">
							<div class="userloggedinfo">
								<img src="../images/photos/thumb5.png" alt="" />
								<div class="userinfo">
									<h5>${request.studentName} <small>you are welcome</small></h5>
									<ul>
										<li><a href="<%=path %>/login.jsp">退出登录</a></li>
									</ul>
								</div>
							</div>
						</li>
					</ul>
					<!--headmenu-->
				</div>
			</div>

			<div class="examed_uc maincontentinner">
				<h3 style="text-align: center;">考试情况</h3>
				<div align="center" style="font-size: 18px">考生姓名:${request.studentName}</div>
				<div align="center" style="font-size: 16px">考生得分:${request.score}分</div>
				<div align="center"><a href="showSubjectAnswer.action">查看答案</a></div>
				<br>
					
					
					
			</div>
			
	</div>

		


	
</body>
</html>