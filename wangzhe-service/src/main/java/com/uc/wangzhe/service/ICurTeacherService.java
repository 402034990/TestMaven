package com.uc.wangzhe.service;

import java.util.List;

import com.uc.wangzhe.dao.ICurTeacherDao;
import com.uc.wangzhe.dto.CurTeacherDto;
import com.uc.wangzhe.pojo.CurTeacher;

public interface ICurTeacherService extends IBaseService<CurTeacher>{
		
	List<CurTeacherDto> list();
	
}
