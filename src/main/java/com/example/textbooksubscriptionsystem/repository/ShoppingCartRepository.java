package com.example.textbooksubscriptionsystem.repository;

import com.example.textbooksubscriptionsystem.pojo.ShoppingCart;
import com.example.textbooksubscriptionsystem.pojo.Textbook;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface ShoppingCartRepository {

    Boolean addShoppingCart(ShoppingCart shoppingCart);

    ArrayList<ShoppingCart> getShoppingCartByUserId(Integer userId);

    Integer updateTextbookNum(Integer userId, Integer textbookId, Integer textbookNum);

    ShoppingCart getShoppingCartByUserIdAndTextbookId(Integer userId, Integer textbookId);

    Boolean deleteShoppingCart(Integer userId, Integer textbookId);

    ArrayList<ShoppingCart> getShoppingCartByKey(String key);
}
