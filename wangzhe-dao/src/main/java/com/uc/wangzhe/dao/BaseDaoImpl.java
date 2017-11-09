package com.uc.wangzhe.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 *
 *  注解方式的问题：如何注入sessionFacrtory，使得HibernateDaoSupport能够操作数据库:
 *    处理方式，创建一个另外的方法，自动注入sessionFactory，来设置父类的sessionFactory
 *  
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T>  {
	private Class<T> entityClass;
	
	
	
    //使用反射技术,在构造函数中获取运行时候pojo的类型
   public BaseDaoImpl() {
		// 是得到这个类的得到泛型父类
		Type genType = getClass().getGenericSuperclass();
		//返回表示此类型实际类型参数的Type对象的数组,对应类型的Class
        //可能有多个，取第0个。
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}
   
     //自动注入sessionFactory，来设置父类的sessionFactory
    @Autowired
    public void setParendtSessionFacrory(SessionFactory sessionFactory){
    	this.setSessionFactory(sessionFactory);
    }
	
	@Override
	public void delete(Object entity) {
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(Object entity) {
		this.getHibernateTemplate().update(entity);
	}

	@Override
	//@Transactional(propagation=Propagation.REQUIRED)//如果要在dao層保存數據，需要啓動事務. ，但一般在服務層啓動事務.
	public void save(Object entity) {
		this.getHibernateTemplate().save(entity);
		
	}

	@Override
	public List list(String queryString) {
		return this.getHibernateTemplate().find(queryString);
	}

	@Override
	public T get(Serializable id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public T load(Serializable id) {
		return this.getHibernateTemplate().load(entityClass, id);
	}

	
	
	//如果要实现翻页，必须要使用Session来创建Query对象，然后设置setMaxResults,
	//select * from t_test limit 10,5   --第一个参数是其实位置，第二参数是返回的条数
	
	//使用ssh框架，session的创建使用框架来完成的，如何得到session来实现一些复杂的功能呢？使用HibernateCallback
	//HibernateCallback 让我们可以介入进去实现代码的嵌入
	@Override
	public List<T> queryPage(String hsql, int pageNo, int pageSize, Object... params) {
		List<T> data = this.getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			@Override
			public List<T> doInHibernate(Session arg0) throws HibernateException {
				Query qr = arg0.createQuery(hsql);
				
				//设置hsql参数
				if(params != null){
					for (int i = 0; i < params.length; i++) {
						qr.setParameter(i, params[i]);
					}
				}
				//设置翻页
				qr.setFirstResult((pageNo-1)*pageSize);//设置起始记录位置
				qr.setMaxResults(pageSize);//返回的记录条数  
				
				return qr.list();
			}
		});
		
		return data;
	}


	@Override
	public List<T> find(String hql, Object... params) {
		return (List<T>) this.getHibernateTemplate().find(hql, params);
	}
	
	
	//实现批量的更新或者删除 //测试视频的录制大小
	@Override
	public int updateObjects(final String hql, final Object... conditions) {
		int count = this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				try{
					Query query = session.createQuery(hql);
					for(int i=0;i<conditions.length;i++){
						query.setParameter(i, conditions[i]);
					}				
					return query.executeUpdate();
				}catch(Exception e){
					e.printStackTrace();
				}
				return 0;
			}
		});
		return count;
	}
}
