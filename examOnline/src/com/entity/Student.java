package com.entity;

import com.util.MD5;


/*
 * 学生表,保存学生编号，系统密码
 */
public class Student {
	private int sysid;//系统编号、primary Key
	private String studentID;//学号
	private String password;//密码
	private String studentName;//学生名字
	private Integer result;//成绩
	private String sclass;//班级
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public void setSysid(int sysid) {
		this.sysid = sysid;
	}
	public int getSysid() {
		return sysid;
	}
	@Override
	public String toString() {
		return "Student [password=" + password + ", result=" + result
				+ ", sclass=" + sclass + ", studentID=" + studentID
				+ ", studentName=" + studentName + ", sysid=" + sysid + "]";
	}
	
}
