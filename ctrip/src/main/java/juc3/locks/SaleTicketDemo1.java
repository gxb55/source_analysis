package juc3.locks;

import java.util.concurrent.TimeUnit;

/**
 * @author xbguo
 * @createTime 2022年12月24日 17:29:00
 */
public class SaleTicketDemo1 {
    public static void main(String[] args) throws InterruptedException {
        TicketCount ticketCount = new TicketCount();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 20; j++) {
                    ticketCount.saleTicket();
                }
            }, "T" + i).start();
        }
        TimeUnit.SECONDS.sleep(10);
    }
}

class TicketCount {
    private int ticketCount = 50;
    private Object object = new Object();

    public synchronized void saleTicket() {
        if (ticketCount <= 0) {
            System.out.println("当前线程是：" + Thread.currentThread().getName() + "没票了");
            return;
        }
        System.out.println("当前线程是：" + Thread.currentThread().getName() + "买了一张票剩余：" + --ticketCount);
    }
}
