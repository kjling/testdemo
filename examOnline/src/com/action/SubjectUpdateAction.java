package com.action;

import com.entity.Subject;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SubjectService;
import com.service.SubjectServiceImpl;

public class SubjectUpdateAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int stId;//编号
	private String stTitle;//题目
	private String stOptionA;//选项
	private String stOptionB;//
	private String stOptionC;//
	private String stOptionD;//
	private String stAnswer;//答案
	private String stParse;//解析
	
	private SubjectService subjectService = new SubjectServiceImpl();
	
	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public String getStTitle() {
		return stTitle;
	}

	public void setStTitle(String stTitle) {
		this.stTitle = stTitle;
	}

	public String getStOptionA() {
		return stOptionA;
	}

	public void setStOptionA(String stOptionA) {
		this.stOptionA = stOptionA;
	}

	public String getStOptionB() {
		return stOptionB;
	}

	public void setStOptionB(String stOptionB) {
		this.stOptionB = stOptionB;
	}

	public String getStOptionC() {
		return stOptionC;
	}

	public void setStOptionC(String stOptionC) {
		this.stOptionC = stOptionC;
	}

	public String getStOptionD() {
		return stOptionD;
	}

	public void setStOptionD(String stOptionD) {
		this.stOptionD = stOptionD;
	}

	public String getStAnswer() {
		return stAnswer;
	}

	public void setStAnswer(String stAnswer) {
		this.stAnswer = stAnswer;
	}

	public String getStParse() {
		return stParse;
	}

	public void setStParse(String stParse) {
		this.stParse = stParse;
	}

	@SuppressWarnings("static-access")
	@Override
	public String execute() throws Exception {
		Subject subject = new Subject();
		subject.setStID(stId);
		subject.setStTitle(stTitle);
		subject.setStOptionA(stOptionA);
		subject.setStOptionB(stOptionB);
		subject.setStOptionC(stOptionC);
		subject.setStOptionD(stOptionD);
		subject.setStAnswer(stAnswer);
		subject.setStParse(stParse);
		subjectService.updateSubject(subject);
		this.addActionMessage("更新成功");
		return this.SUCCESS;
	}
	
}
