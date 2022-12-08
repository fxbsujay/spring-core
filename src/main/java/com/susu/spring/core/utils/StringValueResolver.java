package com.susu.spring.core.utils;

/**
 * <p>Description: 实现自定义注解中变量的解析 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface StringValueResolver {

    /**
     * <p>Description: 获取到在配置文件中配置的值 </p>
     * @param strVal ${xxx} 配置文件中属性值
     */
    String resolveStringValue(String strVal);
}
