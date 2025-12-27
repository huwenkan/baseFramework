package org.vectorcontroller.baseframework.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", String.class, LocalDateTime.now().toString());
        this.strictInsertFill(metaObject, "updateTime", String.class, LocalDateTime.now().toString());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", String.class, LocalDateTime.now().toString());
    }
}
