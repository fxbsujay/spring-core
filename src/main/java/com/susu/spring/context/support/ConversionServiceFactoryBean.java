package com.susu.spring.context.support;

import com.susu.spring.beans.factory.FactoryBean;
import com.susu.spring.beans.factory.InitializingBean;
import com.susu.spring.core.convert.ConversionService;
import com.susu.spring.core.convert.converter.Converter;
import com.susu.spring.core.convert.converter.ConverterFactory;
import com.susu.spring.core.convert.converter.ConverterRegistry;
import com.susu.spring.core.convert.converter.GenericConverter;
import com.susu.spring.core.convert.support.DefaultConversionService;
import com.susu.spring.core.convert.support.GenericConversionService;
import java.util.Set;

/**
 * <p>Description: 自定义类型转换器 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-28
 */
public class ConversionServiceFactoryBean implements FactoryBean<ConversionService>, InitializingBean {

	private Set<?> converters;

	private GenericConversionService conversionService;

	@Override
	public void afterPropertiesSet() throws Exception {
		conversionService = new DefaultConversionService();
		registerConverters(converters, conversionService);
	}

	private void registerConverters(Set<?> converters, ConverterRegistry registry) {
		if (converters != null) {
			for (Object converter : converters) {
				if (converter instanceof GenericConverter) {
					registry.addConverter((GenericConverter) converter);
				} else if (converter instanceof Converter<?, ?>) {
					registry.addConverter((Converter<?, ?>) converter);
				} else if (converter instanceof ConverterFactory<?, ?>) {
					registry.addConverterFactory((ConverterFactory<?, ?>) converter);
				} else {
					throw new IllegalArgumentException("Each converter object must implement one of the " +
							"Converter, ConverterFactory, or GenericConverter interfaces");
				}
			}
		}
	}

	@Override
	public ConversionService getObject() throws Exception {
		return conversionService;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public void setConverters(Set<?> converters) {
		this.converters = converters;
	}
}
