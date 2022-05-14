package com.example.textbooksubscriptionsystem.repository;

import com.example.textbooksubscriptionsystem.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface AccountRepository {

    boolean addAccount(Account account);

    Account getAccountById(Integer id);

    Account getAccountByUsername(String username);

    Integer countAccountsById(Integer id);


    ArrayList<Account> getAccountByKey(String key);
}
