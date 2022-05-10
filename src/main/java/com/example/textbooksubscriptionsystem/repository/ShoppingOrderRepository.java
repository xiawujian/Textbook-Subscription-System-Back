package com.example.textbooksubscriptionsystem.repository;
import com.example.textbooksubscriptionsystem.pojo.ShoppingOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface ShoppingOrderRepository {
    Boolean addShoppingOrder(ShoppingOrder ShoppingOrder);

    ArrayList<ShoppingOrder> getShoppingOrderByUserId(Integer userId);


    ShoppingOrder getShoppingOrderByUserIdAndTextbookId(Integer userId, Integer textbookId);

    Boolean deleteShoppingOrder(Integer userId, Integer textbookId);

    ArrayList<ShoppingOrder> getShoppingOrderByKey(String key);
}
