package com.susu.spring.beans;

/**
 * <p>Description: Bean Factory</p>
 * <p>Bean 容器</p>
 *
 * @author sujay
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
     * <p>Description: Include beans or not</p>
     * <p>是否包含 bean</p
     *
     * @param name bean名称
     * @return true/false
     */
    boolean containsBean(String name);


}
