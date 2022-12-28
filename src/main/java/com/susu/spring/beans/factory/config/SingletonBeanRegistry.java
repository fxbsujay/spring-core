package com.susu.spring.beans.factory.config;

/**
 * <p>Description: 单例注册表</p>
 * <pre>
 *     用于保存所以已经初始化完成的单例对象。我们使用的所有spring单例bean对象都会保存在此处
 * </pre>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface SingletonBeanRegistry {

    /**
     * <p>Description: 获取单例Bean</p>
     *
     * @param beanName bean对象名称
     */
    Object getSingleton(String beanName);

    /**
     * <p>Description: 添加单例Bean</p>
     *
     * @param beanName          bean对象名称
     * @param singletonObject   单例对象
     */
    void addSingleton(String beanName, Object singletonObject);

}
