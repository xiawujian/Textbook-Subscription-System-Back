package com.example.textbooksubscriptionsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginStatus {
    private boolean login;

    private Integer userId;

    private String username;
}
