package com.trip.atguigu.test.spi.impl;

import com.trip.atguigu.test.spi.SpiInterface;

/**
 * @author xbguo
 * @date 2023/5/17 18:50
 * @description TODO
 */
public class ASpiImpl implements SpiInterface {
    @Override
    public void sayHi(String msg) {
        System.out.println("A:"+msg);
    }
}
