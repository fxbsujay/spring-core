package com.susu.spring.beans.factory.config;

import com.susu.spring.beans.BeansException;

/**
 * <p>Description: 后置处理器，是在Bean对象在实例化和依赖注入完毕后，在显示调用初始化方法的前后添加我们自己的逻辑 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface BeanPostProcessor {

    /**
     * 在bean执行初始化方法之前执行此方法
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在bean执行初始化方法之后执行此方法
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
