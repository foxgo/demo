package com.foxgo.admin.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;

public class JsonUtil {
    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    @Autowired
    private static RedisTemplate<String, Object> redisTemplate;

    public static String toJson(Object obj)
    {
        if(null==obj){
            return null;
        }
        /**
         * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
         * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
         * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
         * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
         * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
         * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
         */
        ObjectMapper mapper = new ObjectMapper();
        //mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //mapper.enableDefaultTyping();
        //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //Gson gson = new Gson();
        try {
            String json = mapper.writeValueAsString(obj);
            // gson.toJson(obj);
            // JSON.toJSONString(obj,SerializerFeature.WriteMapNullValue);
            return json;
        //} catch (Exception e) {
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return null;
    }


    public static <T> T fromJson(String json,Class<T> clazz)
    {
        if(null==json){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        //mapper.enableDefaultTyping();
        //Gson gson = new Gson();
        try {
            return mapper.readValue(json, clazz);
            //gson.fromJson(json, clazz);
            //return JSON.parseObject(json,clazz);
        } catch (IOException e) {
        //} catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return null;
    }

}
