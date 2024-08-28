package com.trip.algorithm.leet.l24.l100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author xbguo
 * @date 2024/8/28 15:16
 */
public class Solution739 {
    public static void main(String[] args) {
        int[] arr={73,74,75,71,69,72,76,73};
        int[] ints = dailyTemperatures(arr);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res=new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<int[]>();
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            int[] arr=new int[]{i,temperature};
            while (!stack.isEmpty()&&temperature>stack.peekLast()[1]){
                int i1 = stack.pollLast()[0];
                res[i1]=i-i1;
            }
            stack.addLast(arr);
        }
        return res;
    }
}
