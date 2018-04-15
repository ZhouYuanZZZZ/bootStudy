package com.zy.study.bootstudy.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


public class JedisPoolUtils{

    private static final Logger logger = LoggerFactory.getLogger(JedisPoolUtils.class);


    private static volatile JedisPool jedisPool = null;//被volatile修饰的变量不会被本地线程缓存，对该变量的读写都是直接操作共享内存。

    public static JedisPool getJedisPoolInstance() {
        try {
            if (null == jedisPool) {
                synchronized (JedisPoolUtils.class) {
                    if (null == jedisPool) {
                        JedisPoolConfig poolConfig = new JedisPoolConfig();
                        poolConfig.setMaxIdle(32);
                        jedisPool = new JedisPool(poolConfig, PropertiesFactory.getAppProperties().getProperty("redis.host"),Integer.parseInt(PropertiesFactory.getAppProperties().getProperty("redis.port")));
                    }
                }
            }
        }catch (Exception e){
            logger.error("getJedisPoolInstance error",e);
        }

        if(jedisPool == null){
            logger.error("getJedisPoolInstance null");
        }

        return jedisPool;
    }

    public static void release(Jedis jedis) {
        if (null != jedis) {
            jedis.close();
        }
    }

}
