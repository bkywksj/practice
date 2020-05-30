package com.my.provider;

import com.alibaba.fastjson.JSON;
import com.my.dto.AccessToken;
import com.my.dto.GithubUser;

import com.my.utils.HttpClientUtils;
import org.springframework.stereotype.Component;



import java.util.Map;



/*
 *
 *@author Ye
 *@create 2020/5/29 15:16
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessToken accessToken) throws Exception {
        String url = "https://github.com/login/oauth/access_token";
        Map<String, String> map = HttpClientUtils.objectToMap(accessToken);
        String result = HttpClientUtils.get(url, map);
        System.out.println(result);
        if (result != null) {
            result = result.split("&")[0].split("=")[1];
            System.out.println("result"+result);
            return result;
        } else {
            return null;
        }
//        map.put("client_id", accessToken.getClient_id());
//        map.put("client_secret", accessToken.getClient_secret());
//        map.put("code", accessToken.getCode());
//        map.put("redirect_url", accessToken.getRedirect_url());
//        map.put("state", accessToken.getState());
//        String string = JSON.toJSONString(accessToken);
//        System.out.println(string);
//
//        String result = doGet(url, map);
//        System.out.println(result);
//        if (result != null) {
//            result = result.split("&")[0].split("=")[1];
//            System.out.println("result"+result);
//            return result;
//        } else {
//            return null;
//        }

    }


public GithubUser getUser(String token) throws Exception {
    String url = "https://api.github.com/user?access_token=" + token;
    String result = HttpClientUtils.get(url);
//    String result = doGet(url);
    if (result != null) {
        return JSON.parseObject(result, GithubUser.class);
    } else {
        return null;
    }
}


}
