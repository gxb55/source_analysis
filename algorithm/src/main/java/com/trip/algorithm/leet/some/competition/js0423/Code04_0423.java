package com.trip.algorithm.leet.some.competition.js0423;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2022年04月23日 16:04:00
 */
public class Code04_0423 {
    public static void main(String[] args) {
        Code04_0423 code04_0423 = new Code04_0423();
        int[] priceA = {11,27,25,25,2,8,27,2,26};
        int[] priceB = {11,13,9,3,7,30,19,29,23};
        int i = code04_0423.goShopping(priceA, priceB);
        System.out.println(i);
    }

    public int goShopping(int[] priceA, int[] priceB) {
        int index = 0;
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        return process(priceA, priceB, listA, listB, index);
    }

    private int process(int[] priceA, int[] priceB, List<Integer> listA, List<Integer> listB, int index) {
        if (index == priceA.length) {
            int sum = 0;
            int suma = 0;
            int sumb = 0;
            for (int a : listA) {
                suma += a;
            }
            if (listA.size() >= 3) {

                suma = (int) Math.floor(suma * 0.7);
            }
            if (listB.size() >= 3) {
                List<Integer> collect = listB.stream().sorted(Integer::compareTo).collect(Collectors.toList());
                int t = 0;
                List<Integer> list = new ArrayList<>();
                for (Integer integer : collect) {
                    list.add(integer);
                    t++;
                    if (t == 3) {
                        list.remove(0);
                        for (Integer a : list) {
                            sumb += a;
                        }
                        list.clear();
                        t = 0;
                    }
                }
                for (Integer a : list) {
                    sumb += a;
                }
            } else {
                for (Integer a : listB) {
                    sumb += a;
                }
            }
            sum = suma + sumb;
            System.out.println(sum);
            return sum;
        }
        listA.add(priceA[index]);
        int res1 = process(priceA, priceB, listA, listB, index + 1);
        listA.remove(Integer.valueOf(priceA[index]));

        listB.add(priceB[index]);
        int res2 = process(priceA, priceB, listA, listB, index + 1);
        listB.remove(Integer.valueOf(priceB[index]));
        return Math.min(res1, res2);

    }
}
