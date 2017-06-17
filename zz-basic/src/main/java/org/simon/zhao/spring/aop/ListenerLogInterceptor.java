package org.simon.zhao.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepExecution;
import org.springframework.util.ClassUtils;

/**
 * @author Zhaozhou
 * @date 2017/6/17
 */
public class ListenerLogInterceptor implements MethodInterceptor {

	private static  final Logger logger = LoggerFactory.getLogger(ListenerLogInterceptor.class);

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] arguments = invocation.getArguments();
		StepExecution stepExecution = (StepExecution)arguments[0];

		String jobName = stepExecution.getJobExecution().getJobInstance().getJobName();
		String stepName = stepExecution.getStepName();
		String listenerName = ClassUtils.getShortName(invocation.getThis().getClass());
		String methodName = invocation.getMethod().getName();
		logger.info("------------{}#{}#{}#{}------------", jobName, stepName, listenerName, methodName);

		return invocation.proceed();
	}
}
