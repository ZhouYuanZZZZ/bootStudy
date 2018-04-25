package com.zy.study.bootstudy.config;


import com.zy.study.bootstudy.rabbitMq.MessageListener1;
import com.zy.study.bootstudy.rabbitMq.MessageListener2;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
    public CachingConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername(this.name);
        connectionFactory.setPassword(this.password);
        connectionFactory.setHost(this.host);
        connectionFactory.setPort(Integer.parseInt(this.port));
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    /**
     *
     FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     HeadersExchange ：通过添加属性key-value匹配
     DirectExchange:按照routingkey分发到指定队列
     TopicExchange:多关键字匹配
     */
    @Bean
    public DirectExchange defaultExchange() {
        DirectExchange bootEx1 = new DirectExchange("bootEx1",true,false);

        return bootEx1;
    }

    @Bean(name = "bootQ1")
    public Queue queue() {
        return new Queue("bootQ1", true); //队列持久
    }

    @Bean(name = "bootQ2")
    public Queue queue2() {
        return new Queue("bootQ2", true); //队列持久
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //必须是prototype类型
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        return template;
    }

    @Bean
    public Binding binding(@Qualifier("bootQ1") Queue queue, DirectExchange defaultExchange) {
        return BindingBuilder.bind(queue).to(defaultExchange).with("routingKey1");
    }

    @Bean
    public Binding binding2(@Qualifier("bootQ2") Queue queue, DirectExchange defaultExchange) {
        return BindingBuilder.bind(queue).to(defaultExchange).with("routingKey2");
    }

    @Bean
    public SimpleMessageListenerContainer messageContainer(@Qualifier("bootQ1") Queue queue1,CachingConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(queue1);
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new MessageListener1());
        return container;
    }

    @Bean
    public SimpleMessageListenerContainer messageContainer2(@Qualifier("bootQ1") Queue queue1,CachingConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(queue1);
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new MessageListener2());
        return container;
    }


}
