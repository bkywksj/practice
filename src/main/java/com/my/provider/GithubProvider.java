package com.my.provider;

import com.alibaba.fastjson.JSON;
import com.my.dto.AccessToken;
import com.my.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/*
 *
 *@author Ye
 *@create 2020/5/29 15:16
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessToken accessToken) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessToken));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            System.out.println(string);//access_token=bbe067a10c4a019ec1f1e8a1de082541e81dca2f&scope=user&token_type=bearer
            String[] split = string.split("&");
            String token = split[0].split("=")[1];
            System.out.println(token);

            return token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String token) {
        OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token="+token)
                    .build();
        try (Response response = client.newCall(request).execute()) {
           String str=response.body().string();
            System.out.println(str);
            GithubUser githubUser = JSON.parseObject(str, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
