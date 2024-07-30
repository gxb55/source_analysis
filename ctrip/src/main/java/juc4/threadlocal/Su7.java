package juc4.threadlocal;

public class Su7 {
    private Integer total;

    public synchronized void sale() {
        total++;
    }

    public Su7() {
        this.total = 0;
    }
    ThreadLocal<Integer> threadLocal =ThreadLocal.withInitial(()->0);

    public void personSale(){
        Integer i1 = threadLocal.get();
        threadLocal.set(i1+1);
    }

    public Integer getTotal() {
        return total;
    }
}
