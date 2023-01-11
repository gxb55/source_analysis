package com.trip.study.base.thread;

/**
 * @author xbguo
 * @createTime 2022年11月27日 09:48:00
 */
public class DieLock {
    public static void main(String[] args) {
        Person person = new Person("zs", 12);
        System.out.println(person);
        Thread t1 = new Thread(() -> {
            person.changeName("zs1");
        }, "T1");

        Thread t2 = new Thread(() -> {
            person.changeAge(18);
        }, "T2");

        t1.start();
        t2.start();
        while (true) {

        }
    }
}
