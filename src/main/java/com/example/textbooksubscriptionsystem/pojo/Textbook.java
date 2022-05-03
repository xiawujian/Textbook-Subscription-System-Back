package com.example.textbooksubscriptionsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Textbook {
    private Integer id;

    private String name;

//    private String description;

    private Double price;
}
