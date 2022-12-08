package com.susu.spring.beans.factory;

/**
 * <p>Description: 允许在容器销毁该 Bean的时候获得一次回调 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
