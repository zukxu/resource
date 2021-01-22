package com.zukxu.resource.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <p>
 *
 * </p>
 *
 * @author zukxu
 * @date 2021/1/22 0022 17:00
 */
// @Component
public class SpringUtils implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringUtils.applicationContext = applicationContext;
	}

	public static <T> T getBean(String name, Class<T> tClass) {
		return applicationContext.getBean(name, tClass);
	}
}