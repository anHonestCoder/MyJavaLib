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

public class Step1Listener implements StepExecutionListener {

	private static final Logger logger = LoggerFactory.getLogger(Step1Listener.class);


	@Override
	public void beforeStep(StepExecution stepExecution) {
		logger.info("{}#Step1 Listener#before Step", stepExecution.getJobExecution().getJobId());
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {

		logger.info("{}#Step1 Listener#afterStep", stepExecution.getJobExecution().getJobId());
		JobParameters jobParams = stepExecution.getJobParameters();

//		stepExecution.getExecutionContext().put("tempPayBankFilePath", "D:\\apps\\tmp\\input\\KJZF.txt");
//		stepExecution.getExecutionContext().putString("tempPayBankFilePath","D:\\apps\\tmp\\input\\KJZF.txt");
//		stepExecution.getJobExecution().getExecutionContext().putString("tempPayBankFilePath", "D:\\apps\\tmp\\input\\KJZF.txt");
		System.out.println(stepExecution.getExitStatus());

		return ExitStatus.COMPLETED;
	}
}
