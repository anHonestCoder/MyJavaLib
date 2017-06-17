package org.simon.zhao.spring.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

/**
 * @author Zhaozhou
 * @date 2017/6/13
 */
public class Step1Listener1 implements StepExecutionListener {

	private static final Logger logger = LoggerFactory.getLogger(Step1Listener1.class);

	@Override
	public void beforeStep(StepExecution stepExecution) {
		logger.info("Step1Listener1#beforeStep");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		logger.info("Step1Listener1#afterStep");

//		int i = 3 / 0;

		return ExitStatus.COMPLETED;
	}
}
