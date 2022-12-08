package com.susu.spring.beans.factory;

/**
 * <p>Description: Hierarchical Bean Factory</p>
 * <p>
 *     HierarchicalBeanFactory 接口是 BeanFactory 的扩展 <br/>
 *     所有要应用到有层级体系的容器类（有父 BeanFactory 的那种），都应该实现此接口 <br/>
 * </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface HierarchicalBeanFactory extends BeanFactory {
}
