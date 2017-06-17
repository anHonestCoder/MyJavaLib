package org.simon.zhao.java.spring.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.simon.zhao.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Zhaozhou
 * @date 2017/6/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ComponentScanTest {


	@Autowired
	StudentService studentService;
	@Test
	public void testComponetScan() {
		System.out.println(studentService.count());;
	}
}
