package com.trip.algorithm.leet.some.leet09;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 251
 * 输出：
 * 1
 * 预期结果：
 * 3215625
 */
public class Solution_1309 {
    public static void main(String[] args) {
        Solution_1309 solution_1309 = new Solution_1309();
        int kthMagicNumber1 = solution_1309.getKthMagicNumber1(251);
        int kthMagicNumber = solution_1309.getKthMagicNumber(251);
        System.out.println(kthMagicNumber);
        System.out.println(kthMagicNumber1);
    }

    public int getKthMagicNumber(int k) {
        List<Integer> set = new ArrayList<>();
        set.add(1);

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        int index =0;
        while (list.size() < 2*k) {
            Integer pop = list.get(index);
            if(!list.contains(pop * 3)){
                list.add(pop * 3);
            }
            if(!list.contains(pop * 5)){
                list.add(pop * 5);
            }
            if(!list.contains(pop * 7)){
                list.add(pop * 7);
            }
            index++;
        }
        list= list.stream().sorted(Comparator.comparingInt(x -> x)).collect(Collectors.toCollection(LinkedList::new));
        System.out.println("getKthMagicNumber:"+list);
        return list.get(k-1);
    }

    public int getKthMagicNumber1(int k) {
        int [] result = new int[k];
        result[0] = 1;
        // 定义三个 指针，分别表示 resultA、B、C 的下标
        int point3 = 0;
        int point5 = 0;
        int point7 = 0;
        for (int i = 1; i < k; i++) {
            int resultN = Math.min(Math.min(result[point3] * 3, result[point5] * 5), result[point7] * 7);
            if (resultN % 3 == 0) {
                point3++;
            }
            if (resultN % 5 == 0) {
                point5++;
            }
            if (resultN % 7 == 0) {
                point7++;
            }
            result[i] = resultN;
        }
        System.out.println("getKthMagicNumber1"+Arrays.toString(result));
        return result[k - 1];
    }
}
