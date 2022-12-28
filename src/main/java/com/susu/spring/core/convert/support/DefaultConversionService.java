package com.susu.spring.core.convert.support;

import com.susu.spring.core.convert.converter.ConverterRegistry;

public class DefaultConversionService extends GenericConversionService {

	public DefaultConversionService() {
		addDefaultConverters(this);
	}

	public static void addDefaultConverters(ConverterRegistry converterRegistry) {
		converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
		//TODO 添加其他ConverterFactory
	}
}
