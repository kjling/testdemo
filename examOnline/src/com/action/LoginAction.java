package com.action;

import java.util.Map;

import com.entity.Student;
import com.entity.Teacher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;
import com.service.StudentServiceImpl;
import com.service.TeacherService;
import com.service.TeacherServiceImpl;
import com.util.MD5;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String role;// 接受用户角色
	private StudentService studentService = new StudentServiceImpl();
	private TeacherService teacherService = new TeacherServiceImpl();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public String execute() {
		if ("student".equals(role)) {
			// 如果是学生身份登录的话
			// 判断账号密码正确与否
			if (studentService.allowLogin(username, password)) {
				Student studentInfo = studentService.getStudentInfo(username);
				Map session = ActionContext.getContext().getSession();//获取session
				session.put("studentInfo", studentInfo);//把学生信息封装到session当中
				return "studentSuccess";
			}else{
				addActionError("学生编号不存在或者密码输入不正确");
				return this.INPUT;
			}
		}else{
			if(teacherService.allowLogin(username, password)){
				Teacher teacherInfo = teacherService.getTeacherInfo(username);//获取老师的信息
				Map session = ActionContext.getContext().getSession();
				session.put("teacherInfo",teacherInfo);//将教师信息封装保存到session当中
				return "teacherSuccess";
			}else{
				addActionError("教师编号不存在或者密码输入不正确");
				return this.INPUT;
			}
		}
	}

}
