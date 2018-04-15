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
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();

            byte[] bs = SerializationUtils.serialize(key);

            byte[] value = resource.get(bs);

            if(value == null){
                return null;
            }
            return SerializationUtils.deserialize(value);
        }catch (Exception e){
            logger.error("get error",e);
            return null;
        }finally {
            JedisPoolUtils.release(resource);
        }

    }

    @Override
    public Object put(Object key, Object value) throws CacheException {
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();

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
        }
    }

    @Override
    public Object remove(Object key) throws CacheException {
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();

            byte[] bytes = resource.get(SerializationUtils.serialize(key));

            resource.del(SerializationUtils.serialize(key));

            return SerializationUtils.deserialize(bytes);
        }catch (Exception e){
            logger.error("remove error",e);
            return null;

        }finally {
            JedisPoolUtils.release(resource);
        }
    }

    @Override
    public void clear() throws CacheException {
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();

            resource.flushDB();

        }catch (Exception e){
            logger.error("clear error",e);


        }finally {
            JedisPoolUtils.release(resource);
        }
    }

    @Override
    public int size() {
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();

            Long aLong = resource.dbSize();

            return aLong.intValue();
        }catch (Exception e){
            logger.error("clear error",e);
            return -1;
        }finally {
            JedisPoolUtils.release(resource);
        }
    }

    @Override
    public Set keys() {
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();

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
        }
    }

    @Override
    public Collection values() {
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();

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
        }
    }
}
