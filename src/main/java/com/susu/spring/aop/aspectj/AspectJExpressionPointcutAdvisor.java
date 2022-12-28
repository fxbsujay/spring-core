package com.susu.spring.aop.aspectj;

import com.susu.spring.aop.Pointcut;
import com.susu.spring.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * <p>Description: 以用于任何AspectJ切入点表达式的 Spring AOP Advisor </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-28
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut;

    private Advice advice;

    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (pointcut == null) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }
}
