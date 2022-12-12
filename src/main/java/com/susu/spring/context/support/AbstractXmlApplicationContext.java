package com.susu.spring.context.support;


import com.susu.spring.beans.BeansException;
import com.susu.spring.beans.factory.support.DefaultListableBeanFactory;
import com.susu.spring.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * <p>Description: 对applicationContext.xml的解析操作 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-12
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
