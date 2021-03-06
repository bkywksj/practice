package com.my.controller;

import com.my.dto.PageDTO;
import com.my.entity.Question;
import com.my.entity.User;
import com.my.mapper.UserMapper;
import com.my.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;

/*
 *
 *@author Ye
 *@create 2020/5/31 17:43
 */
@Controller
public class ProfileController {
//    @Autowired
//    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "action") String action,
                          Model model,
                          @RequestParam(name="page",defaultValue = "1") Integer page,
                          @RequestParam(name = "size",defaultValue = "5") Integer size) {

        User user = (User) request.getSession().getAttribute("user");
        System.out.println("user"+user);
//        User user = null;
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("token")) {
//                    String token = cookie.getValue();
//                    user = userMapper.findByToken(token);
//                    if (user != null) {
//                        request.getSession().setAttribute("user", user);
//                    }
//                    break;
//                }
//            }
//
//        }
        if (user == null) {
            return "redirect:/";
        }



        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");

        } else if ("replies".equals(action)) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }

        PageDTO pageDTO = questionService.listById(user.getAccountId(), page, size);

        model.addAttribute("pageDTO", pageDTO);

        return "profile";
    }

}
