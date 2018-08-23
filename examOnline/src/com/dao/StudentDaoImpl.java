package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Student;
import com.util.HibernateSessionFactory;
import com.util.Page;

public class StudentDaoImpl extends BaseDaoImpl implements StudentDao {
	/**
	 * 根据学号查找学生
	 */
	@Override
	public Student findByStudenID(String studentID) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Student student where studentID=?";
		Query query = session.createQuery(hql);
		query.setString(0, studentID);
		Student student = (Student) query.uniqueResult();
		HibernateSessionFactory.closeSession();
		return student;
	}
	/**
	 * 根据学生班级查找学生 -分页查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findByStudentClass(String sclass,Page page) {
		String hql = "from Student as stu where stu.sclass=:sclass";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		query.setString("sclass", sclass);
		query.setMaxResults(page.getEveryPage());//每页显示的数量
		query.setFirstResult(page.getBeginIndex());//起始位置
		List<Student> list = query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}
	/**
	 * 根据学生姓名查找
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findByStudentName(String name) {
		String hql = "from Student as stu where stu.studentName=:studentName";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		query.setString("studentName", name);
		List<Student> list = query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}
	/**
	 * 更新学生信息
	 */
	@Override
	public void updateStudent(Student student) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(student);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();//回滚事务
		}finally{
			HibernateSessionFactory.closeSession();
		}

	}
	/**
	 * 保存一条学生记录
	 */
	@Override
	public void save(Student student) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(student);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	/**
	 * 查询所有学生 -分页查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findStudentsByPage(Page page) {
		String hql = "from Student";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		query.setMaxResults(page.getEveryPage());//每页显示的数量
		query.setFirstResult(page.getBeginIndex());//起始位置
		List<Student> list = query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}
	/**
	 * 查询班级学生 -分页查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findStudentsByClass(String sclass, Page page) {
		String hql = "from Student as stu where stu.sclass=:sclass";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		query.setString("sclass", sclass);
		query.setMaxResults(page.getEveryPage());//每页显示的数量
		query.setFirstResult(page.getBeginIndex());//起始位置
		List<Student> list = query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}
	/**
	 * 返回所有学生数量
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int fintStudentCount() {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Student");
		List<Student> list = query.list();
		int count = list.size();
		HibernateSessionFactory.closeSession();
		return count;
	}
	/**
	 * 返回班级学生数量
	 */
	@Override
	public int fintStudentCountByClass(String sclass) {
		String hql = "from Student as stu where stu.sclass=:sclass";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		query.setString("sclass", sclass);
		int count = query.list().size();
		HibernateSessionFactory.closeSession();
		return count;
	}
	
}
