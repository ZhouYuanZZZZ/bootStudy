package com.zy.study.bootstudy;

import com.zy.study.bootstudy.async.TestService;
import com.zy.study.bootstudy.config.ApplicationContext;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Test0 {

    @Test
    public void test0(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApplicationContext.class);
        TestService bean = annotationConfigApplicationContext.getBean(TestService.class);
        for (int i = 0; i <10 ; i++) {
            bean.test();
        }
    }

    @Test
    public void test1(){
        for (int i = 0; i <100 ; i++) {
            int number = (int) (Math.random() * (100 - 50 + 1)) + 25;
            System.out.println(number);
        }

    }
}
