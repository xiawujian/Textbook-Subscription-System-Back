package com.example.textbooksubscriptionsystem.service;

import com.example.textbooksubscriptionsystem.pojo.ShoppingCart;
import com.example.textbooksubscriptionsystem.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class ShoppingCartService {
    @Resource
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart existShoppingCart(Integer userId, Integer textbookId) {
        return shoppingCartRepository.getShoppingCartByUserIdAndTextbookId(userId, textbookId);
    }

    public boolean addShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.addShoppingCart(shoppingCart);
    }

    public Integer updateShoppingCart(Integer userId,Integer textbookId,Integer textbookNum) {
        return shoppingCartRepository.updateTextbookNum(userId, textbookId, textbookNum);
    }

    public ArrayList<ShoppingCart> getShoppingCartByUserId(Integer userId) {
        return shoppingCartRepository.getShoppingCartByUserId(userId);
    }
    public boolean deleteShoppingCart(Integer userId,Integer textbookId){
        return shoppingCartRepository.deleteShoppingCart(userId,textbookId);
    }

    public ArrayList<ShoppingCart> getShoppingCartByKey(String key) {
        return shoppingCartRepository.getShoppingCartByKey(key);
    }
}
