package com.zy.study.bootstudy.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestService.class);

    //@Async
    public void test(){
        for (int i = 0; i < 100; i++) {
          logger.info(i+"");
        }
    }
}
