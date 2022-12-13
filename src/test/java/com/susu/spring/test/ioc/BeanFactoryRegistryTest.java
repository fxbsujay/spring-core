package com.susu.spring.test.ioc;

import com.susu.spring.beans.factory.config.BeanDefinition;
import com.susu.spring.beans.factory.support.DefaultListableBeanFactory;
import com.susu.spring.test.bean.HelloWorldService;
import org.junit.Test;

public class BeanFactoryRegistryTest {

    @Test
    public void beanFactoryRegistryTest() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinition bean = new BeanDefinition(HelloWorldService.class);
        factory.registerBeanDefinition("helloWorldService",bean);

        HelloWorldService service = (HelloWorldService) factory.getBean("helloWorldService");
        service.sayHello();
    }
}
