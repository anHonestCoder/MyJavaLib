package org.simon.zhao.spring.batch.decider;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

/**
 * @author Zhaozhou
 * @date 2017/6/8
 */
public class MyDecider implements JobExecutionDecider {
	public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
		String reconType = jobExecution.getJobParameters().getString("reconType");
		if ("1".equals(reconType)) {
			return new FlowExecutionStatus("MENUAL");
		}else {
			return new FlowExecutionStatus("AUTO");
		}
	}
}