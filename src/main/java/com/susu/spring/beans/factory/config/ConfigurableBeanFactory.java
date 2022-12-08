package com.susu.spring.beans.factory.config;

import com.susu.spring.beans.factory.HierarchicalBeanFactory;
import com.susu.spring.core.convert.ConversionService;
import com.susu.spring.core.utils.StringValueResolver;

/**
 * <p>Description: 配置Bean的统一Api </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    /**
     * <p>Description: 设置一个Bean后处理器 </p>
     *
     * @param beanPostProcessor 后置处理器
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁所有的单例类
     */
    void destroySingletons();

    /**
     * <p>Description: 增加一个嵌入式的StringValueResolver </p>
     *
     * @param valueResolver string值解析器
     */
    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    /**
     * <p>Description: 分解指定的嵌入式的值 </p>
     */
    String resolveEmbeddedValue(String value);

    /**
     * <p>Description: 设置、返回一个转换服务 </p>
     *
     * @param conversionService 类型转换器
     */
    void setConversionService(ConversionService conversionService);

    /**
     * @return 类型转化器
     */
    ConversionService getConversionService();

}
