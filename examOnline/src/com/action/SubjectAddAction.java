package com.action;

import com.entity.Subject;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SubjectService;
import com.service.SubjectServiceImpl;

public class SubjectAddAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String stTitle;
	private String stOptionA;
	private String stOptionB;
	private String stOptionC;
	private String stOptionD;
	private String stAnswer;
	private String stParse;
	private SubjectService subjectService = new SubjectServiceImpl();
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
	public String execute() throws Exception{
		Subject subject = new Subject();
		subject.setStTitle(stTitle);
		subject.setStOptionA(stOptionA);
		subject.setStOptionB(stOptionB);
		subject.setStOptionC(stOptionC);
		subject.setStOptionD(stOptionD);
		subject.setStAnswer(stAnswer);
		subject.setStParse(stParse);
		if(subjectService.saveSubject(subject)){
			return this.SUCCESS;
		}else{
			this.addActionError("试题重复，不要重复添加");
			return this.ERROR;
		}
	}
}
