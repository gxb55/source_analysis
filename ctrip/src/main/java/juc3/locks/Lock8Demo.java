package juc3.locks;

/**
 * @author xbguo
 * @createTime 2022年06月05日 17:33:00
 *
 * 1.a b 两个线程调用phone对象的两个方法，请问先打印邮件还是短信？;锁的是phone对象，两个线程分别运行访问，锁的是this对象
 * 2.sendEmail方法中加入暂停3秒钟，请问先打印邮件还是短信？ 锁对象，如果加了同步标识，要获取到对象锁之后才能执行方法
 * 3.添加一个普通的hello方法，，请问先打印邮件还是短信？锁对象，但是方法没有同步，即不用获取锁就可以执行
 * 4.有两部手机，，请问先打印邮件还是短信？两部手机，两个对象，分开的
 * 5.有两个静态同步方法，有一部手机，请问先打印邮件还是短信？静态方法属于类，锁的是整个jvm的类对象，会影响这个类中的其他同步静态方法
 * 6.有两个静态同步方法，有两个手机，，请问先打印邮件还是短信？手机个数，跟类对象无关，锁的还是类对象
 * 7，有一个静态同步方法，有一个普通同步方法，有一部手机，请问先打印邮件还是短信？锁的是两个对象，静态锁jvm类对象，普通锁的是堆中的对象
 * 8，有一个静态同步方法，有一个普通同步方法，有两部手机，请问先打印邮件还是短信？锁的对象不一样导致，互不影响
 */
public  class Lock8Demo {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendEmail();
        },"a").start();
        Thread.sleep(200);
        new Thread(()->{
            phone.sendMsg();
        },"b").start();
    }
}

class Phone {
    public synchronized void sendEmail() {
        System.out.println("-------- sendEmail,ThreadName:"+Thread.currentThread().getName());
    }

    public synchronized void sendMsg() {
        System.out.println("-------- sendMsg,ThreadName:"+Thread.currentThread().getName());
    }
}