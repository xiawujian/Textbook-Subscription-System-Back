package com.example.textbooksubscriptionsystem.controller;

import com.example.textbooksubscriptionsystem.pojo.ShoppingCart;
import com.example.textbooksubscriptionsystem.pojo.ShoppingOrder;
import com.example.textbooksubscriptionsystem.service.ShoppingOrderService;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/order")
public class ShoppingOrderController {
    @Resource
    ShoppingOrderService shoppingOrderService;

    @PostMapping("/add")
    public Boolean addShoppingOrder(Integer userId,Integer textbookId,Double price,String name){
        ShoppingOrder shoppingOrder= new ShoppingOrder();
        shoppingOrder.setUserId(userId);
        shoppingOrder.setTextbookId(textbookId);
        shoppingOrder.setPrice(price);
        return shoppingOrderService.addShoppingOrder(shoppingOrder);
    }
    @PostMapping("/show")
    public ArrayList<ShoppingOrder> showShoppingCart(Integer userId) {
        return shoppingOrderService.getShoppingOrderByUserId(userId);
    }

    @PostMapping("/remove")
    public Boolean removeShoppingOrder(Integer userId,Integer textbookId){
        return shoppingOrderService.deleteShoppingOrder(userId,textbookId);
    }
    @GetMapping("/search")
    public ArrayList<ShoppingOrder> getShoppingCartByKey(@Length(max = 40, message = "搜索关键字长度要在0到40之间") String key) {
        return shoppingOrderService.getShoppingOrderByKey(key);
    }
}
