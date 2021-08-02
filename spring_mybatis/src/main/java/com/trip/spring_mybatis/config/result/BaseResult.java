package com.trip.spring_mybatis.config.result;

import lombok.Data;

@Data
public class BaseResult<T> implements ResultCode {
    private Integer resultCode;
    private String resultMsg;
    private T result;

    @Override
    public Integer getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }

    public T getResult() {
        return result;
    }

    public BaseResult(ResultEnum resultEnum) {
        this.resultCode = resultEnum.code;
        this.resultMsg = resultEnum.msg;
    }
}
