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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/*
 *
 *@author Ye
 *@create 2020/5/30 9:32
 */
@Controller
public class PublishController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id") Integer id,
                       Model model) {
       QuestionDTO question= questionService.getById(id);
        model.addAttribute("title", question.getTitle());
        model.addAttribute("description", question.getDescription());
        model.addAttribute("tag", question.getTag());
        return "publish";
    }

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String publish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            @RequestParam("id") Integer id,
            HttpServletRequest request,
            Model model
    ) {
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);

        if (title == null || title == "") {
            model.addAttribute("error", "标题不能为空");
            return "/publish";
        }

        if (description == null || description == "") {
            model.addAttribute("error", "描述不能为空");
            return "/publish";
        }

        if (tag == null || tag == "") {
            model.addAttribute("error", "标签不能为空");
            return "/publish";
        }

        User user = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);

                        Question question = new Question();
                        question.setTitle(title);
                        question.setDescription(description);
                        question.setTag(tag);
                        question.setCreator(user.getAccountId());
//                        question.setGmtCreate(new Date());
//                        question.setGmtModified(new Date());
                        question.setId(id);

                        questionService.creatOrUpdate(question);


                        model.addAttribute("success", "恭喜你发布成功!你真是天才!");


                    }
                    break;
                }
            }
            if (user == null) {
                model.addAttribute("error", "你妹啊,你还没登录,转去右上角登录吧,不然揍你");

            }
        }

        return "publish";

        }

}
