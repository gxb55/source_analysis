package com.trip.atguigu.test.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author xbguo
 * @date 2023/5/17 18:53
 * @description TODO
 */
public class Test {
    public static void main(String[] args) {

        ServiceLoader<SpiInterface> serviceLoader =

                ServiceLoader.load(SpiInterface.class);

        Iterator<SpiInterface> iterator = serviceLoader.iterator();

        while (iterator.hasNext()) {

            SpiInterface log = iterator.next();

            log.sayHi("JDK SPI");

        }
    }
}
