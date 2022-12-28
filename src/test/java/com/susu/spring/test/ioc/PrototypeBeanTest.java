package com.susu.spring.test.ioc;

import com.susu.spring.context.support.ClassPathXmlApplicationContext;
import com.susu.spring.test.bean.Student;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeBeanTest {

	@Test
	public void prototypeTest() throws Exception {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:prototype-bean.xml");

		Student student1 = applicationContext.getBean("student", Student.class);
		Student student2 = applicationContext.getBean("student", Student.class);
		assertThat(student1 != student2).isTrue();
	}
}
