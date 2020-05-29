package com.my.dto;

import lombok.Data;

/*
 *github请求参数
 *@author Ye
 *@create 2020/5/29 15:18
 */
@Data
public class AccessToken {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;
}
