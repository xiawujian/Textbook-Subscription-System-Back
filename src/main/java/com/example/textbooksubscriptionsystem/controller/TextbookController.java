package com.example.textbooksubscriptionsystem.controller;


import com.example.textbooksubscriptionsystem.service.TextbookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


@RestController
@RequestMapping("/textbook")
public class TextbookController {
    @Resource
    TextbookService textbookService;

    @PostMapping("/addTextbook")
    public String addTextbook(String name,Integer price) throws Exception {
        if (textbookService.existName(name)) {
            throw new Exception("该书本已存在！");
        }
        if (textbookService.addTextbook(name, price)) {
            return "添加成功";
        } else {
            throw new Exception("添加失败");
        }
    }
}
