package com.susu.spring.aop;

public interface PointcutAdvisor extends Advisor  {

    Pointcut getPointcut();
}
