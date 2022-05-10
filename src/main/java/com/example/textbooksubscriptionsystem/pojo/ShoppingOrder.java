package com.example.textbooksubscriptionsystem.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingOrder {
    private Integer id;

    private Integer userId;

    private Integer textbookId;

    private Integer textbookNum;

    private String name;

    private Double price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    private Integer orderStatus;
}
