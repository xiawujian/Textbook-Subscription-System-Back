package com.example.textbooksubscriptionsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    private Integer userid;

    private Integer textbookId;

    private Integer textbookNum;

}
