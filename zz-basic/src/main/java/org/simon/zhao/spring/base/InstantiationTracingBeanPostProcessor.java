package org.simon.zhao.spring.base;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by zhou01.zhao on 2016/12/16.
 */
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean '" + beanName + "' created : " + bean.toString() + " postProcessBeforeInitialization");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean '" + beanName + "' created : " + bean.toString() + " postProcessAfterInitialization");
		return bean;
	}
}
