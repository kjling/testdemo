package com.dao;

public interface BaseDao {
	//增
	public void save(Object object);
	//删
	public void delete(Object object);
	//查
	public Object find(Object object,int id);
	//改
	public void update(Object object);
}
