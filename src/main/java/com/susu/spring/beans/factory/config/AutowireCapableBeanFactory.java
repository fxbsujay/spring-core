package com.susu.spring.beans.factory.config;

import com.susu.spring.beans.BeansException;
import com.susu.spring.beans.factory.BeanFactory;

/**
 * <p>Description: 对于想要拥有自动装配能力，并且想把这种能力暴露给外部应用的BeanFactory类需要实现此接口</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * <p>Description: 调用参数中指定Bean的 postProcessBeforeInitialization 方法 </p>
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
            throws BeansException;

    /**
     * <p>Description: 调用参数中指定Bean的 postProcessAfterInitialization 方法 </p>
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
            throws BeansException;
}
