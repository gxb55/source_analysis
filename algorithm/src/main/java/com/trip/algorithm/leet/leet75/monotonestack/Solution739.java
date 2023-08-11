package com.trip.algorithm.leet.leet75.monotonestack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author xbguo
 * @createTime 2023年08月05日 10:55:00
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 */
public class Solution739 {
    public static void main(String[] args) {
       // int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
       // int[] temperatures = {30,40,50,60};
        int[] temperatures = {30,60,90};
        int[] ints = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<int[]> deque = new ArrayDeque();
        for (int i = 0; i < temperatures.length; i++) {
            int val = temperatures[i];
            int[] ints = {i, val};
            // 单调递减，如果当前加入栈的数大于之前的数，则之前的数就有了答案
            while (!deque.isEmpty() && deque.peekLast()[1] < val) {
                int[] poll = deque.pollLast();
                int x = i - poll[0];
                res[poll[0]] = x;
            }
            deque.addLast(ints);
        }
        return res;
    }
}
