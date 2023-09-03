package com.trip.algorithm.leet.some.leet2309;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年09月03日 10:54:00
 * [3,5,7,4,5]
 * speed =
 * [2,3,6,3,2]
 */
public class Solution1921 {
    public static void main(String[] args) {
        Solution1921 solution1921 = new Solution1921();
        // int[] dist = {1, 3, 4}, speed = {1, 1, 1};
        //   int[] dist = {1,1,2,3}, speed = {1,1,1,1};
        //int[] dist = {3,2,4}, speed = {5,3,2};
        //  int[] dist = {5, 4, 3, 3, 3}, speed = {1, 1, 5, 3, 1};
        //  int[] dist = {4, 2, 3}, speed = {2, 1, 1};
        int[] dist = {3, 5, 7, 4, 5}, speed = {2, 3, 6, 3, 2};
        int i = solution1921.eliminateMaximum1(dist, speed);
        System.out.println(i);
    }

    public int eliminateMaximum1(int[] dist, int[] speed) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < dist.length; i++) {
            int i1 = dist[i] / speed[i];
            int i2 = dist[i] % speed[i];
            int res = i1 + (i2 == 0 ? 0 : 1);
            list.add(new int[]{dist[i], speed[i], res});
        }
        List<int[]> collect = list.stream().sorted((x, y) -> x[2] - y[2]).collect(Collectors.toList());
        int count = 1;
        int length = dist.length;
        int k = 1;
        int i = 0;
        while (k <= length) {
            for (; i < collect.size(); i++) {
                int[] ints = collect.get(i);
                int val = ints[2];
                if (val == k) {
                    count--;
                } else {
                    break;
                }
                if (count < 0) {
                    return i;
                }
            }
            k++;
            count++;
        }
        return dist.length;
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int length = dist.length;
        int left = 1;
        int right = length;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            boolean check = check(mid, dist, speed);
            if (check) {
                left = (int) (mid + 1);
            } else {
                right = (int) (mid - 1);
            }
        }
        return left > length ? length : left;
    }

    private boolean check(long mid, int[] dist, int[] speed) {
        for (int i = 1; i <= mid; i++) {
            int count = 0;
            for (int j = 0; j < dist.length; j++) {
                int begin = dist[j];
                int temp = speed[j];
                long l = temp * i * 1L;
                if ((begin - (l)) <= 0) {
                    count++;
                }
            }
            if (count > i) {
                return false;
            }
        }
        return true;
    }
}
