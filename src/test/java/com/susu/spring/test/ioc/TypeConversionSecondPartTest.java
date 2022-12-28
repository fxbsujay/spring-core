package com.susu.spring.test.ioc;

import com.susu.spring.context.support.ClassPathXmlApplicationContext;
import com.susu.spring.test.bean.Student;
import org.junit.Test;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

public class TypeConversionSecondPartTest {

	@Test
	public void conversionServiceTest() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:type-conversion-second-part.xml");

		Student student = applicationContext.getBean("student", Student.class);
		assertThat(student.getBirthDate()).isEqualTo(LocalDate.of(2022, 12, 28));
	}
}
