package com.uc.wangzhe.dao;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uc.wangzhe.pojo.CurTeacher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class CurTeacherDaoImplTest {
	@Autowired
	ICurTeacherDao dao ;
	
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		CurTeacher te = new CurTeacher();
		te.setName("孔子");
		
		dao.save(te);
	}

	@Test
	public void testList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		CurTeacher te = dao.get(1);
		System.out.println(te.getName());
	}

	@Test
	public void testLoad() {
		fail("Not yet implemented");
	}

}
