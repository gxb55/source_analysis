package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/4/18  9:31
 * @description 386. 字典序排数
 *
 * 386. 字典序排数
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 *
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 1 <= n <= 5 * 104
 */
public class Solution_386 {
    public static void main(String[] args) {
        Solution_386 solution_386 = new Solution_386();
        List<Integer> list = solution_386.lexicalOrder1(100);
        System.out.println(list);
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        List<Integer> collect = list.stream().sorted((x, y) -> x.toString().compareTo(y.toString())).collect(Collectors.toList());
        return collect;
    }
    public List<Integer> lexicalOrder1(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            ret.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return ret;
    }

}
