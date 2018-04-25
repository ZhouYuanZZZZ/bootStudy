package com.zy.study.bootstudy;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.zy.study.bootstudy.services.Consumer3;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TestApp2 {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.1.142");
        factory.setUsername("zy");
        factory.setPassword("zy");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("RPC", false, false, false, null);
        channel.basicQos(1);

        Consumer3 consumer3 = new Consumer3(channel);
        channel.basicConsume("RPC", false,consumer3 );
        System.out.println(" [x] Awaiting RPC requests");

        while (true) {
            synchronized(consumer3) {
                try {
                    consumer3.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
