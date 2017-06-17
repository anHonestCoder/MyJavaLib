package org.simon.zhao.spring.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

import java.util.Date;

/**
 * @author Zhaozhou
 * @date 2017/5/24
 */
public class Step3Listener implements StepExecutionListener {

	private static final Logger logger = LoggerFactory.getLogger(Step3Listener.class);

	@Override
	public void beforeStep(StepExecution stepExecution) {
		logger.info("{}#Step3 Listener#beforeStep", stepExecution.getJobExecution().getJobId());
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		JobParameters jobParams = stepExecution.getJobParameters();


		logger.info("{}#{}#Listener#afterStep", stepExecution.getJobExecution().getJobInstance().getJobName(), stepExecution.getStepName());
		return ExitStatus.COMPLETED;
	}
}
