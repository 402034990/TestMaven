package com.uc.wangzhe.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uc.wangzhe.pojo.CurTeacher;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class CurTeacherServiceImplTest {
	@Autowired
	ICurTeacherService service;
	
	
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		CurTeacher te = new CurTeacher();
		te.setName("李耳2");
		
		service.save(te);
	}

	@Test
	public void testGet() {
		CurTeacher te = service.get(2);
		System.out.println(te.getName());
	}

	@Test
	public void testLoad() {
		fail("Not yet implemented");
	}

	@Test
	public void testList() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

}
