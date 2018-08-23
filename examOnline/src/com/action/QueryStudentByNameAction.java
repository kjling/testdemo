package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;
import com.service.StudentServiceImpl;

/**
 * 查找学生信息 -根据姓名
 * @author junchuan.Wu
 *
 */
public class QueryStudentByNameAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String studentName;
	private StudentService studentService = new StudentServiceImpl();
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	@SuppressWarnings("static-access")
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Student> students = studentService.getStudentByName(studentName);
		request.setAttribute("students", students);
		return this.SUCCESS;
	}
}
