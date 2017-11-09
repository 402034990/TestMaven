package com.uc.wangzhe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uc.wangzhe.dao.ICourseDao;
import com.uc.wangzhe.dto.CurCourseDto;
import com.uc.wangzhe.pojo.CurCourse;


@Service
public class CourseServiceImpl extends BaseServiceImpl<CurCourse> implements ICourseService {
	private ICourseDao courseDao;
	
	
	@Autowired
	public void setCourseDao(ICourseDao courseDao) {
		this.courseDao = courseDao;
		this.setBaseDao(courseDao);
	}
	
	@Override
	public List<CurCourseDto> list() {
		String hsql = "from CurCourse";
		
		
		List<CurCourse> courses = this.list(hsql);
		
		List<CurCourseDto> courseDtos = new ArrayList();
		for (int i = 0; i < courses.size(); i++) {
			CurCourseDto courseDto = new CurCourseDto();
			BeanUtils.copyProperties(courses.get(i), courseDto);
			courseDtos.add(courseDto);
		}
		
		return courseDtos;
	}
}
