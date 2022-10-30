package com.trip.study.nio.chat.client;

/**
 * @author xbguo
 * @createTime 2022年09月25日 21:34:00
 */
public class AClient {
    public static void main(String[] args) throws Exception {
        new ChatClient().startClient("zs");
    }
}
