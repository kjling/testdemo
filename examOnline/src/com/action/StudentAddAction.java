package com.action;

import com.entity.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;
import com.service.StudentServiceImpl;
import com.util.MD5;

public class StudentAddAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String studentID;
	private String studentName;
	private String sclass;
	
	
	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	private StudentService studentService = new StudentServiceImpl();
	
	@Override
	public String execute() throws Exception {
		Student student = new Student();
		student.setPassword(MD5.Encrypt("123456"));//默认密码
		student.setSclass(sclass);//student class
		student.setStudentID(studentID);//studentid
		student.setStudentName(studentName);//name
		studentService.saveStudent(student);
		return SUCCESS;
	}
	
}
