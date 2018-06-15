package com.zy.study.bootstudy.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableImpl0 implements Callable<Integer> {

    private Logger logger = LoggerFactory.getLogger(CallableImpl0.class);
    @Override
    public Integer call() throws Exception {
        logger.info("Task Start");

        Thread.sleep(5000);
        Random random = new Random();
        int i = random.nextInt();

        logger.info("Task end");
        return i;
    }
}
