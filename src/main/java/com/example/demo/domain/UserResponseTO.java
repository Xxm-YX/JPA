package com.example.demo.domain;

import lombok.Data;

@Data
public class UserResponseTO extends BaseTO {
    private UserTO data;     // 塞入UserTO
    private Boolean success; // 统一格式
    private String message;  // 统一格式
}