package com.zy.study.bootstudy.config;

import com.zy.study.bootstudy.TestSpring.Test0Bean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class applicationContext {

    @Bean
    public Test0Bean test0Bean(){
        Test0Bean test0Bean = new Test0Bean();
        return test0Bean;
    }
}
