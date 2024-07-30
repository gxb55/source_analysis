package com.train.ctrip.question4.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/7/26 09:20
 */
public class ListDemo {

    public static void main(String[] args) {
       // listDemo1();
       // m2();
        String s=new String("AA");
        System.out.println("AA".hashCode());
        System.out.println("AB".hashCode());
        System.out.println("AA".hashCode());
        System.out.println(s.hashCode());
    }

    /**
     * 迭代器中的删除，只能调用迭代器的删除，如果用了list的remove会抛异常
     */
    private static void m2() {
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 4, 5, 6, 7, 8, 3));
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == 6) {
               // list.remove(next);
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    /**
     * 不可变的list，不能再add或者remove
     */
    private static void listDemo1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.remove(10);
        list.add(10);
        System.out.println(list);
    }

}
