package com.example.demo.domain;

import lombok.Getter;

@Getter
public enum ExceptionEnum {
    USER_NOT_FOUND(1,"用户不存在"),
    PARAM_INVALID(2,"参数错误"),
    ;


    private final Integer code;
    private final String message;


    ExceptionEnum(Integer code, String desc) {
        this.code = code;
        this.message = desc;
    }
}
