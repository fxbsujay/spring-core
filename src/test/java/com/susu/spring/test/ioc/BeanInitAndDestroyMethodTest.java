package com.susu.spring.test.ioc;

import com.susu.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

public class BeanInitAndDestroyMethodTest {

    @Test
    public void beanInitAndDestroyMethodTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:init-and-destroy-method.xml");
        applicationContext.registerShutdownHook();
        // applicationContext.close();
    }
}
