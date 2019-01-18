package com.foxgo.admin.common.util;

import com.foxgo.admin.entity.Config;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonUtilTest {

    @Test
    public void toJson() {
        Config config= new Config();
        config.setId(1);
        config.setItemKey("test22");
        config.setItemValue("tes223322");
        String json=JsonUtil.toJson(config);
        assertEquals((Integer)1,config.getId());
    }

    @Test
    public void fromJson() {
//        String json="{\"id\":\"20948f78-0019-498d-9696-fa56302bea74\",\"startTimestamp\":[\"java.util.Date\",1543988185541],\"stopTimestamp\":null,\"lastAccessTime\":[\"java.util.Date\",1543988185541],\"timeout\":1800000,\"expired\":false,\"host\":\"0:0:0:0:0:0:0:1\",\"attributes\":null,\"valid\":true,\"attributeKeys\":[\"java.util.Collections$EmptySet\",[]]}";
//
//        Session session= JsonUtil.fromJson(json,SimpleSession.class);
//
//       assertEquals("20948f78-0019-498d-9696-fa56302bea74",session.getId());

       String json= "{\"id\":1,\"itemKey\":\"test\",\"itemValue\":\"222\",\"remark\":\"3fdgsdfg\",\"createTime\": 1543561022934,}";

        Config session= JsonUtil.fromJson(json, Config.class);

       assertEquals((Integer)1,session.getId());
    }
}