package com.uc.wangzhe.service;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T> {
	public void delete(T entity);
	public void update(T entity);
	public void save(T entity);
	
	public T get(Serializable id);
	public T load(Serializable id);
	
	public List<T> list(String hql);
	
	public void deleteById(Serializable id);
}
