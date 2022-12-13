package com.susu.spring.test.ioc;

import com.susu.spring.context.support.ClassPathXmlApplicationContext;
import com.susu.spring.test.bean.Student;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BeanFactoryTest {

    @Test
    public void beanFactoryTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:factory-bean.xml");

        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
        assertThat(student.getName()).isEqualTo("张三");
    }
}
