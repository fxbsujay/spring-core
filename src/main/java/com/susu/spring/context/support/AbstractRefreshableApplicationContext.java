package com.susu.spring.context.support;

import com.susu.spring.beans.BeansException;
import com.susu.spring.beans.factory.ConfigurableListableBeanFactory;

/**
 * <p>Description: 主要实现容器的刷新创建</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */

public class AbstractRefreshableApplicationContext extends AbstractApplicationContext {


    @Override
    public void registerShutdownHook() {

    }

    @Override
    protected void refreshBeanFactory() throws BeansException {

    }

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() {
        return null;
    }
}
