package com.zy.study.bootstudy.services;

import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestRabbitMqService {

    private static final Logger logger = LoggerFactory.getLogger(TestRabbitMqService.class);

    @Resource
    private ConnectionFactory connectionFactory;

    
    public void test0(){

    }
}
