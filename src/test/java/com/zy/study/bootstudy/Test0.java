package com.zy.study.bootstudy;

import com.zy.study.bootstudy.async.TestService;
import com.zy.study.bootstudy.config.ApplicationContext;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
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

    @Test
    public void test2(){
        BigDecimal a1 = new BigDecimal(1.00);
        BigDecimal a2 = new BigDecimal(1);

        System.out.println(a1.equals(a2));
        System.out.println(a1.compareTo(a2));
    }

    @Test
    public void test3(){
        String hashAlgorithmName = "MD5";
        Object credentials = "123456";
        Object salt = ByteSource.Util.bytes("user");;
        int hashIterations = 666;

        Object result = new SimpleHash(hashAlgorithmName, credentials, null, hashIterations);
        System.out.println(result);
    }

}
