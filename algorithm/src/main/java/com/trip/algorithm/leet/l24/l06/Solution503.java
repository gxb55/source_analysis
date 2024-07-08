package com.trip.algorithm.leet.l24.l06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author xbguo
 * @date 2024/6/25 10:56
 */
public class Solution503 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,3};
        int[] ints = nextGreaterElements(arr);
        System.out.println(Arrays.toString(ints));
    }

    public  static int[] nextGreaterElements(int[] nums) {
        LinkedList<int[]> list = new LinkedList<>();
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int cur = 0;
        while (true) {
            index = index % nums.length;
            int num = nums[index];
            while (!list.isEmpty() && num > list.peekLast()[1]) {
                int val = list.pollLast()[0];
                Integer integer = map.get(val);
                if (integer == null) {
                    map.put(val, num);
                }
            }
            list.addLast(new int[]{index, num});
            index++;
            cur++;
            if (cur > 2 * nums.length) {
                break;
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.getOrDefault(i, -1);
        }

        return res;
    }
}
