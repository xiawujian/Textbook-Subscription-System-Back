package com.example.textbooksubscriptionsystem.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer id;

    private String username;

    @JsonIgnore
    private String password;
}
