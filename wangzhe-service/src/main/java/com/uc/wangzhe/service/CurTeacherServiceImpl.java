package com.uc.wangzhe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uc.wangzhe.dao.ICurTeacherDao;
import com.uc.wangzhe.dto.CurTeacherDto;
import com.uc.wangzhe.pojo.CurTeacher;

@Service
public class CurTeacherServiceImpl extends BaseServiceImpl<CurTeacher> implements ICurTeacherService  {
	private ICurTeacherDao teacherDao;
	
	@Autowired
	public void setTeacherDao(ICurTeacherDao teacherDao) {
		this.teacherDao = teacherDao;
		this.setBaseDao(teacherDao);//设置父类的dao
	}

	@Override
	public List<CurTeacherDto> list() {
		// TODO Auto-generated method stub
		String hql = "from CurTeacher";
		List<CurTeacher> curTeachers = this.list(hql);
		List<CurTeacherDto> list = new ArrayList<CurTeacherDto>();
		for (int i = 0; i < curTeachers.size(); i++) {
			CurTeacherDto teacher = new CurTeacherDto();
			BeanUtils.copyProperties(curTeachers.get(i), teacher);
			list.add(teacher);
		}
		return list;
	}
}
