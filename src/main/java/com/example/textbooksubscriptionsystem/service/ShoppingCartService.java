package com.example.textbooksubscriptionsystem.service;

import com.example.textbooksubscriptionsystem.pojo.ShoppingCart;
import com.example.textbooksubscriptionsystem.pojo.Textbook;
import com.example.textbooksubscriptionsystem.repository.ShoppingCartRepository;
import com.example.textbooksubscriptionsystem.repository.TextbookRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShoppingCartService {
    @Resource
    private ShoppingCartRepository shoppingCartRepository;

    public boolean addShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.addShoppingCart(shoppingCart);
    }

    public boolean updateShoppingCart(ShoppingCart shoppingCart){
        return shoppingCartRepository.updateTextbookNum(shoppingCart);
    }
}
