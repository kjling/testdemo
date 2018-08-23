<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" href="../css/style.default.css" type="text/css" />
<link rel="stylesheet" href="../css/responsive-tables.css">
<link rel="stylesheet" href="../css/bootstrap-fileupload.min.css" type="text/css" />
<link rel="stylesheet" href="../css/bootstrap-timepicker.min.css" type="text/css" />

<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/jquery.uniform.min.js"></script>
<script type="text/javascript" src="../js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../js/jquery.cookie.js"></script>
<script type="text/javascript" src="../js/modernizr.min.js"></script>
<script type="text/javascript" src="../js/responsive-tables.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
<script type="text/javascript" src="../js/forms.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function(){
        // dynamic table
        jQuery('#dyntable').dataTable({
            "sPaginationType": "full_numbers",
            "aaSortingFixed": [[0,'asc']],
            "fnDrawCallback": function(oSettings) {
                jQuery.uniform.update();
            }
        });
        
        jQuery('#dyntable2').dataTable( {
            "bScrollInfinite": true,
            "bScrollCollapse": true,
            "sScrollY": "300px"
        });
        
    });
</script>
<title>老师登陆成功</title>
</head>


<body>

<div class="mainwrapper">
    
    <div class="header">
        <div class="logo">
            <a href="<%=path %>/teacher/teacher.jsp"><img src="../images/logo.png" alt="" /></a>
        </div>
        <div class="headerinner">
            <ul class="headmenu">
              
                <li class="right">
                    <div class="userloggedinfo">
                        <img src="../images/photos/thumb1.png" alt="" />
                        <div class="userinfo">
                            <h5>${sessionScope.teacherInfo.teacherID} <small>you are welcome</small></h5>
                            <ul>
                                <li><a href="<%=path %>/login.jsp">退出登录</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
            </ul><!--headmenu-->
        </div>
    </div>
    
    <div class="leftpanel" style="margin-left: 0px;">
        
        <div class="leftmenu">        
            <ul class="nav nav-tabs nav-stacked">
            	<li class="nav-header">Navigation</li>
                
                <li class="dropdown "><a href=""><span class="iconfa-pencil"></span> 学生管理</a>
                    <ul>
                    	<li><a href="<%=path %>/teacher/studentAdd.jsp">添加学生</a></li>
                        <li><a href="<%=path %>/teacher/studentQuery.action">查询所有学生</a></li>
                    </ul>
                </li>
                <li class="dropdown active"><a href=""><span class="iconfa-briefcase"></span> 试题管理</a>
                	<ul>
                    	<li><a href="<%=path %>/teacher/subjectAdd.jsp">添加试题</a></li>
                        <li><a href="<%=path %>/teacher/querySubject.action">查询所有试题</a></li>
                        <li><a href="<%=path %>/teacher/subjectQuery.jsp">搜索试题</a></li>
                    </ul>
                </li>
                
            </ul>
        </div><!--leftmenu-->
        
    </div><!-- leftpanel -->
    <div class="rightpanel">
        
        <ul class="breadcrumbs">
            <li><a href="<%=path %>/teacher/teacher.jsp"><i class="iconfa-home"></i></a> <span class="separator"></span></li>
            <li><a href="table-static.html">学生管理</a> <span class="separator"></span></li>
            <li>查询所有学生</li>
            
            <li class="right">
                <a href="" data-toggle="dropdown" class="dropdown-toggle"><i class="icon-tint"></i> Color Skins</a>
                <ul class="dropdown-menu pull-right skin-color">
                    <li><a href="default">Default</a></li>
                    <li><a href="navyblue">Navy Blue</a></li>
                    <li><a href="palegreen">Pale Green</a></li>
                    <li><a href="red">Red</a></li>
                    <li><a href="green">Green</a></li>
                    <li><a href="brown">Brown</a></li>
                </ul>
            </li>
        </ul>
        
         <div class="maincontent" style="">
            <div class="maincontentinner">
            
                <div class="widget">
            <h4 class="widgettitle">试题详情</h4>
            <div class="widgetcontent">
                <form class="stdform" action="queryStudentByClass" method="post">               
                      		<p>
                            <label style="padding: 0px 20px 0 0;">试题编号:</label>
                            <span class="field">${subject.stID}</span>
                        	</p><p>
                        	<label style="padding: 0px 20px 0 0;">试题题目:</label>
                            <span class="field">${subject.stTitle}</span>
                        	</p><p>
                        	<label style="padding: 0px 20px 0 0;">选项A:</label>
                            <span class="field">${subject.stOptionA}</span>
                       		</p><p>
                       		<label style="padding: 0px 20px 0 0;">选项B:</label>
                            <span class="field">${subject.stOptionB}</span>
                        	</p><p>
                        	<label style="padding: 0px 20px 0 0;">选项C:</label>
                            <span class="field">${subject.stOptionC}</span>
                        	</p><p>
                        	<label style="padding: 0px 20px 0 0;">选项D:</label>
                            <span class="field">${subject.stOptionD}</span>
                       		</p><p>
                       		<label style="padding: 0px 20px 0 0;">答案:</label>
                            <span class="field">${subject.stAnswer}</span>
                        	</p><p>
                        	<label style="padding: 0px 20px 0 0;">答案解析:</label>
                            <span class="field">${subject.stParse}</span>
                       	</p>
                      
                    
                </form>
            </div><!--widgetcontent-->
            </div><!--widget-->
                
                <br /><br />
              
                <div class="footer">
                    <div class="footer-left">
                        <span>&copy; 2013. All Rights Reserved.</span>
                    </div>
                    
                </div><!--footer-->
            
            </div><!--maincontentinner-->
        </div><!--maincontent-->

   </div><!--rightpanel-->
    
</div><!--mainwrapper-->


</html>