package com.trip.algorithm.leet.some.leet11;

/**
 * @auther: xbguo
 * @date: 2022/11/4 11:17
 * @description: Solution754
 */
public class Solution754 {
    public static void main(String[] args) {
        Solution754 solution754 = new Solution754();
        int target = 2;
        int i = solution754.reachNumber1(target);
        System.out.println(i);
    }


    public int reachNumber(int target) {
        process(0, 1, 0, Math.abs(target));
        return max;
    }

    int max = Integer.MAX_VALUE;

    private void process(int index, int step, int times, int target) {
        if (index > target || index < Integer.valueOf("-" + target)) {
            return;
        }
        if (index == target) {
            max = Math.min(max, times);
            return;
        }
        process(index + step, step + 1, times + 1, target);
        process(index - step, step + 1, times + 1, target);
    }

    public int reachNumber1(int target) {
        target = Math.abs(target);
        int len = 1;
        int cur = 0;
        int times = 0;
        while (cur < target) {
            cur = cur + len;
            len++;
            times++;
        }
        int i = cur - target;
        if (cur == target) {
            return times;
        } else if (i % 2 == 0) {
            return times;
        } else if ((cur + len - target) % 2 == 0) {
            return times + 1;
        } else {
            return times + 2;
        }
    }
}
