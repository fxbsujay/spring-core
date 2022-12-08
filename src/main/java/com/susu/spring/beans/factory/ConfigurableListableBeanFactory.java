package com.susu.spring.beans.factory;

import com.susu.spring.beans.BeansException;
import com.susu.spring.beans.factory.config.AutowireCapableBeanFactory;
import com.susu.spring.beans.factory.config.BeanDefinition;
import com.susu.spring.beans.factory.config.ConfigurableBeanFactory;

/**
 * <p>Description:  提供 bean definition 的解析, 注册功能, 再对单例来个预加载(解决循环依赖问题) </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * <p>Description: 根据 Bean名称查询 BeanDefinition</p>
     *
     * @param beanName          名称
     * @return                  {@link BeanDefinition}
     * @throws BeansException   空异常
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 提前实例化所有的单例实例
     */
    void preInstantiateSingletons() throws BeansException;
}
