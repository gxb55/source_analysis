package com.trip.atguigu.reactor.lamdba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class lambda {
    public static void main(String[] args) {

        MyInterface myInterface = (x, y) -> x + y;
        System.out.println(myInterface.getRes(2, 3));

        MyInterface my = (int x, int y) -> {
            return x + 1 + y + 1;
        };
        System.out.println(my.getRes(2, 3));
        MyInterface my1 = new MyInterface() {
            @Override
            public int getRes(int x, int y) {
                return x * y;
            }
        };
        System.out.println(my1.getRes(2, 3));

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("C");
        list.add("Z");
        list.sort(String::compareTo);
        System.out.println(list);
        /**
         * 入参 出参
         * 有   无
         * 有 有
         * 无 有
         * 无 无
         */

        int a = 10;
        Supplier<Integer> supplier = () -> a + 10;
        System.out.println(supplier.get());
        Function<Integer, String> function = (x) -> x.toString() + "A";
        System.out.println(function.apply(11));

        Consumer<Integer> consumer = (x) -> System.out.println(100 + x);
        consumer.accept(1);
        int t=3;
        Predicate<Integer> predicate = (x) -> x % t == 0;
        System.out.println(predicate.test(10));
        System.out.println(predicate.negate().test(10));



        List<Integer> list1 = Arrays.asList(1,1,2,3,4,5,6,7,8,8,9,8,8,9,10);
        Map<Integer, Integer> collect = list1.stream().collect(Collectors.toMap((x) -> x, (y) -> 2 * y, (x, y) -> x));
        System.out.println(collect);
    }
}

interface MyInterface {
    int getRes(int x, int y);
}
