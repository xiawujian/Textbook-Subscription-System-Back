package com.example.textbooksubscriptionsystem.service;

import com.example.textbooksubscriptionsystem.pojo.Account;
import com.example.textbooksubscriptionsystem.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class AccountService {

    @Value("${password-salt}")
    private String passwordSalt;
    @Resource
    private AccountRepository accountRepository;

    public boolean existAccount(Integer id) {
        return accountRepository.getAccountById(id) != null;
    }

    public boolean existUsername(String username) {
        return accountRepository.getAccountByUsername(username) != null;
    }

    public boolean userRegister(String username, String password,String email,Integer role) {
        Account userAccount = new Account();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmail(email);
        userAccount.setRole(role);
        return accountRepository.addAccount(userAccount);
    }


    public Account getUserInfo(Integer id) {
        return accountRepository.getAccountById(id);
    }

    public Account authenticate(String username, String password) {
        Account account = accountRepository.getAccountByUsername(username);
        if (account == null || account.getPassword().compareTo(password) != 0) {
            return null;
        } else {
            return account;
        }
    }


    public ArrayList<Account> getAccountByKey(String key) {
        return accountRepository.getAccountByKey(key);
    }
}
