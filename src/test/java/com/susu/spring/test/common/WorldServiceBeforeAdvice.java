package com.susu.spring.test.common;

import com.susu.spring.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

public class WorldServiceBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("BeforeAdvice: do something before the earth explodes");
	}
}
