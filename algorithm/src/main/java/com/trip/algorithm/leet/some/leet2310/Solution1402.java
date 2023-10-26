package com.trip.algorithm.leet.some.leet2310;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/10/23 11:22
 */
public class Solution1402 {
    public static void main(String[] args) {

        Solution1402 solution1402 = new Solution1402();
       int[] satisfaction = {-1,-8,0,5,-7};
       // int[] satisfaction = {4,3,2};
        int i = solution1402.maxSatisfaction1(satisfaction);
        System.out.println(i);
    }

    public int maxSatisfaction1(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int r = 0;
        int index = -1;
        int sum = 0;
        int t = 1;
        for (int x : satisfaction) {
            if (x >= 0) {
                r += x;
                sum += x * t;
                t++;
            } else {
                index++;
            }
        }
        if (index ==-1) {
            return sum;
        }
        if(r==0){
            return 0;
        }
        int v0=sum;
        for (int i = index; i >= 0; i--) {
            int v2 = v0 + (index - i+1) * r;
            int v3 = 1;
            int v1 = 0;
            for (int j = i; j <= index; j++) {
                v1 = v1 + v3 * satisfaction[j];
                v3++;
            }
            int sum1 = v2 + v1;
            if (sum > sum1) {
                return sum;
            }
            sum = sum1;
        }
        return sum;
    }

    public int maxSatisfaction(int[] satisfaction) {

        return process(satisfaction, 0, 1);

    }

    private Map<String, Integer> map = new HashMap<>();

    private int process(int[] satisfaction, int index, int t) {
        if (index >= satisfaction.length) {
            return 0;
        }
        String v = index + "_" + t;
        if (map.containsKey(v)) {
            return map.get(v);
        }
        int p1 = process(satisfaction, index + 1, t + 1) + satisfaction[index] * t;
        int p2 = process(satisfaction, index + 1, t);
        int max = Math.max(p2, p1);
        int max1 = Math.max(max, 0);
        map.put(v, max1);
        return max1;
    }
}
