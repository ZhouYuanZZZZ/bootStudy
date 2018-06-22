package com.zy.study.testSpring.config;

import com.zy.study.testSpring.bean.TestService0;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(value = "com.zy.study.testSpring")
@Configuration
public class ApplicationContext {

    @Bean
    public TestService0 testService0(){
        TestService0 testService0 = new TestService0();
        return testService0;
    }

}
