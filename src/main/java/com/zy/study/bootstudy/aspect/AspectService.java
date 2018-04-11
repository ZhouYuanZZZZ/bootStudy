package com.zy.study.bootstudy.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AspectService {

    private static final Logger logger = LoggerFactory.getLogger(AspectService.class);

    public void testAop01(){
        logger.info("testAop01");
    }

    public String testAop02(){
        logger.info("testAop02");
        return "testAop02 return";
    }

    public String testAop03(){
        logger.info("testAop03");
        throw new RuntimeException("zzzz");
    }

    public String testAop04(String s){

        logger.info("testAop04");
        logger.info(s);

        return s;
    }
}
