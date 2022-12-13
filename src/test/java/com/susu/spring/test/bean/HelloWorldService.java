package com.susu.spring.test.bean;

import com.susu.spring.beans.BeansException;
import com.susu.spring.beans.factory.BeanFactory;
import com.susu.spring.beans.factory.BeanFactoryAware;
import com.susu.spring.context.ApplicationContext;
import com.susu.spring.context.ApplicationContextAware;

public class HelloWorldService implements ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    public String sayHello() {
        System.out.println("Hello World !!");
        return "Hello World !!";
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
