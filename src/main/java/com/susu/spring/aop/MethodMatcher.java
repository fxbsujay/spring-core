package com.susu.spring.aop;

import java.lang.reflect.Method;
/**
 * <p>Description: 方法匹配 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-28
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
