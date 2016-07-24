/**
 * 用一句话描述该文件做什么
 * 
 * @Title TimerSchedule.java
 * @Package com.chinac.cloudscale.timer.util
 * @Author 刘焕
 * @Date 2016年7月4日 上午10:52:55
 */
package zoe.test.quartz;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class MyScheduler{
	@Autowired
	public SchedulerFactoryBean schedulerFactoryBean;
	
//	private static final Logger logger = LoggerFactory.getLogger(MyScheduler.class);
	

	/**
	 * 调度任务
	 * @Author
	 * @Date 2016年7月22日 下午3:57:15
	 * @throws SchedulerException
	 */
	public void scheduleJob() throws SchedulerException {

		Scheduler scheduler = schedulerFactoryBean.getScheduler();

		JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
				.withIdentity("job1", "group1").build();

		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
				.cronSchedule("0/20 * * * * ?");
		
		CronTrigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger1", "group1")
				.withSchedule(scheduleBuilder).build();
		
		scheduler.scheduleJob(jobDetail, trigger);
	}
	

}
