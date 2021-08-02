package com.trip.spring_mybatis.config.result;

public enum ResultEnum {
    SUCCESS(200, "success"),
    FAIL(1, "success"),
    ;
    public int code;
    public String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
