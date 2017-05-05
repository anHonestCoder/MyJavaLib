package org.simon.zhao.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhou01.zhao on 2016/12/22.
 */
public class HelloJob implements Job {
	Logger logger = LoggerFactory.getLogger(HelloJob.class);
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
//		logger.info("Hello Quartz!");
		System.out.println("Hello Quartz");
	}
}
