package com.susu.spring.beans.factory.config;

import com.susu.spring.beans.BeansException;
import com.susu.spring.beans.PropertyValues;

/**
 * <p>Description: Bean实例化过程中所需要处理的方法 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-12
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * 在bean实例化之前执行
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    /**
     * bean实例化之后，设置属性之前执行
     */
    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;

    /**
     * bean实例化之后，设置属性之前执行，这个时候属性值还未被设置，但是我们可以修改原本该设置进去的属性值 <br/>
     * 如果postProcessAfterInstantiation方法返回false，该方法可能不会被调用。可以在该方法内对属性值进行修改
     */
    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;

    /**
     * 提前暴露bean
     */
    default Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
