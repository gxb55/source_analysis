package com.trip.study.juc.collector;

import java.util.HashSet;
import java.util.UUID;

public class HashSetUnSafe {
    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                hashSet.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(hashSet);
            }, String.valueOf(i)).start();
        }

    }
}
