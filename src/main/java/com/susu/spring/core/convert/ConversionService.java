package com.susu.spring.core.convert;

/**
 * <p>Description: 类型转换抽象接口 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface ConversionService {

    /**
     * 是否能够进行转换
     */
    boolean canConvert(Class<?> sourceType, Class<?> targetType);

    /**
     * 进行转换
     */
    <T> T convert(Object source, Class<T> targetType);
}
