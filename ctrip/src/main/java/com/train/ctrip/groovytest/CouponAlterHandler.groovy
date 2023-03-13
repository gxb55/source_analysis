package com.train.ctrip.groovytest

import com.train.ctrip.service.HelloServiceInterface

import javax.annotation.Resource
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CouponAlterHandler implements Handler {

    @Resource
    private HelloServiceInterface helloServiceInterface;
    @Override
    Object handle(Map<Object, Object> map) {
        if (Objects.nonNull(map) && map.containsKey("name")) {
            def pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            String get = map.get("name")
            def format = pattern.format(LocalDateTime.now())
            if(helloServiceInterface==null){
                return  "error "+ format;
            }
            return helloServiceInterface.getRes(get) + format;
        }
        return "error";
    }
}
