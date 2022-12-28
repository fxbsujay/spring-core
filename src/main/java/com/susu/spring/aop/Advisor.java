package com.susu.spring.aop;

import org.aopalliance.aop.Advice;

/**
 * <p>Description: 切点 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-28
 */
public interface Advisor {

    Advice getAdvice();
}
