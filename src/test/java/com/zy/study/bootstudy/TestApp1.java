package com.zy.study.bootstudy;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.zy.study.bootstudy.services.Consumer1;
import com.zy.study.bootstudy.services.Consumer2;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TestApp1 {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.1.142");
        factory.setUsername("zy");
        factory.setPassword("zy");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("EX1", "fanout");

        String queueName1 = channel.queueDeclare().getQueue();
        channel.queueBind(queueName1, "EX1", "");

        String queueName2 = channel.queueDeclare().getQueue();
        channel.queueBind(queueName2, "EX1", "");

        channel.basicConsume(queueName1, true, new Consumer1(channel));
        channel.basicConsume(queueName2, true, new Consumer2(channel));
    }
}
