package juc4.base;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IdeaDemo {
    static int anInt=1;
    public static void main(String[] args) {
        List<Integer> collect = Stream.of(1, 2, 3, 5, 6, 7, 8, 1).filter(x -> x > 2).map(x -> 2 * x).collect(Collectors.toList());

        a();
        changeInt();

        Integer a=null;
        System.out.println(a.toString());
    }

    private static void changeInt() {
        anInt=2;
    }

    private static void a() {
        System.out.println("A");
        System.out.println("A");
        System.out.println("A");
        b();
    }

    private static void b() {
        System.out.println("B");
        System.out.println("B");
        System.out.println("B");
        c();
    }

    private static void c() {
        System.out.println("C");
    }
}
