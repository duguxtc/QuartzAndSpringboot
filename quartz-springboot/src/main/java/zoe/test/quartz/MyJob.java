/**
 * 用一句话描述该文件做什么
 * 
 * @Title IpJob.java
 * @Package com.chinac.cloudscale.timer.util
 * @Author 刘焕
 * @Date 2016年7月4日 下午2:45:01
 */
package zoe.test.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: 
 * @Author 刘焕
 * @Date 2016年7月4日 下午2:45:01
 */


public class MyJob implements Job {

    public static int triggerNum=1;
    private static final Logger logger = LoggerFactory.getLogger(MyJob.class);

    
    
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	
    	logger.info(" This is my "+(triggerNum++)+" job !");
        
    }

    

}
