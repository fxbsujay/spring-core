package com.susu.spring.beans.factory.config;

import com.susu.spring.beans.BeansException;
import com.susu.spring.beans.factory.ConfigurableListableBeanFactory;

/**
 * <p>Description: 允许自定义修改BeanDefinition的属性值</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface BeanFactoryPostProcessor {

    /**
     *  在所有BeanDefinition加载完成后，但在bean实例化之前，提供修改BeanDefinition属性值的机制
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
