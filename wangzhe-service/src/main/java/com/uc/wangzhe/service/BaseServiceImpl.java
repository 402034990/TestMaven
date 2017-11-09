package com.uc.wangzhe.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.uc.wangzhe.dao.IBaseDao;

public class BaseServiceImpl<T> implements IBaseService<T>{
	
	//@Autowired 
	IBaseDao<T> baseDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(T entity) {
		baseDao.delete(entity);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void update(T entity) {
		baseDao.update(entity);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void save(T entity) {
		baseDao.save(entity);
		//int i=100/0; 测试事务在异常时候是否会自动回滚
	}

	@Override
	public T get(Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.get(id);
	}

	@Override
	public T load(Serializable id) {
		return baseDao.load(id);
	}

	@Override
	public List<T> list(String hql) {
		return baseDao.list(hql);
	}
	
	public void setBaseDao(IBaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteById(Serializable id) {
		T entity = this.get(id);
		this.delete(entity);
	}

	
}
