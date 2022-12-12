package com.susu.spring.beans.factory;

/**
 * <p>Description: 凡是继承该接口的类，在初始化bean的时候都会执行该方法</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-12
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;

}