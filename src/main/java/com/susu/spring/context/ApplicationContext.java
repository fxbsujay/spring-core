package com.susu.spring.context;

import com.susu.spring.beans.factory.HierarchicalBeanFactory;
import com.susu.spring.beans.factory.ListableBeanFactory;
import com.susu.spring.core.io.ResourceLoader;

/**
 * <p>Description: 应用上下文</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
