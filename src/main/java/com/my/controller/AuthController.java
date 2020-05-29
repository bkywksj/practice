package com.my.controller;

import com.my.dto.AccessToken;
import com.my.dto.GithubUser;
import com.my.entity.User;
import com.my.mapper.UserMapper;
import com.my.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

/*
 *Github
 *@author Ye
 *@create 2020/5/29 15:08
 */
@Controller
public class AuthController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client_id}")
    private String client_id;
    @Value("${github.client_secret}")
    private String client_secret;
    @Value("${github.redirect_url}")
    private String redirect_url;

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) {

        AccessToken accessToken = new AccessToken();
        accessToken.setCode(code);
        accessToken.setClient_id(client_id);
        accessToken.setClient_secret(client_secret);
        accessToken.setRedirect_url(redirect_url);//注意这里有端口
        accessToken.setState(state);

        String token = githubProvider.getAccessToken(accessToken);
        GithubUser githubUser = githubProvider.getUser(token);
        System.out.println(githubUser);

        if (githubUser != null) {
            User user = new User();
            String uuid = UUID.randomUUID().toString();
            user.setToken(uuid);
            user.setName(githubUser.getName());
            user.setAccount_id(String.valueOf(githubUser.getId()));
            user.setGmtCreat(new Date());
            user.setGmtModified(new Date());
            userMapper.insert(user);
            response.addCookie(new Cookie("token", uuid));


            request.getSession().setAttribute("user", githubUser);
            //登录成功后,创建的uuid相当于session,存入数据库,下次直接调用就不用再次登录
        }
        return "redirect:/";

    }

}
