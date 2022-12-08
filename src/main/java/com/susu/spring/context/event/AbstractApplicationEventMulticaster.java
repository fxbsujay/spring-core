package com.susu.spring.context.event;

import com.susu.spring.beans.BeansException;
import com.susu.spring.beans.factory.BeanFactory;
import com.susu.spring.beans.factory.BeanFactoryAware;
import com.susu.spring.context.ApplicationEvent;
import com.susu.spring.context.ApplicationListener;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: 提供基本的监听器注册工具方法（注册和移除监听器）</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {

    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new HashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

}
