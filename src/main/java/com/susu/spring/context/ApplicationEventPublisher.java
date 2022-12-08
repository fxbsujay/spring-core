package com.susu.spring.context;

/**
 * <p>Description: 事件的发布者，把某个事件告诉的所有与这个事件相关的监听器</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface ApplicationEventPublisher {

    /**
     * <p>Description: 发布事件，这个方法会通知的所有与事件相匹配的监听</p>
     *
     * @param event 事件
     */
    void publishEvent(ApplicationEvent event);
}
