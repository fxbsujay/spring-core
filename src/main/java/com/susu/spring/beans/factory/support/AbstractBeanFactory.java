package com.susu.spring.beans.factory.support;

import com.susu.spring.beans.BeansException;
import com.susu.spring.beans.factory.FactoryBean;
import com.susu.spring.beans.factory.config.BeanDefinition;
import com.susu.spring.beans.factory.config.BeanPostProcessor;
import com.susu.spring.beans.factory.config.ConfigurableBeanFactory;
import com.susu.spring.core.convert.ConversionService;
import com.susu.spring.core.utils.StringValueResolver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: 基本抽象工厂，承上启下，定义架构 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    /**
     * Bean的后置处理器
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    /**
     * 工厂Bean实例
     */
    private final Map<String, Object> factoryBeanObjectCache = new HashMap<>();

    /**
     * 内嵌的值解析器，字符传解析器，比如，注解中的属性值
     */
    private final List<StringValueResolver> embeddedValueResolvers = new ArrayList<>();

    /**
     * 转化服务，用来代替属性编辑器
     */
    private ConversionService conversionService;

    /**
     * 是否包含 Bean
     */
    protected abstract boolean containsBeanDefinition(String beanName);

    /**
     * <p>Description: 创建Bean </p>
     *
     * @param beanName          名称
     * @param beanDefinition    Bean
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    /**
     * <p>Description: 获取Bean </p>
     *
     * @param beanName  Bean 名称
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    @Override
    public Object getBean(String name) throws BeansException {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            // 如果是FactoryBean，从FactoryBean#getObject中创建bean
            return getObjectForBeanInstance(sharedInstance, name);
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition);
        return getObjectForBeanInstance(bean, name);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return ((T) getBean(name));
    }

    @Override
    public boolean containsBean(String name) {
        return containsBeanDefinition(name);
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    @Override
    public ConversionService getConversionService() {
        return conversionService;
    }

    @Override
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public void addEmbeddedValueResolver(StringValueResolver valueResolver) {
        this.embeddedValueResolvers.add(valueResolver);
    }

    public String resolveEmbeddedValue(String value) {
        String result = value;
        for (StringValueResolver resolver : this.embeddedValueResolvers) {
            result = resolver.resolveStringValue(result);
        }
        return result;
    }

    /**
     * 如果是FactoryBean，从FactoryBean#getObject中创建bean
     */
    protected Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        Object object = beanInstance;
        if (beanInstance instanceof FactoryBean) {
            FactoryBean factoryBean = (FactoryBean) beanInstance;
            try {
                if (factoryBean.isSingleton()) {
                    object = this.factoryBeanObjectCache.get(beanName);
                    if (object == null) {
                        object = factoryBean.getObject();
                        this.factoryBeanObjectCache.put(beanName, object);
                    }
                } else {
                    object = factoryBean.getObject();
                }
            } catch (Exception ex) {
                throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", ex);
            }
        }

        return object;
    }
}
