package com.foxgo.admin.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = getFieldValByName("createTime", metaObject);
        if (createTime == null)
            setFieldValByName("createTime", LocalDateTime.now(), metaObject);

        Object modifiedTime = getFieldValByName("modifiedTime", metaObject);
        if (modifiedTime == null)
            setFieldValByName("modifiedTime", LocalDateTime.now(), metaObject);

        Object deletedFlag = getFieldValByName("deletedFlag", metaObject);
        if (deletedFlag == null)
            setFieldValByName("deletedFlag", false, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object modifiedTime = getFieldValByName("modifiedTime", metaObject);
        if (modifiedTime == null)
            setFieldValByName("modifiedTime", LocalDateTime.now(), metaObject);
    }
}
