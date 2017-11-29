package com.zy.study.bootstudy.config;

import com.zy.study.bootstudy.TestSpring.Test0Bean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAspectJAutoProxy
@Configuration
@EnableAsync
@EnableScheduling
public class ApplicationContext {

    @Bean
    public Test0Bean test0Bean(){
        Test0Bean test0Bean = new Test0Bean();
        return test0Bean;
    }

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);//线程池维护线程的最少数量
        taskExecutor.setMaxPoolSize(10);//线程池维护线程的最大数量
        taskExecutor.setQueueCapacity(25);//线程池所使用的缓冲队列
        taskExecutor.initialize();
        return taskExecutor;
    }

}
