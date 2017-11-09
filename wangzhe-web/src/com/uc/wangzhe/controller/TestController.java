package com.uc.wangzhe.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uc.wangzhe.dto.CurCourseDto;
import com.uc.wangzhe.dto.CurTeacherDto;
import com.uc.wangzhe.pojo.CurCourse;
import com.uc.wangzhe.pojo.CurTeacher;
import com.uc.wangzhe.service.ICourseService;
import com.uc.wangzhe.service.ICurTeacherService;

@Controller
public class TestController {
	
	//自动注入需要使用service的实例
	@Autowired
	ICurTeacherService service ;
	
	@Autowired
	ICourseService courseService ;
	
	@RequestMapping("/test/test01")
	@ResponseBody
	public String test01(){
		
		
		return "这是一个测试，你好世界!";
	}
	
	@RequestMapping("/test/test02")
	@ResponseBody
	public List<CurTeacherDto> test02(){
		List<CurTeacherDto> list = service.list();
		return list;
	}
	
	@RequestMapping("/test/test03")
	@ResponseBody
	public CurTeacher test03(){
		System.out.println("------aaaaaaa----------");
		CurTeacher curTeacher = service.get(2);
		return curTeacher;
	}
}
