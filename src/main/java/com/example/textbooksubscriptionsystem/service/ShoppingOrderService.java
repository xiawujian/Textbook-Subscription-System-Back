package com.example.textbooksubscriptionsystem.service;

import com.example.textbooksubscriptionsystem.pojo.ShoppingCart;
import com.example.textbooksubscriptionsystem.pojo.ShoppingOrder;
import com.example.textbooksubscriptionsystem.repository.ShoppingCartRepository;
import com.example.textbooksubscriptionsystem.repository.ShoppingOrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
@Service
public class ShoppingOrderService {
    @Resource
    private ShoppingOrderRepository shoppingOrderRepository;

    public ShoppingOrder existShoppingOrder(Integer userId, Integer textbookId) {
        return shoppingOrderRepository.getShoppingOrderByUserIdAndTextbookId(userId, textbookId);
    }


    public Boolean addShoppingOrder(ShoppingOrder shoppingOrder) {
        return shoppingOrderRepository.addShoppingOrder(shoppingOrder);
    }

    public ArrayList<ShoppingOrder> getShoppingOrderByUserId(Integer userId) {
        return shoppingOrderRepository.getShoppingOrderByUserId(userId);
    }

    public Boolean deleteShoppingOrder(Integer userId, Integer textbookId) {
        return shoppingOrderRepository.deleteShoppingOrder(userId,textbookId);
    }

    public ArrayList<ShoppingOrder> getShoppingOrderByKey(String key) {
        return shoppingOrderRepository.getShoppingOrderByKey(key);
    }
}
