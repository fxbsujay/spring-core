package com.susu.spring.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Inherited
@Documented
public @interface Qualifier {

	String value() default "";

}