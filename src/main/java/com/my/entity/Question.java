package com.my.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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

    @TableField(fill = FieldFill.INSERT)
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;

    private String creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private Integer unlikeCount;

}
