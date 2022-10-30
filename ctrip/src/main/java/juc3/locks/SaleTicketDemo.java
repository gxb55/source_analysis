package juc3.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xbguo
 * @createTime 2022年06月05日 18:39:00
 */
public class SaleTicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket(50);
        new Thread(() -> {
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        }, "C").start();
    }
}

class Ticket {
    public int num;

    ReentrantLock lock = new ReentrantLock(true);

    public Ticket(int num) {
        this.num = num;
    }

    public void sale() {
        lock.lock();
        try {
            if (num > 0) {
                System.out.println("当前线程：" + Thread.currentThread().getName() + " 当前票量：" + (num--) + " 卖完之后的票量" + num);
            }
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }
}
