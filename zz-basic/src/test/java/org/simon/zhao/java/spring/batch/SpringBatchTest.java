package org.simon.zhao.java.spring.batch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhaozhou
 * @date 2017/6/7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringBatchTest {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job ;


	@Test
	public void testRunJob() {
		Map<String, JobParameter> parameterMap = new HashMap<String, JobParameter>();

		parameterMap.put("tempPayBankFilePath", new JobParameter("D:\\apps\\tmp\\input\\KJZF.txt"));
		parameterMap.put("tempPayReconFilePath", new JobParameter("D:\\apps\\tmp\\output\\out.txt"));
		parameterMap.put("reconType", new JobParameter("1"));

		JobParameters jobParams = new JobParameters(parameterMap);
		JobExecution execution = null;
		try {
			execution = jobLauncher.run(job, jobParams);
		} catch (JobExecutionAlreadyRunningException e) {
			e.printStackTrace();
		} catch (JobRestartException e) {
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			e.printStackTrace();
		}
		System.out.println("Exit Status : " + execution.getExitStatus().getExitCode());
		System.out.println("Batch Status: " + execution.getStatus().getBatchStatus());
	}
}
