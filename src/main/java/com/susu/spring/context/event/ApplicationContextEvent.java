package com.susu.spring.context.event;

import com.susu.spring.context.ApplicationContext;
import com.susu.spring.context.ApplicationEvent;

/**
 * <p>Description: 应用上下文事件 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public abstract class ApplicationContextEvent extends ApplicationEvent {

    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
