package com.susu.spring.beans.factory.support;

import com.susu.spring.beans.BeansException;
import com.susu.spring.beans.factory.config.BeanDefinition;

/**
 * <p>Description: BeanDefinition注册表接口 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-12
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 根据名称查找BeanDefinition
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 是否包含指定名称的BeanDefinition
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回定义的所有bean的名称
     */
    String[] getBeanDefinitionNames();
}
