package com.service;

import java.util.List;

import com.entity.Student;
import com.util.Page;
import com.util.PageResult;

public interface StudentService {
	//判断是否为合法学生，决定是否登录
	public boolean allowLogin(String studentID,String password);
	//获得学生的信息 单个
	public Student getStudentInfo(String studentID);
	//设置学生成绩
	public void setStudentResult(String studentID,int result);
	//根据学生的姓名查找信息
	public List<Student> getStudentByName(String studentName);
	//根据班级查找学生
	public PageResult getStudentByClass(String sclass,Page page);
	//保存一个学生记录
	public void saveStudent(Student student);
	//根据分页查询学生记录
	public PageResult queryStudentByPage(Page page);
	//获取学生数量
	public int countStudent();
	public int countStudentByClass(String sclass);
}
