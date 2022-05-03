package com.example.textbooksubscriptionsystem.controller;


import com.example.textbooksubscriptionsystem.pojo.Textbook;
import com.example.textbooksubscriptionsystem.service.TextbookService;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.ArrayList;


@RestController
@RequestMapping("/textbook")
public class TextbookController {
    @Resource
    TextbookService textbookService;

    @PostMapping("/addTextbook")
    public String addTextbook(String name, Double price) throws Exception {
        if (textbookService.existName(name)) {
            throw new Exception("该书本已存在！");
        }
        if (textbookService.addTextbook(name, price)) {
            return "添加成功";
        } else {
            throw new Exception("添加失败");
        }
    }

    @GetMapping("/search")
    public ArrayList<Textbook> getTextbookEntriesByKey(@Length(max = 40, message = "搜索关键字长度要在0到40之间") String key) {
        return textbookService.getTextbooksByKey(key);
    }
}
