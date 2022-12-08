package com.susu.spring.beans.factory;

/**
 * <p>Description: 工厂 Bean 实例</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 1.0.0
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    /**
     * 作用域 singleton / prototype
     */
    boolean isSingleton();
}
