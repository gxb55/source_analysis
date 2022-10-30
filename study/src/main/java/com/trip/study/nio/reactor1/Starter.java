package com.trip.study.nio.reactor1;

import java.io.IOException;

/**
 * @author xbguo
 * @createTime 2022年09月14日 22:11:00
 */
public class Starter {
    public static void main(String[] args) throws IOException {
        new Thread(new Reactor(2333)).start();
    }
}
