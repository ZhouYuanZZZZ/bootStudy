package com.zy.study.bootstudy.TestSpring;

import com.zy.study.bootstudy.async.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

public class Test0Bean {

    private static final Logger logger = LoggerFactory.getLogger(Test0Bean.class);

    @Resource
    private TestService testService;

    @PostConstruct
    public void init(){
        logger.info("init");
        for (int i = 0; i <10 ; i++) {
            testService.test();
        }
    }
}
