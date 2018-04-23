package com.zy.study.bootstudy.config;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.host}")
    private String host;

    @Value("${rabbitmq.port}")
    private String port;

    @Value("${rabbitmq.username}")
    private String name;

    @Value("${rabbitmq.password}")
    private String password;

    @Value("${rabbitmq.publisher-confirms}")
    private String publisherConfirms;

    //创建工厂连接
    @Bean
    public ConnectionFactory connectionFactory(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername(this.name);
        connectionFactory.setPassword(this.password);
        connectionFactory.setHost(this.host);
        connectionFactory.setPort(Integer.parseInt(this.port));
        return connectionFactory;
    }


}
