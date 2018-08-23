package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;
import com.service.StudentServiceImpl;
import com.util.Page;
import com.util.PageResult;
import com.util.PageUtil;

public class StudentQuery extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int currentPage;//当前页
	private int everyPage =10;//每一页记录
	private StudentService studentService = new StudentServiceImpl();
	private int totalCount = studentService.countStudent();
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	/**
	 * 获取所有学生的信息
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	@Override
	public String execute() throws Exception {
		Page page = new Page();
		page = PageUtil.createPage(everyPage, totalCount, currentPage);//获取分页信息
		PageResult pageResult = studentService.queryStudentByPage(page);
		List<Student> students = pageResult.getList();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("students", students);
		request.setAttribute("page", page);
		return this.SUCCESS;
	}
}
