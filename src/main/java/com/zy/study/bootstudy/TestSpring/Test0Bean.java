package com.zy.study.bootstudy.TestSpring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class Test0Bean {

    private static final Logger logger = LoggerFactory.getLogger(Test0Bean.class);

    @PostConstruct
    public void init(){
        logger.info("init");
    }
}
