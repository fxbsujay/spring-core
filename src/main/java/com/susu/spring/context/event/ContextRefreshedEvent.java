package com.susu.spring.context.event;

/**
 * <p>Description: 容器刷新完成事件 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public class ContextRefreshedEvent extends ApplicationContextEvent{
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
