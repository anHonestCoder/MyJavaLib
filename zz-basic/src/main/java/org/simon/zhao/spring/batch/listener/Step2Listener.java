package org.simon.zhao.spring.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;

import java.util.Date;
import java.util.Map;

/**
 * @author Zhaozhou
 * @date 2017/5/24
 */
public class Step2Listener implements StepExecutionListener{

	private static final Logger logger = LoggerFactory.getLogger(Step2Listener.class);



	@Override
	public void beforeStep(StepExecution stepExecution) {
		logger.info("{}#Step2Listener#beforeStep", stepExecution.getJobExecution().getJobId());
		stepExecution.getExecutionContext().putString("tempPayBankFilePath","D:\\apps\\tmp\\input\\KJZF.txt");
		for (Map.Entry<String, Object> entry:stepExecution.getExecutionContext().entrySet()) {
			System.out.print(entry.getKey() + ":" + entry.getValue().toString() + "&");
		}
		System.out.println();

	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {


		logger.info("{}#Step2 Listener#afterStep", stepExecution.getJobExecution().getJobId());

		JobParameters jobParams = stepExecution.getJobParameters();
			return ExitStatus.COMPLETED;
		}
}
