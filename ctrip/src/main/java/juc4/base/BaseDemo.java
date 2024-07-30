package juc4.base;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class BaseDemo {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,1, 2, 2,3, 4, 5);
        ArrayList<Integer> integers = new ArrayList<>(list);
        for (int i = 0; i < integers.size(); i++) {
            Integer x = integers.get(i);
            if(x==1){
                integers.remove(x);
            }
        }
        for (int x:integers){
            if(x==2){
                integers.remove(x);
            }
        }
        System.out.println(list);
    }

    private static void m1() {
        Integer i = new Integer(99);
        System.out.println(i == 99);
        Integer i1 = Integer.valueOf(1);

        BigDecimal bigDecimal = BigDecimal.valueOf(2.0);
        BigDecimal bigDecimal1 = new BigDecimal("2.00");


        System.out.println("=======");
        double a = 1234567890123456789.3141592631415926;
        BigDecimal bigDecimal3 = BigDecimal.valueOf(a);
        String string = new String(String.valueOf(a));
        System.out.println(String.valueOf(a));
        BigDecimal bigDecimal2 = new BigDecimal("1234567890123456789.3141592631415926");
        System.out.println(bigDecimal2.toPlainString());
        System.out.println(bigDecimal3.toPlainString());


        BigDecimal decimal = new BigDecimal("0.3");
        BigDecimal decimal1 = new BigDecimal("0.7");
        System.out.println(decimal1.divide(decimal, 2, RoundingMode.HALF_UP));


        List<String> list1 = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
        List<String> list = new ArrayList<>(list1);

        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).equals("2")) {
                list.remove(list.get(j));
            }
        }
        System.out.println(list);

        for (String x : list) {
            if (x.startsWith("2")) {
                list.remove(x);
            }
        }
        System.out.println(list);
    }
}
