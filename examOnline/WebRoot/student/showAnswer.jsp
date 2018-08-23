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
<body>

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
									<h5>${studentInfo.studentName}<small>you are welcome</small></h5>
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
				<h3 style="text-align: center;">厦门理工学院考试参考答案</h3>
				<br>
					<div>  
            <span>考试时间：5 分钟</span>  &nbsp; &nbsp; &nbsp; &nbsp;总分 ：100 分  
        </div>  
				<div class="questionCell" id="D_Title_P">
					<div class="titleBar">
						<span><b id="D_Title">选择题(100分)</b></span>
						<div class="clear"></div>
					</div>
					
					<s:iterator value="#request.subjects" var="subject" status="sta">
					<div class="question">
						<input type="hidden" name="stID" value="${subject.stID}" />
						<p><strong>第<span class="STYLE5">${sta.index + 1}</span>题&nbsp;${subject.stTitle}</strong></p>
						<ul>
						<li>
								<strong>A．</strong>${subject.stOptionA}
							</li>

							<li >
								<strong>B．</strong>${subject.stOptionB}
							</li>

							<li >
								<strong>C．</strong>${subject.stOptionC}
							</li>

							<li >
								<strong>D．</strong>${subject.stOptionD}
							</li>
							<strong>【正确答案】：${subject.stAnswer}</strong><br/>
	        <strong>【参考解析】：${subject.stParse}</strong>
						</ul>
					</div>
					</s:iterator><br>
					
					
				</div>
			
			</div>

		</div>




</body>
</html>