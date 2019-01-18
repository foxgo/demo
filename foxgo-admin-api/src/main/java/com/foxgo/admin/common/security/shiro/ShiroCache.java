package com.foxgo.admin.common.security.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author JohnnyLiu
 */
@SuppressWarnings("unchecked")
public class ShiroCache<K, V> implements Cache<K, V> {

    private static final Logger logger = LoggerFactory.getLogger(ShiroCache.class);

    //private static final String REDIS_SHIRO_CACHE = "shiro-cache:";
    private static final String REDIS_SHIRO_CACHE = "";
    private String cacheKey;
    private RedisTemplate<K, V> redisTemplate;

    @Value("${shiro.cache.expireTime}")
    private int expireTime = 60;

    @SuppressWarnings("rawtypes")
    public ShiroCache(String name, RedisTemplate client) {
        this.cacheKey = REDIS_SHIRO_CACHE + name + ":";
        this.redisTemplate = client;
    }

    @Override
    public V get(K key) throws CacheException {
        K newKey=getCacheKey(key);
        redisTemplate.boundValueOps(newKey).expire(expireTime, TimeUnit.MINUTES);
        return redisTemplate.boundValueOps(newKey).get();
    }

    @Override
    public V put(K key, V value) throws CacheException {
        V old = get(key);
        redisTemplate.boundValueOps(getCacheKey(key)).set(value);
        return old;
    }

    @Override
    public V remove(K key) throws CacheException {
        V old = get(key);
        redisTemplate.delete(getCacheKey(key));
        return old;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.delete(keys());
    }

    @Override
    public int size() {
        return keys().size();
    }

    @Override
    public Set<K> keys() {
        return redisTemplate.keys(getCacheKey("*"));
    }

    @Override
    public Collection<V> values() {
        Set<K> set = keys();
        List<V> list = new ArrayList<>();
        for (K s : set) {
            list.add(getValue(s));
        }
        return list;
    }


    private V getValue(K fullKey) throws CacheException {
        return redisTemplate.boundValueOps((K)fullKey).get();
    }

    private K getCacheKey(Object k) {
        return (K) (this.cacheKey + k);
    }

}
