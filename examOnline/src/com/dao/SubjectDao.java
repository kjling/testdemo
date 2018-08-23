package com.dao;

import java.util.List;

import com.entity.Subject;
import com.util.Page;

public interface SubjectDao extends BaseDao{
	//根据标题找到题目
	public Subject findSubjectByTitle(String title);
	//分页查询试题
	public List<Subject> findSubjectsByPage(Page page);
	//查询试题总量
	public int findSubjectCount();
	//根据id查询试题
	public Subject findSubjectByID(int id);
	//根据试题ID删除试题
	public void deleteByID(int id);
	//根据试题标题**模糊查询**试题
	public List<Subject> likeQueryByTitle(String title,Page page);
	//模糊查询的记录数
	public int findLikeQueryCount(String title);
	//随机取出试题
	public List<Subject> randomFindSubjects(int number);
}
