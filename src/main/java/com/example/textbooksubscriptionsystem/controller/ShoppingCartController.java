package com.example.textbooksubscriptionsystem.controller;

import com.example.textbooksubscriptionsystem.pojo.ShoppingCart;
import com.example.textbooksubscriptionsystem.pojo.Textbook;
import com.example.textbooksubscriptionsystem.service.ShoppingCartService;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/shopping")
public class ShoppingCartController {
    @Resource
    ShoppingCartService shoppingCartService;

    @PostMapping("/add")
    public Boolean addShoppingCart(Integer userId,Integer textbookId,Double price,String name){
        ShoppingCart shoppingCart= new ShoppingCart();
        shoppingCart.setUserId(userId);
        shoppingCart.setTextbookId(textbookId);
        shoppingCart.setPrice(price);
        shoppingCart.setName(name);
        ShoppingCart oldShoppingCart=shoppingCartService.existShoppingCart(userId,textbookId);
        if(oldShoppingCart!=null){
            shoppingCart.setTextbookNum(oldShoppingCart.getTextbookNum()+1);
            shoppingCartService.updateShoppingCart(userId, textbookId, oldShoppingCart.getTextbookNum()+1);
            return true;
        }else{
            shoppingCart.setTextbookNum(1);
            return shoppingCartService.addShoppingCart(shoppingCart);
        }
    }
    @PostMapping("/show")
    public ArrayList<ShoppingCart> showShoppingCart(Integer userId) {
        return shoppingCartService.getShoppingCartByUserId(userId);
    }

    @PostMapping("/update")
    public Integer updateShoppingCart(Integer userId,Integer textbookId,Integer textbookNum) {
        return shoppingCartService.updateShoppingCart(userId, textbookId, textbookNum);
    }
    @PostMapping("/remove")
    public Boolean removeShoppingCart(Integer userId,Integer textbookId){
        return shoppingCartService.deleteShoppingCart(userId,textbookId);
    }
    @GetMapping("/search")
    public ArrayList<ShoppingCart> getShoppingCartByKey(@Length(max = 40, message = "搜索关键字长度要在0到40之间") String key) {
        return shoppingCartService.getShoppingCartByKey(key);
    }
}
