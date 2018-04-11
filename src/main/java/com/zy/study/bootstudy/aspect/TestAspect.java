package com.zy.study.bootstudy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

    private final Logger logger = LoggerFactory.getLogger(TestAspect.class);

    @Pointcut("execution(* helloWorld(..))")
    public void testPointCut(){}

    @Pointcut("execution(* testAop0*(..))")
    public void testPointCut1(){}

    @Before("testPointCut1()")
    public void before() {
        logger.info("before");
    }

    @AfterReturning(pointcut = "testPointCut1()", returning = "returnStr")
    public void afterReturning(String returnStr) {
        logger.info(returnStr);
    }

    @AfterThrowing(throwing="ex",pointcut = "testPointCut1()")
    public void exception(Exception ex){
        logger.error("exception error",ex);
    }

    @After("testPointCut1()")
    public void after(){
        logger.info("after");
    }

    @Around("testPointCut1()")
    public String around(ProceedingJoinPoint pjp) throws Throwable {
       logger.info("---------------------");
        String retVal = (String) pjp.proceed(new String[]{"ddddddddddddddddddddddddddd"});
        logger.info("retVal:{}",retVal);
        logger.info("---------------------");

        return retVal + "aopaopaop";
    }
}
