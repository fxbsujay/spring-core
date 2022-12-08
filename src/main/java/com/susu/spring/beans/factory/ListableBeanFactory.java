package com.susu.spring.beans.factory;

import com.susu.spring.beans.BeansException;
import java.util.Map;

/**
 * <p>Description: Listable Bean Factory</p>
 * <p>
 *     允许预加载bean定义的 BeanFactory 可以实现此接口 <br/>
 *     其目的在于使实现它的 BeanFactory 能够枚举所有的Bean <br/>
 *     该接口不支持分层结构（对于继承了 {@link HierarchicalBeanFactory} 的 BeanFactory 来说）
 *
 * </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     *<p>Description: 获取所有 Bean 名称</p>
     *
     * @return  所有Bean的BeanName组成的String数组
     */
    String[] getBeanDefinitionNames();

    /**
     * <p>Description: 根据提供的类型返回匹配的 Bean 实例数组 只检测顶层 Bean，忽略嵌套 Bean</p>
     *
     * @param type  类型
     * @return      Bean示例数组
     * @param <T>   T
     * @throws BeansException Bean异常
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;
}
