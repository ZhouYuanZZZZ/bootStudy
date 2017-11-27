package com.zy.study.bootstudy.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

    private final Logger logger = LoggerFactory.getLogger(TestAspect.class);

    @Pointcut("execution(* helloWorld(..))")
    public void testPointCut(){}

    @Before("testPointCut()")
    public void before() {
        logger.info("before");
    }

    @AfterReturning(pointcut = "testPointCut()", returning = "returnStr")
    public void afterReturning(String returnStr) {
        logger.info(returnStr);
    }
}
