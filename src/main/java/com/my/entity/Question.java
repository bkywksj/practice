package com.my.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
 *
 *@author Ye
 *@create 2020/5/30 11:10
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    @DateTimeFormat(pattern = "yyyy:MM:dd HH:mm:ss")
    private Date gmtCreat;
    @DateTimeFormat(pattern = "yyyy:MM:dd HH:mm:ss")
    private Date gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private Integer unlikeCount;

}
