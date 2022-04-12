package com.example.textbooksubscriptionsystem.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.example.textbooksubscriptionsystem.exception.UnauthorizedException;
import com.example.textbooksubscriptionsystem.pojo.Account;
import com.example.textbooksubscriptionsystem.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    AccountService accountService;

    @PostMapping("/register")
    public String register(String username, String password, Model model) {
        if(accountService.userRegister(username, password)){
            return "注册成功";
        }else{
            throw new UnauthorizedException("注册失败");
        }
    }
    @PostMapping("/login")
    public Account login(@NotBlank(message = "用户名不能为空") String username, @NotBlank(message = "密码不能为空") String password) {
        Account account=accountService.authenticate(username, password);
        if(account==null) {
            throw new UnauthorizedException("用户名或密码错误");
        }else{
            return account;
        }

    }
}
