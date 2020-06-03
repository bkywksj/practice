package com.my.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
 *
 *@author Ye
 *@create 2020/5/29 18:17
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String bio;
    private String token;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    private String avatarUrl;

}
