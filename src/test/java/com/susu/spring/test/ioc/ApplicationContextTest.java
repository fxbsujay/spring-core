package com.susu.spring.test.ioc;

import com.susu.spring.test.bean.HelloWorldService;
import com.susu.spring.test.bean.School;
import com.susu.spring.test.bean.Student;
import com.susu.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextTest {

    @Test
    public void springContextTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");

        School school = context.getBean("school", School.class);
        System.out.println(school);
        assertThat(school.getName()).isEqualTo("烤地瓜大学");

        Student student = context.getBean("student", Student.class);
        System.out.println(student);
        assertThat(student.getName()).isEqualTo("李四");

        HelloWorldService helloWorldService = context.getBean("helloWorldService", HelloWorldService.class);
        helloWorldService.sayHello();
        assertThat(helloWorldService.getApplicationContext()).isNotNull();
        assertThat(helloWorldService.getBeanFactory()).isNotNull();
    }

    @Test
    public void AutowiredAnnotationTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:autowired-annotation.xml");

        School school = context.getBean(School.class);
        System.out.println(school);

        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }
}
