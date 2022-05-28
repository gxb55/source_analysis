package com.trip.algorithm.leet.some;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>
 * <p>
 * 提示:
 * <p>
 * 0 < nums.length <= 100
 *
 * @author Administrator
 */
public class Leet_offer_45 {
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        Leet_offer_45 l = new Leet_offer_45();
        String s = l.minNumber(arr);
        System.out.println(s);
    }

    public String minNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
                list.add(i);
        }

        List<Integer> collect = list.stream().sorted((o1, o2) -> {
            String str1 = String.valueOf(o1) + o2;
            String str = String.valueOf(o2) + o1;
            return str1.compareTo(str);
        }).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (int i : collect) {
            sb.append(i);
        }
        return sb.toString();
    }
}
