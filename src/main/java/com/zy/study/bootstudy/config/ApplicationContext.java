package com.zy.study.bootstudy.config;

import com.zy.study.bootstudy.TestSpring.Test0Bean;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAspectJAutoProxy
@Configuration
@EnableAsync
@EnableScheduling
@Import(value = {MVCConfig.class,Odm.class,AsyConfigurer.class})
public class ApplicationContext {

    @Bean
    public Test0Bean test0Bean(){
        Test0Bean test0Bean = new Test0Bean();
        return test0Bean;
    }


}
