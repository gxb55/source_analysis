package com.trip.study.juc.threadlocal;

/**
 * @author xbguo
 * @createTime 2023年11月26日 21:51:00
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
       /* MovieTicket movieTicket =new MovieTicket();
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                for (int j = 0; j < 20; j++) {
                    movieTicket.saleTicket();
                }
            },i+"").start();
        }*/
        House house = new House();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 30; j++) {
                    house.saleHouse();
                }
                house.threadLocal.remove();
            }, i + "").start();
        }
    }
}

class House {
      ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 20);

    public void saleHouse() {
        Integer i = threadLocal.get();
        if (i > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了第" + i + "套房子");
            i--;
            threadLocal.set(i);
        } else {
            System.out.println("没票了");
        }
    }
}

class MovieTicket {
    private Integer total = 50;

    public synchronized void saleTicket() {
        if (total > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了第" + total-- + "张票");
        } else {
            System.out.println("没票了");
        }
    }
}
