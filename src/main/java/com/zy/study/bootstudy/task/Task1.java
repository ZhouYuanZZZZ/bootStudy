package com.zy.study.bootstudy.task;

import com.alibaba.fastjson.JSON;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task1 implements JavaDelegate {

    private static final Logger logger = LoggerFactory.getLogger(Task1.class);
    @Override
    public void execute(DelegateExecution execution) {
        logger.info("-----------------------------");
        JSON.toJSONString(execution);
        logger.info("-----------------------------");
    }
}
