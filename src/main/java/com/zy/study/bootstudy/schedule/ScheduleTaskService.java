package com.zy.study.bootstudy.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ScheduleTaskService {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTaskService.class);

    //@Scheduled(fixedRate = 1000L)
    public void test0(){
        logger.info(new Date().toString());
    }

    //@Scheduled(cron = "*/5 * * * * ?")
    public void test1() {
        logger.info(new Date().toString());
    }
}
