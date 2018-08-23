package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.Subject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SubjectService;
import com.service.SubjectServiceImpl;
/**
 * 显示正确的答案并且显示解析
 * @author Junchuan.Wu
 *
 */
public class ShowSubjectAnswerAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SubjectService subjectService = new SubjectServiceImpl();
	@SuppressWarnings({ "unchecked", "static-access" })
	public String execute(){
		List<Subject> subjects = new ArrayList<Subject>();
		HttpServletRequest request = ServletActionContext.getRequest();//获取request
		Map session = ActionContext.getContext().getSession();//获取session
		List<Integer> stIDs = (List<Integer>)session.get("stIDs");
		for (Integer subjectID : stIDs) {
			Subject subject = subjectService.showSubjectDetail(subjectID);
			subjects.add(subject);
		}
		request.setAttribute("subjects", subjects);//把试题的信息封装成request发送给页面
		return this.SUCCESS;
	}
}
