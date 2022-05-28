package com.trip.study.juc.sync;

import lombok.ToString;

/**
 * @author Administrator
 */
public class SyncAccount {
    public static void main(String[] args) {
        Account account = new Account();
        new Thread(() -> {
            account.setAccount(50, "张三");
        }).start();


        new Thread(() -> {
            System.out.println(account.getAccount());
        }).start();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        new Thread(() -> {
            System.out.println(account.getAccount());
        }).start();
    }
}

@ToString
class Account {
    private int num;
    private String name;

    public synchronized void setAccount(int num, String name) {
        setName(name);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        setNum(num);
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized Account getAccount() {
        return new Account(num, name);
    }

    public Account(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public Account() {

    }

}
