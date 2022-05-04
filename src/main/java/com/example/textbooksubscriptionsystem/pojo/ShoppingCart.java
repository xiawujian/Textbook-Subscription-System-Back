package com.example.textbooksubscriptionsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    private Integer userId;

    private String name;

    private Integer textbookId;

    private Integer textbookNum;

    private Double price;

}
