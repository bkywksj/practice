package com.my.controller;

import com.my.dto.QuestionDTO;

import com.my.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 *
 *@author Ye
 *@create 2020/6/1 8:14
 */
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;


    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Integer id,
                           Model model) {
        QuestionDTO questionDTO = questionService.getById(id);

        model.addAttribute("question", questionDTO);
        return "question";
    }

}
