/**
 * 用一句话描述该文件做什么
 * 
 * @Title TimerSchedule.java
 * @Package com.chinac.cloudscale.timer.util
 * @Author 刘焕
 * @Date 2016年7月4日 上午10:52:55
 */
package zoe.test.quartz;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class ScheduleListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	public MyScheduler myScheduler;
	
	
	private static final Logger logger = LoggerFactory.getLogger(ScheduleListener.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {

			logger.info("定时任务监听器，开始定时任务的调度");
			myScheduler.scheduleJob();

		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

}
