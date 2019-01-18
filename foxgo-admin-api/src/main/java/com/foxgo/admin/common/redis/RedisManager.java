package com.foxgo.admin.common.redis;


import com.foxgo.admin.common.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;


import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisManager {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource(name = "ValueOperations")
    private ValueOperations<String, String> valueOperations;
    @Resource(name = "HashOperations")
    private HashOperations<String, String, Object> hashOperations;
    @Resource(name = "ListOperations")
    private ListOperations<String, Object> listOperations;
    @Resource(name = "SetOperations")
    private SetOperations<String, Object> setOperations;
    @Resource(name = "ZSetOperations")
    private ZSetOperations<String, Object> zSetOperations;
    /**
     * 默认过期时长，单位：秒
     */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;
    /**
     * 不设置过期时长
     */
    public final static long NOT_EXPIRE = -1;


    public void set(String key, Object value, long expire) {
        valueOperations.set(key, JsonUtil.toJson(value));
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    public void set(String key, Object value) {
        set(key, value, DEFAULT_EXPIRE);
    }

    public <T> T get(String key, Class<T> clazz, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : JsonUtil.fromJson(value, clazz);
    }

    public <T> T get(String key, Class<T> clazz) {
        return get(key, clazz, NOT_EXPIRE);
    }

    public String get(String key, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public String get(String key) {
        return get(key, NOT_EXPIRE);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void delete(Collection keys) {
        redisTemplate.delete(keys);
    }

    public void flushDb() {
        redisConnectionFactory.getConnection().flushDb();
    }

    public long dbSize() {
        return redisConnectionFactory.getConnection().dbSize();
    }

    public Set<byte[]> keys(String pattern) {
        //return redisTemplate.keys(pattern.getBytes());
        return redisConnectionFactory.getConnection().keys(pattern.getBytes());
    }


}
