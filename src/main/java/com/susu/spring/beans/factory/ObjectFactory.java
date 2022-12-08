package com.susu.spring.beans.factory;

import com.susu.spring.beans.BeansException;

/**
 * <p>Description: 一个对象工厂 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface ObjectFactory<T> {

    T getObject() throws BeansException;
}
