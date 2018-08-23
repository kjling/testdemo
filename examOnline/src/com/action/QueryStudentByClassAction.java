package com.action;

import java.io.UnsupportedEncodingException;
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

/**
 * 查找学生信息 -根据班级
 * @author junchuan.Wu
 *
 */
public class QueryStudentByClassAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int currentPage;
	private int everyPage=10;
	private String sclass;
	private StudentService studentService = new StudentServiceImpl();
	private int totalCount;
	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	
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

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@SuppressWarnings("static-access")
	public String execute(){
		Page page = new Page();
		if(currentPage>0){
			//currentPage为0时，用post传参不会出现编码不一致
			//currentPage大于0时，用get传参会出现编码不一致的情况
			try {
				sclass = new String(sclass.getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				System.out.println("编码转换错误！！！");
			}
		}
		totalCount= studentService.countStudentByClass(sclass);
		page = PageUtil.createPage(everyPage, totalCount, currentPage);
		PageResult pageResult = studentService.getStudentByClass(sclass, page);
		List<Student> students = pageResult.getList();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("students", students);
		request.setAttribute("page", page);
		request.setAttribute("sclass", sclass);
		return this.SUCCESS;
	}
}
