package com.foxgo.admin.config;

import com.foxgo.admin.entity.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigTest {


    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    @Test
    public void redisTemplate() {
        String key="test";
        Config config= new Config();
        config.setId(1);
        config.setItemKey("test22");
        config.setItemValue("tes223322");

        //config.setCreateTime(LocalDateTime.now());

        redisTemplate.opsForValue().set(key,config);
        Config redisConifig= (Config)redisTemplate.opsForValue().get(key);
        assertEquals(config.getId(),redisConifig.getId());

    }
}