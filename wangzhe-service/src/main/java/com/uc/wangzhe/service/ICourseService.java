package com.uc.wangzhe.service;

import java.util.List;

import com.uc.wangzhe.dto.CurCourseDto;
import com.uc.wangzhe.pojo.CurCourse;

public interface ICourseService extends IBaseService<CurCourse> {

	List<CurCourseDto> list();
}
