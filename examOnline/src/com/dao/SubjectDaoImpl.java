package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import sun.security.krb5.internal.PAEncTSEnc;

import com.entity.Subject;
import com.util.HibernateSessionFactory;
import com.util.Page;

public class SubjectDaoImpl  extends BaseDaoImpl implements SubjectDao {
	/**
	 * 根据id删除一条记录
	 */
	@Override
	public void deleteByID(int id) {
		Session session = HibernateSessionFactory.getSession();
		Subject subject = (Subject)session.get(Subject.class, id);//获取要删除的对象
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(subject);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}
	/**
	 * 查询的结果数量
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int findLikeQueryCount(String title) {
		String hql = "from Subject as sub where sub.stTitle like :title ";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		query.setString("title", "%"+title+"%");
		List list = query.list();
		int count = list.size();
		HibernateSessionFactory.closeSession();
		return count;
	}
	/**
	 * 根据id查询一条记录
	 */
	@Override
	public Subject findSubjectByID(int id) {
		Session session = HibernateSessionFactory.getSession();
		Subject subject = (Subject)session.get(Subject.class, id);
		HibernateSessionFactory.closeSession();
		return subject;
	}
	/**
	 * 根据title返回一条记录，如果没有的话，返回空值
	 * 要精准匹配= =
	 * 如果有的话，就返回匹配的**第一条信息**
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Subject findSubjectByTitle(String title) {
		String hql = "from Subject as sub where sub.stTitle=?";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		query.setString(0, title);
		List<Subject> list = query.list();
		HibernateSessionFactory.closeSession();
		if(list.size()==0){
			return null;
		}else{
			return (Subject) list.get(0);//返回第一个匹配的试题
		}
	}
	/**
	 * 返回记录数
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int findSubjectCount() {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject");
		List<Subject> list = query.list();
		int count = list.size();
		return count;
	}
	/**
	 * 根据要显示的分页要求，查询结果
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> findSubjectsByPage(Page page) {
		String hql = "from Subject";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		query.setMaxResults(page.getEveryPage());//每页显示的数量
		query.setFirstResult(page.getBeginIndex());//起始位置
		List<Subject> list = query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}
	/**
	 * 根据title模糊查询
	 * @param title 
	 * @param page 指定查询的数量
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> likeQueryByTitle(String title, Page page) {
		String hql = "from Subject as sub where sub.stTitle like :title ";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		query.setString("title", "%"+title+"%");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		List<Subject> list =query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}
	/**
	 * 随机抽取题目
	 * @param number 指定抽取的数目
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> randomFindSubjects(int number) {
		String hql = "from Subject as sub order by rand()";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		query.setMaxResults(number);
		List<Subject> list =query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}
	
}
