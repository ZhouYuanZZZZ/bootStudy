package com.zy.study.bootstudy.services;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Consumer3 extends DefaultConsumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer3.class);
    /**
     * Constructs a new instance and records its association to the passed-in channel.
     *
     * @param channel the channel to which this consumer is attached
     */
    public Consumer3(Channel channel) {
        super(channel);
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        AMQP.BasicProperties replyProps = new AMQP.BasicProperties
                .Builder()
                .correlationId(properties.getCorrelationId())
                .build();

        String response = "";

        try {
            String message = new String(body,"UTF-8");
            System.out.println("Request:" + message);
            response = message.toUpperCase();

            this.getChannel().basicPublish( "", properties.getReplyTo(),
                    replyProps,
                    response.getBytes("UTF-8"));

            this.getChannel().basicAck(envelope.getDeliveryTag(), false);

        }
        catch (RuntimeException e){
            System.out.println(" [.] " + e.toString());
        }finally {

            this.getChannel().basicPublish( "", properties.getReplyTo(),
                    replyProps,
                    response.getBytes("UTF-8"));

            this.getChannel().basicAck(envelope.getDeliveryTag(), false);

            synchronized(this) {
                this.notify();
            }
        }
    }
}
