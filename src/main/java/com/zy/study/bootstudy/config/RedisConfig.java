package com.zy.study.bootstudy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

@Configuration
@Component
public class RedisConfig {

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private String port;

    @Bean
    public JedisPool jedisPool(){
        JedisPool jedisPool = new JedisPool(host,Integer.parseInt(port));
        return jedisPool;
    }
}
