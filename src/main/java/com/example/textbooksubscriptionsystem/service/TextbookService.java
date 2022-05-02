package com.example.textbooksubscriptionsystem.service;

import com.example.textbooksubscriptionsystem.pojo.Account;
import com.example.textbooksubscriptionsystem.pojo.Textbook;
import com.example.textbooksubscriptionsystem.repository.AccountRepository;
import com.example.textbooksubscriptionsystem.repository.TextbookRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TextbookService {
    @Resource
    private TextbookRepository textbookRepository;

    public boolean existTextbook(Integer id) {
        return textbookRepository.getTextbookById(id) != null;
    }

    public boolean existName(String name) {
        return textbookRepository.getTextbookByName(name) != null;
    }

    public boolean addTextbook(String name,Integer price){
        Textbook textbook = new Textbook();
        textbook.setName(name);
        textbook.setPrice(price);
        return textbookRepository.addTextbook(textbook);
    }
}
