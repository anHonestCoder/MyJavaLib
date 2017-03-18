package org.simon.zhao.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by zhou01.zhao on 2016/12/22.
 */
public class QuartzDemo {
	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory schedFact = new StdSchedulerFactory();
		Scheduler scheduler = schedFact.getScheduler();
		scheduler.start();
		JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "groutp1")
				.build();

		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("myTrigger", "group1")
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(40)
				.repeatForever())
				.build();

		scheduler.scheduleJob(job, trigger);
	}
}
