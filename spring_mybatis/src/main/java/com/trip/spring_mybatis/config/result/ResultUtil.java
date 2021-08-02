package com.trip.spring_mybatis.config.result;

/**
 * @author Administrator
 */
public class ResultUtil {
    public static BaseResult buildResult(ResultEnum resultEnum, Object result) {
        BaseResult baseResult = new BaseResult(resultEnum);
        baseResult.setResult(result);
        return baseResult;
    }
}

