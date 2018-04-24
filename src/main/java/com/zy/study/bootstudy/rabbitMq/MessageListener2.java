package com.zy.study.bootstudy.rabbitMq;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

public class MessageListener2 implements ChannelAwareMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(MessageListener2.class);
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        byte[] body = message.getBody();
        String s = new String(body, "UTF-8");
        logger.info(s);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消
    }
}
