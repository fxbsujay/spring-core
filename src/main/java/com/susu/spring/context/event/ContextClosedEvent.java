package com.susu.spring.context.event;

/**
 * <p>Description: 容器关闭事件 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public class ContextClosedEvent extends ApplicationContextEvent{

    public ContextClosedEvent(Object source) {
        super(source);
    }
}
