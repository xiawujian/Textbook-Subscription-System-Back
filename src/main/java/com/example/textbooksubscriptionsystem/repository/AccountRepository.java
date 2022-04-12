package com.example.textbooksubscriptionsystem.repository;

import com.example.textbooksubscriptionsystem.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AccountRepository {

    boolean addAccount(Account account);

    Account getAccountById(Integer id);

    Account getAccountByUsername(String username);

}
