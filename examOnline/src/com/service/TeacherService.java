package com.service;

import com.entity.Teacher;

public interface TeacherService {
	//判断是否是合法的老师，账号密码是否正确，返回boolean
	public boolean allowLogin(String teacherID,String password);
	//返回老师信息
	public Teacher getTeacherInfo(String teacherID);
}
