package com.example.textbooksubscriptionsystem.controller;

import com.example.textbooksubscriptionsystem.pojo.Textbook;
import com.example.textbooksubscriptionsystem.service.ShoppingCartService;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/shopping")
public class ShoppingCartController {
    @Resource
    ShoppingCartService shoppingCartService;

}
