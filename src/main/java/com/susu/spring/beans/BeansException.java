package com.susu.spring.beans;

/**
 * <p>Description: Bean Exception</p>
 * <p>Bean 空异常</p>
 *
 * @author sujay
 * @version 1.0.0
 * @since 1.0.0
 */
public class BeansException extends RuntimeException {

	public BeansException(String msg) {
		super(msg);
	}

	public BeansException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
