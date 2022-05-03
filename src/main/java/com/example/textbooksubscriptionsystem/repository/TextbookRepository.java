package com.example.textbooksubscriptionsystem.repository;

import com.example.textbooksubscriptionsystem.pojo.Account;
import com.example.textbooksubscriptionsystem.pojo.Textbook;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.xml.soap.Text;
import java.util.ArrayList;

@Repository
@Mapper
public interface TextbookRepository {

    Boolean addTextbook(Textbook textbook);

    Textbook getTextbookById(Integer id);

    Textbook getTextbookByName(String name);

    ArrayList<Textbook> getTextbooksByKey(String key);

}
