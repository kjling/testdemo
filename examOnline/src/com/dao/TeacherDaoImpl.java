package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.entity.Teacher;
import com.util.HibernateSessionFactory;

public class TeacherDaoImpl extends BaseDaoImpl implements TeacherDao {
	/**
	 *  根据teacherID获取Teacher
	 *  返回一个Teacher对象
	 */
	@Override
	public Teacher findByTeacherID(String teacherID) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Teacher teacher where teacherID=?";
		Query query = session.createQuery(hql);
		query.setString(0, teacherID);
		Teacher teacher = (Teacher)query.uniqueResult();//返回唯一的记录
		HibernateSessionFactory.closeSession();
		return teacher;
	}

}
