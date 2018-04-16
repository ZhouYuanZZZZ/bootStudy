package com.zy.study.bootstudy.shrio;

import com.zy.study.bootstudy.utils.JedisPoolUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import java.util.*;

public class RedisCache<K,V> implements Cache<K,V> {

    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

    private JedisPool jedisPool = JedisPoolUtils.getJedisPoolInstance();

    private String keyPrefix = "shiro_redis_data:";

    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }


    @Override
    public Object get(Object key) throws CacheException {
        logger.info("get start");
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();
            resource.select(2);

            byte[] bs = SerializationUtils.serialize(key);

            byte[] value = resource.get(bs);

            Object deserialize = SerializationUtils.deserialize(value);

            return deserialize;
        }catch (Exception e){
            logger.error("get error",e);
            return null;
        }finally {
            JedisPoolUtils.release(resource);
            logger.info("get end");
        }

    }

    @Override
    public Object put(Object key, Object value) throws CacheException {
        logger.info("put start");
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();
            resource.select(2);

            resource.set(SerializationUtils.serialize(key), SerializationUtils.serialize(value));
            resource.expire(SerializationUtils.serialize(key), (int) (60*60*0.5));
            byte[] bs = resource.get(SerializationUtils.serialize(key));

            Object object = SerializationUtils.deserialize(bs);

            return object;
        }catch (Exception e){
            logger.error("put error",e);
            return null;
        }finally {
            JedisPoolUtils.release(resource);
            logger.info("put end");
        }
    }

    @Override
    public Object remove(Object key) throws CacheException {
        logger.info("remove start");
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();
            resource.select(2);

            byte[] bytes = resource.get(SerializationUtils.serialize(key));

            resource.del(SerializationUtils.serialize(key));

            return SerializationUtils.deserialize(bytes);
        }catch (Exception e){
            logger.error("remove error",e);
            return null;

        }finally {
            JedisPoolUtils.release(resource);
            logger.info("remove end");
        }
    }

    @Override
    public void clear() throws CacheException {
        logger.info("clear start");
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();
            resource.select(2);

            resource.flushDB();

        }catch (Exception e){
            logger.error("clear error",e);


        }finally {
            JedisPoolUtils.release(resource);
            logger.info("clear end");
        }
    }

    @Override
    public int size() {
        logger.info("size start");
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();
            resource.select(2);

            Long aLong = resource.dbSize();

            return aLong.intValue();
        }catch (Exception e){
            logger.error("clear error",e);
            return -1;
        }finally {
            JedisPoolUtils.release(resource);
            logger.info("size end");
        }
    }

    @Override
    public Set keys() {
        logger.info("keys start");
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();
            resource.select(2);

            Set<byte[]> keys = resource.keys("*".getBytes());

            Set<Object> set = new HashSet<Object>();

            for (byte[] bs : keys) {
                set.add(SerializationUtils.deserialize(bs));
            }

            return set;
        }catch (Exception e){
            logger.error("keys error",e);
            return null;
        }finally {
            JedisPoolUtils.release(resource);
            logger.info("keys end");
        }
    }

    @Override
    public Collection values() {
        logger.info("values start");
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();
            resource.select(2);

            Set keys = this.keys();

            List<Object> values = new ArrayList<Object>();

            for (Object object : keys) {
                byte[] bs = resource.get(SerializationUtils.serialize(object));
                values.add(SerializationUtils.deserialize(bs));
            }

            return values;
        }catch (Exception e){
            logger.error("values error",e);
            return null;
        }finally {
            JedisPoolUtils.release(resource);
            logger.info("values end");
        }
    }
}
