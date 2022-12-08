package com.susu.spring.context;

import java.util.EventListener;

/**
 * <p>Description: 事件发布的监听器</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface ApplicationListener <E extends ApplicationEvent>extends EventListener {

    void onApplicationEvent(E event);
}
