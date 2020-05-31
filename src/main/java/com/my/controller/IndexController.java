package com.my.controller;


import com.my.dto.QuestionDTO;
import com.my.entity.Question;
import com.my.entity.User;
import com.my.mapper.QuestionMapper;
import com.my.mapper.UserMapper;
import com.my.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/*
 *
 *@author Ye
 *@create 2020/5/29 12:03
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model) {
            Cookie[] cookies = request.getCookies();
        System.out.println(cookies);
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }

        }

        List<QuestionDTO> questionList = questionService.list();
        model.addAttribute("questionList", questionList);









        return "index";
    }
}
