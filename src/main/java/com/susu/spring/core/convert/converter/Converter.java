package com.susu.spring.core.convert.converter;

/**
 * <p>Description: 类型转换抽象接口 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-28
 */
public interface Converter<S, T> {

    /**
     * 类型转换
     */
    T convert(S source);
}
