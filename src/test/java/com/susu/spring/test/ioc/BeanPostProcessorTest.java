package com.susu.spring.test.ioc;

import com.susu.spring.beans.factory.support.DefaultListableBeanFactory;
import com.susu.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.susu.spring.test.bean.School;
import com.susu.spring.test.bean.Student;
import com.susu.spring.test.common.SchoolBeanFactoryPostProcessor;
import com.susu.spring.test.common.StudentBeanPostProcessor;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BeanPostProcessorTest {

    @Test
    public void beanPostProcessorTest() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(factory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        StudentBeanPostProcessor postProcessor = new StudentBeanPostProcessor();
        factory.addBeanPostProcessor(postProcessor);

        Student student = factory.getBean("student", Student.class);
        System.out.println(student);
        assertThat(student.getName()).isEqualTo("李四");
    }

    @Test
    public void beanFactoryPostProcessorTest() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(factory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        SchoolBeanFactoryPostProcessor postProcessor = new SchoolBeanFactoryPostProcessor();
        postProcessor.postProcessBeanFactory(factory);

        School school = factory.getBean("school", School.class);
        System.out.println(school);
        assertThat(school.getName()).isEqualTo("烤地瓜大学");
    }
}
