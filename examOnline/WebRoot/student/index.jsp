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

		
	
        <script>
        	window.onload=function(){
     
        daojishi();
     }

      var counttime=5*60;//总秒钟
     
      function daojishi(){
      if(counttime>=0){
             var ms = counttime%60;//余数 89%60==29秒
             var mis = Math.floor(counttime/60);//分钟
             if(mis>=60){
              var hour=Math.floor(mis/60);

     mis=Math.floor((counttime-hour*60*60)/60);

              document.getElementById("mss").innerHTML=hour+"小时"+mis+"分"+ms+"秒";
              
             }else if(mis>=1){
              document.getElementById("mss").innerHTML=mis+"分"+ms+"秒"; 
             }else{
              document.getElementById("mss").innerHTML=ms+"秒"; 
             }

   
              counttime--;
              vartt =  window.setTimeout("daojishi()",1000);
   }else{
       window.clearTimeout(vartt);
       window.confirm("考试时间结束,请单击提交"); 
       tijiao();
      
   }

   
     }
     
     function tijiao(){
        document.forms[0].submit();
     }
        </script>
	
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
				<h3 style="text-align: center;">厦门理工学院考试</h3>
				<br>
					<div class = "exam_time">  
            <span>剩余时间为：</span><label  name="mss" id="mss"></label>   
        </div>  
				<div class="questionCell" id="D_Title_P">
					<div class="titleBar">
						<span><b id="D_Title">选择题(100分)</b></span>
						<div class="clear"></div>
					</div>
					<form action="submitExam.action" method="post">
					<s:iterator value="#request.subjects" var="subject" status="sta">
					<div class="question">
						<input type="hidden" name="stID" value="${subject.stID}" />
						<p>${sta.index + 1}、${subject.stTitle}（）&nbsp;(<span class="D_score">20.00</span>分)</p>
						<ul>
						<li>
								<input type="radio" name="stAnswer${sta.index}" value="A"checked="checked" /> A．${subject.stOptionA}
							</li>

							<li >
								<input type="radio"  name="stAnswer${sta.index}" value="B" />B．${subject.stOptionB}
							</li>

							<li >
								<input type="radio"  name="stAnswer${sta.index}" value="C" /> C．${subject.stOptionC}
							</li>

							<li >
								<input type="radio" name="stAnswer${sta.index}" value="D" /> D．${subject.stOptionD}
							</li>
						</ul>
					</div>
					</s:iterator><br>
					<div align="center">
						<input type="submit" value=" 提交答卷 " name="Submit" />
					</div>
					</form>
					
				</div>
			
			</div>

		</div>




	
</body>
</html>