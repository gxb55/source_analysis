package com.trip.algorithm.countdown.dp.day0430;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author xbguo
 * @createTime 2023年04月30日 15:50:00
 * 264. 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * <p>
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 */
public class Solution264 {
    public static void main(String[] args) {
        int n = 10;
         n = 1407;
     //   n = 4;
        int i = nthUglyNumber(n);
        System.out.println(i);
    }

    public static int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        Set<Long> set = new HashSet<>();
        set.add(1L);
        for (int i = 1; i < n; i++) {
            Integer poll = Math.toIntExact(queue.poll());
            if(set.add(poll*2L)){
                queue.add(poll*2L);
            }
            if(set.add(poll*3L)){
                queue.add(poll*3L);
            }
            if(set.add(poll*5L)){
                queue.add(poll*5L);
            }
        }
        return Math.toIntExact(queue.poll());
    }
}
