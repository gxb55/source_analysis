package juc3.threadLocals;

/**
 * @author xbguo
 * @createTime 2022年07月03日 09:36:00
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()-> 0);
        Thread thread = new Thread(()->{
            threadLocal.set(14);
            threadLocal.get();
            threadLocal.remove();
        },"T1");

    }
}
