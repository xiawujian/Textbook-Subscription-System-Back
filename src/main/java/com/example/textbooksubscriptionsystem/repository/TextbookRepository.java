package com.example.textbooksubscriptionsystem.repository;

import com.example.textbooksubscriptionsystem.pojo.Account;
import com.example.textbooksubscriptionsystem.pojo.Textbook;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TextbookRepository {

    Boolean addTextbook(Textbook textbook);

    Textbook getTextbookById(Integer id);

    Textbook getTextbookByName(String name);
}
