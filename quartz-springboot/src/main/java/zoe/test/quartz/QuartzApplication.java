package zoe.test.quartz;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "zoe.test.quartz" })
public class QuartzApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(QuartzApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        return schedulerFactoryBean;
    }
    
}
