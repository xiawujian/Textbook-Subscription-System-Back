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
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;


@RestController
@RequestMapping("/textbook")
public class TextbookController {
    @Resource
    TextbookService textbookService;

    @PostMapping("/addTextbook")
    public String addTextbook(@NotBlank(message = "教材名不能为空")String name,
                              @NotBlank(message = "价格不能为空")Double price,
                              Integer teacherId,
                              @NotBlank(message = "作者名不能为空")String authorName,
                              @NotBlank(message = "出版商不能为空")String publisher) throws Exception {
        if (textbookService.existName(name)) {
            throw new Exception("该书本已存在！");
        }
        if (textbookService.addTextbook(name, price,teacherId,authorName,publisher)) {
            return "添加成功";
        } else {
            throw new Exception("添加失败");
        }
    }

    @PostMapping("/info")
    public Textbook getTextbookInfo(Integer textbookId){
        return textbookService.getTextbooksById(textbookId);
    }
    @GetMapping("/search")
    public ArrayList<Textbook> getTextbookEntriesByKey(@Length(max = 40, message = "搜索关键字长度要在0到40之间") String key) {
        return textbookService.getTextbooksByKey(key);
    }
    @PostMapping("/my")
    public ArrayList<Textbook> getTextbookEntriesByTeacherId(Integer teacherId) {
        System.out.print(teacherId);
        return textbookService.getTextbookEntriesByTeacherId(teacherId);
    }
}
