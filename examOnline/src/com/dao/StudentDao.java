package com.dao;

import java.util.List;

import com.entity.Student;
import com.util.Page;

public interface StudentDao extends BaseDao{
	public Student findByStudenID(String studentID);//根据学生ID查询一条记录
	public void updateStudent(Student student);//更新学生的信息
	public List<Student> findByStudentName(String name);//根据学生的姓名查找学生
	public List<Student> findByStudentClass(String sclass,Page page);//根据班级查找学生 -分页查询
	public void save(Student student);//保存一个学生记录
	public List<Student> findStudentsByPage(Page page);//根据分页查询结果;
	public int fintStudentCount();//返回所有学生数量
	int fintStudentCountByClass(String sclass);//返回班级学生数量
	public List<Student> findStudentsByClass(String sclass, Page page);//查询班级学生 -分页查询
}
