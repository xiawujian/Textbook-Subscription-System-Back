package com.example.textbooksubscriptionsystem.service;

import com.example.textbooksubscriptionsystem.pojo.Textbook;
import com.example.textbooksubscriptionsystem.repository.TextbookRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;


@Service
public class TextbookService {
    @Resource
    private TextbookRepository textbookRepository;

    public boolean existTextbook(Integer id) {
        return textbookRepository.getTextbookById(id) != null;
    }

    public ArrayList<Textbook> getTextbooksByKey(String key) {
        return textbookRepository.getTextbooksByKey(key);
    }

    public boolean existName(String name) {
        return textbookRepository.getTextbookByName(name) != null;
    }

    public boolean addTextbook(String name, Double price,Integer teacherId,String authorName,String publisher) {
        Textbook textbook = new Textbook();
        textbook.setName(name);
        textbook.setPrice(price);
        textbook.setTeacherId(teacherId);
        textbook.setAuthorName(authorName);
        textbook.setPublisher(publisher);
        return textbookRepository.addTextbook(textbook);
    }

    public ArrayList<Textbook> getTextbookEntriesByTeacherId(Integer teacherId) {
        return textbookRepository.getTextbookEntriesByTeacherId(teacherId);
    }

    public Textbook getTextbooksById(Integer textbookId) {
        return textbookRepository.getTextbookById(textbookId);
    }
}
