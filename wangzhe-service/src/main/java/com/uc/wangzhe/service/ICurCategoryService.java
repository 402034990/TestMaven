package com.uc.wangzhe.service;

import java.util.List;

import com.uc.wangzhe.pojo.CurCategory;
import com.uc.wangzhe.pojo.CurTeacher;

public interface ICurCategoryService extends IBaseService<CurCategory>{
	
	public void saveCateAndTeach(CurCategory cat,CurTeacher teacher);
	
	public List<CurCategory> list();
}
