package com.my.dto;

import com.my.entity.User;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
 *
 *@author Ye
 *@create 2020/5/30 20:31
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    @DateTimeFormat(pattern = "yyyy:MM:dd HH:mm:ss")
    private Date gmtCreate;
    @DateTimeFormat(pattern = "yyyy:MM:dd HH:mm:ss")
    private Date gmtModified;
    private String creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private Integer unlikeCount;
    private User user;

}
