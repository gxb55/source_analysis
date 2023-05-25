package com.trip.atguigu.test.spi.impl;

import com.trip.atguigu.test.spi.SpiInterface;

/**
 * @author xbguo
 * @date 2023/5/17 18:51
 * @description TODO
 */
public class BSpiImpl implements SpiInterface {
    @Override
    public void sayHi(String msg) {
        System.out.println("B:"+msg);

    }
}
