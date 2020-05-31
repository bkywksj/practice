package com.my.entity;

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
    @DateTimeFormat(pattern = "yyyy:MM:dd HH:mm:ss")
    private Date gmtCreat;
    @DateTimeFormat(pattern = "yyyy:MM:dd HH:mm:ss")
    private Date gmtModified;
    private String avatarUrl;

}
