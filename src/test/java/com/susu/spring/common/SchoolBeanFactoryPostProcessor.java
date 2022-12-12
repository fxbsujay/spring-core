package com.susu.spring.common;

import com.susu.spring.beans.BeansException;
import com.susu.spring.beans.PropertyValue;
import com.susu.spring.beans.PropertyValues;
import com.susu.spring.beans.factory.ConfigurableListableBeanFactory;
import com.susu.spring.beans.factory.config.BeanDefinition;
import com.susu.spring.beans.factory.config.BeanFactoryPostProcessor;

public class SchoolBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("在所有BeanDefinition加载完成后，但在bean实例化之前，修改School的name属性");
        BeanDefinition school = beanFactory.getBeanDefinition("school");
        PropertyValues propertyValues = school.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name","烤地瓜大学"));
    }
}
