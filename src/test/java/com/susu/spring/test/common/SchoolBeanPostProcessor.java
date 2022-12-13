package com.susu.spring.test.common;

import com.susu.spring.test.bean.Student;
import com.susu.spring.beans.BeansException;
import com.susu.spring.beans.factory.config.BeanPostProcessor;

public class SchoolBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在bean执行初始化方法之前执行此方法，修改Student的name属性");
        if ("student".equals(beanName)) {
            ((Student) bean).setName("李四");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在bean执行初始化方法之后执行此方法");
        return bean;
    }
}
