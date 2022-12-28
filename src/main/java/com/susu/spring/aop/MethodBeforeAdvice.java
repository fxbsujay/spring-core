package com.susu.spring.aop;

import java.lang.reflect.Method;

/**
 * <p>Description: 方法前置通知 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-28
 */
public interface MethodBeforeAdvice extends BeforeAdvice  {

    void before(Method method, Object[] args, Object target) throws Throwable;
}
