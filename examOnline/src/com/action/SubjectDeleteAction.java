package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.service.SubjectService;
import com.service.SubjectServiceImpl;

public class SubjectDeleteAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int stId;
	private SubjectService subjectService = new SubjectServiceImpl();
	
	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	@SuppressWarnings("static-access")
	@Override
	public String execute() throws Exception {
		subjectService.deleteSubject(stId);
		addActionMessage("删除成功!");
		return this.SUCCESS;
	}
	
}
