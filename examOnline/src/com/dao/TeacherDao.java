package com.dao;

import com.entity.Teacher;

public interface TeacherDao extends BaseDao{
	//根据教师id返回结果
	public Teacher findByTeacherID(String teacherID);
}
