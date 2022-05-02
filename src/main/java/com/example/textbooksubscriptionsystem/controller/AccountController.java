package com.example.textbooksubscriptionsystem.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.example.textbooksubscriptionsystem.pojo.Account;
import com.example.textbooksubscriptionsystem.pojo.LoginStatus;
import com.example.textbooksubscriptionsystem.service.AccountService;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    AccountService accountService;

    @PostMapping("/register")
    public String register(@Pattern(regexp = "^\\w+$", message = "用户名只能含有数字、字母或下划线")
                           @Length(min = 6, max = 16, message = "用户名长度必须在6到16位之间")
                           @NotBlank(message = "用户名不能为空") String username,
                           @Pattern(regexp = "^[A-Za-z0-9]+$", message = "密码只能含有数字或字母")
                           @Length(min = 6, max = 16, message = "密码长度必须在6到16位之间")
                           @NotBlank(message = "密码不能为空") String password, Model model) throws Exception {
        if (accountService.existUsername(username)) {
            throw new Exception("该用户名已被注册");
        }
        if (accountService.userRegister(username, password)) {
            return "注册成功";
        } else {
            throw new Exception("注册失败");
        }
    }

    @PostMapping("/login")
    public Account login(@NotBlank(message = "用户名不能为空") String username, @NotBlank(message = "密码不能为空") String password) throws Exception {
        Account account = accountService.authenticate(username, password);
        if (account == null) {
            throw new Exception("用户名或密码错误");
        } else {
            return account;
        }
    }

    @PostMapping("/logout")
    public String logout() {
        StpUtil.logout();
        return "登出成功";
    }
    @PostMapping("/info")
    public Account info(Integer id)throws Exception{
        Account account=accountService.getUserInfo(id);

        if(account==null){
            throw new Exception("未知错误");
        }
        else{
            return account;
        }
    }
    @GetMapping("/loginStatus")
    public LoginStatus getLoginStatus() {
        LoginStatus loginStatus = new LoginStatus();
        if (!StpUtil.isLogin()) {
            loginStatus.setLogin(false);
        } else {
            loginStatus.setLogin(true);
            loginStatus.setUserid(StpUtil.getLoginIdAsInt());
            loginStatus.setUsername((String) StpUtil.getSession().getAttribute("username"));
        }
        return loginStatus;
    }
}
