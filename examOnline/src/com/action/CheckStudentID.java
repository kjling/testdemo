package com.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentServiceImpl;

public class CheckStudentID extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String studentID;
	private StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	@Override
	public String execute() throws Exception {
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if (studentServiceImpl.getStudentInfo(studentID)!=null) {//如果有重复的话
			out.print("学生编号已存在！请重新输入！");
		}else{
			out.print("可以注册！");
		}
		return null;
	}

}
