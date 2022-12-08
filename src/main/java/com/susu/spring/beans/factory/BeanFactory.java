package com.susu.spring.beans.factory;

import com.susu.spring.beans.BeansException;

/**
 * <p>Description: Bean Factory</p>
 * <p>Bean 容器</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 1.0.0
 */
public interface BeanFactory {

    /**
     * <p>Description: GET Bean</p>
     * <p>获取Bean对象</p>
     *
     * @param name bean名称
     * @return Bean
     * @throws BeansException bean 为空异常
     */
    Object getBean(String name) throws BeansException;

    /**
     * <p>Description: 根据名称和类型查找bean</p>
     *
     * @param name          名称
     * @param requiredType  类型
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    /**
     * <p>Description: 根据类型查找bean</p>
     *
     * @param requiredType  类型
     */
    <T> T getBean(Class<T> requiredType) throws BeansException;

    /**
     * <p>Description: Include beans or not</p>
     * <p>是否包含 bean</p>
     *
     * @param name bean名称
     * @return true/false
     */
    boolean containsBean(String name);
}
