package com.susu.spring.aop;

/**
 * <p>Description: 类匹配 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-28
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
