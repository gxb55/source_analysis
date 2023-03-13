package com.train.ctrip.service.impl;

import com.train.ctrip.service.HelloServiceInterface;
import org.springframework.stereotype.Component;

/**
 * @author xbguo
 * @date 2023/3/1 17:24
 */
@Component
public class HelloServiceImpl implements HelloServiceInterface {
    @Override
    public String getRes(String o) {
        return o+" ";
    }
}
