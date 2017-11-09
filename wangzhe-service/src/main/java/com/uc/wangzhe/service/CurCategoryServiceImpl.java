package com.uc.wangzhe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uc.wangzhe.dao.ICurCategoryDao;
import com.uc.wangzhe.pojo.CurCategory;
import com.uc.wangzhe.pojo.CurTeacher;

/**
 * @author Administrator
 *
 *
 *
 */

@Service
public class CurCategoryServiceImpl extends BaseServiceImpl<CurCategory> implements ICurCategoryService{
	//@Autowired
	private ICurCategoryDao curDao;
	
	//@Autowired
	//private ICurTeacherDao teacherDao;
	
	@Autowired //依赖其他业务对象实现一些逻辑，目的是为了测试事务传播.
	ICurTeacherService teacherService;
	
	//测试事务传播
	@Override
	public void saveCateAndTeach(CurCategory cat,CurTeacher teacher){
		curDao.save(cat);
		
		//如果事务传播是REQUIRE_NEW,两个业务方法是独立的事务。如果异常，其中一个数据以会保存
		//如果事务传播是REQUIRE,两个业务方法是独立的事务，都不会保存.
		teacherService.save(teacher);//调用其他业务对象实现一些逻辑。测试事务传播
		//int i=1/0;
	}
	
	
	//通过方法来注入ｄａｏ，目的是为了同时可以是设置父类的ｂａｓｅＤａｏ。
	@Autowired
	public void setCurDao(ICurCategoryDao curDao) {
		this.curDao = curDao;
		this.setBaseDao(curDao);
	}
	
	
	@Override
	public List<CurCategory> list() {
		String hsql = "from CurCateogry";
		return this.list(hsql);
	}
}