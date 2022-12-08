package com.susu.spring.context;

import com.susu.spring.beans.BeansException;
import com.susu.spring.beans.factory.Aware;


/**
 * <p>Description: 获取应用上下文对象 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface ApplicationContextAware extends Aware {

    /**
     *  <p>Description: 获取应用上下文对象， </p>
     *  <p>
     *      某个Bean实现了ApplicationContextAware接口，Spring容器会在创建该Bean之后 <br/>
     *      自动调用该Bean的setApplicationContext（参数）方法 <br/>
     *      调用该方法时，会将容器本身ApplicationContext对象作为参数传递给该方法
     *  </p>
     * @param applicationContext  应用上下文
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
