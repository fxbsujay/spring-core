package com.susu.spring.beans.factory;

import com.susu.spring.beans.BeansException;

/**
 * <p>Description: 实现该接口，能感知所属BeanFactory</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
