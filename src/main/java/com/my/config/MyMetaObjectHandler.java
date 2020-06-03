package com.my.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
 *元数据处理器,,处理自动填充问题
 *@author Ye
 *@create 2020/5/24 10:56
 */
@Slf4j//日志
@Component//组件
public class MyMetaObjectHandler implements MetaObjectHandler {

//插入时自动填充
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入时间");
        //setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
    //更新时自动填充
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新时间");
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
