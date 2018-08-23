package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;
import com.service.StudentServiceImpl;

/**
 * 查找学生信息 -根据学生的id号
 * @author junchuan.Wu
 *
 */
public class QueryStudentByIDAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String studentID;
	private StudentService studentService = new StudentServiceImpl();
	public String getStudentID() {
		return studentID;
	}


	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	@SuppressWarnings("static-access")
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Student student = studentService.getStudentInfo(studentID);
		request.setAttribute("students", student);
		return this.SUCCESS;
	}
}
