package com.susu.spring.context.event;

import com.susu.spring.context.ApplicationEvent;
import com.susu.spring.context.ApplicationListener;

/**
 * <p>Description: 事件多播器创建</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface ApplicationEventMulticaster {

    /**
     *  添加一个事件监听器
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * 删除一个事件监听器
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 多播事件
     */
    void multicastEvent(ApplicationEvent event);
}
