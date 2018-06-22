package com.zy.study.testSpring.app;


import com.zy.study.bootstudy.TestSpring.Test0Bean;
import com.zy.study.testSpring.bean.TestService0;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    private ApplicationContext context;

    @Before
    public void setup() {
        context = new AnnotationConfigApplicationContext(com.zy.study.testSpring.config.ApplicationContext.class);
    }

    @Test
    public void test0() {
        TestService0 bean = context.getBean(TestService0.class);
        System.out.println(bean);
    }
}
