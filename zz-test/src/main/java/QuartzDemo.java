import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.simon.zhao.quartz.HelloJob;

/**
 * @author Zhaozhou
 * @date 2017/3/17
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
