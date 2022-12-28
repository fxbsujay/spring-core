package com.susu.spring.context.support;

import com.susu.spring.beans.BeansException;
import com.susu.spring.beans.factory.ConfigurableListableBeanFactory;
import com.susu.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.susu.spring.beans.factory.config.BeanPostProcessor;
import com.susu.spring.context.ApplicationEvent;
import com.susu.spring.context.ApplicationListener;
import com.susu.spring.context.ConfigurableApplicationContext;
import com.susu.spring.context.event.ApplicationEventMulticaster;
import com.susu.spring.context.event.ContextClosedEvent;
import com.susu.spring.context.event.ContextRefreshedEvent;
import com.susu.spring.context.event.SimpleApplicationEventMulticaster;
import com.susu.spring.core.convert.ConversionService;
import com.susu.spring.core.io.DefaultResourceLoader;
import java.util.Collection;
import java.util.Map;

/**
 * <p>Description: 抽象的应用上下文</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    /**
     * 事件多播器 Bean
     */
    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    /**
     * 类型转换器 Bean
     */
    public static final String CONVERSION_SERVICE_BEAN_NAME = "conversionService";

    /**
     * 事件多播器
     */
    private ApplicationEventMulticaster applicationEventMulticaster;

    /**
     *  <ul>
     *      <li>创建BeanFactory，并加载BeanDefinition</li>
     *      <li>添加ApplicationContextAwareProcessor，让继承自ApplicationContextAware的bean能感知bean</li>
     *      <li>在bean实例化之前，执行BeanFactoryPostProcessor</li>
     *      <li>BeanPostProcessor需要提前与其他bean实例化之前注册</li>
     *      <li>初始化事件发布者</li>
     *      <li>注册事件监听器</li>
     *  </ul>
     */
    @Override
    public void refresh() throws BeansException {

        // 创建BeanFactory，并加载BeanDefinition
        refreshBeanFactory();
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 添加ApplicationContextAwareProcessor，让继承自ApplicationContextAware的bean能感知bean
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        // 在bean实例化之前，执行BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);

        // BeanPostProcessor需要提前与其他bean实例化之前注册
        registerBeanPostProcessors(beanFactory);

        // 初始化事件发布者
        initApplicationEventMulticaster();

        // 注册事件监听器
        registerListeners();

        // 注册类型转换器和提前实例化单例bean
        finishBeanFactoryInitialization(beanFactory);

        // 发布容器刷新完成事件
        finishRefresh();
    }

    /**
     *<p>Description: 创建BeanFactory，并加载BeanDefinition </p>
     *
     * @throws BeansException Bean 异常
     */
    protected abstract void refreshBeanFactory() throws BeansException;

    /**
     * @return 获取 Bean 工厂
     */
    public abstract ConfigurableListableBeanFactory getBeanFactory();

    /**
     * 在 Bean 实例化之前，执行 BeanFactoryPostProcessor
     */
    protected void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    /**
     * 注册BeanPostProcessor
     */
    protected void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    /**
     * 初始化事件发布者
     */
    protected void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.addSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    /**
     * 注册事件监听器
     */
    protected void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener applicationListener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(applicationListener);
        }
    }

    /**
     * 注册类型转换器和提前实例化单例 Bean
     */
    protected void finishBeanFactoryInitialization(ConfigurableListableBeanFactory beanFactory) {
        if (beanFactory.containsBean(CONVERSION_SERVICE_BEAN_NAME)) {
            Object conversionService = beanFactory.getBean(CONVERSION_SERVICE_BEAN_NAME);
            if (conversionService instanceof ConversionService) {
                beanFactory.setConversionService((ConversionService) conversionService);
            }
        }
        beanFactory.preInstantiateSingletons();
    }

    /**
     * 发布容器刷新完成事件
     */
    protected void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }

    @Override
    public boolean containsBean(String name) {
        return getBeanFactory().containsBean(name);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(requiredType);
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    public void close() {
        doClose();
    }

    public void registerShutdownHook() {
        Thread shutdownHook = new Thread() {
            public void run() {
                doClose();
            }
        };
        Runtime.getRuntime().addShutdownHook(shutdownHook);
    }

    protected void doClose() {
        publishEvent(new ContextClosedEvent(this));
        destroyBeans();
    }

    /**
     * 销毁 Bean
     */
    protected void destroyBeans() {
        getBeanFactory().destroySingletons();
    }
}
