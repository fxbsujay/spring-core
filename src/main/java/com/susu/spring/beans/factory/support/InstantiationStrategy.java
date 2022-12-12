package com.susu.spring.beans.factory.support;

import com.susu.spring.beans.BeansException;
import com.susu.spring.beans.factory.config.BeanDefinition;

/**
 * <p>Description: Bean 实例化策略 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-12
 */
public interface InstantiationStrategy {

    /**
     * Definition加入到注册表中 <br/>
     * 并由BeanFactoryPostProcessor的实现类处理后 <br/>
     * 需要由InstantiationStrategy负责实例化 <br/>
     * 实例化仅仅是调用构造函数，相当于new了一个对象而已，bean的具体的属性在此时并未赋值 <br/>
     */
    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
