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

    ShoppingCart getShoppingCartByUserId(Integer userId);

    Boolean updateTextbookNum(ShoppingCart shoppingCart);
}
