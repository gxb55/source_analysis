package com.trip.algorithm.leet.l24.l03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/3/27 11:24
 */
public class Solution2580 {
    public static void main(String[] args) {
        Solution2580 solution2580 = new Solution2580();
        //int[][] ranges = {{1, 3}, {10, 20}, {2, 5}, {4, 8}};
        int[][] ranges = {{34,56},{28,29},{12,16},{11,48},{28,54},{22,55},{28,41},{41,44}};
        int i = solution2580.countWays1(ranges);
        System.out.println(i);
    }

    public int countWays(int[][] ranges) {
        List<int[]> list = new ArrayList<>();
        for (int[] arr : ranges) {
            int l = arr[0];
            int r = arr[1];
            if (list.isEmpty()) {
                list.add(new int[]{l, r});
                continue;
            }
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                int[] ints = list.get(i);
                int l1 = ints[0];
                int r1 = ints[1];
                if (r < l1 || l > r1) {

                } else {
                    ints[0] = Math.min(l, l1);
                    ints[1] = Math.max(r, r1);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(new int[]{l, r});
            }
        }
        // System.out.println(list.size());
        long cur = 1;
        for (int i = 0; i < list.size(); i++) {
            cur = cur * 2;
            cur = cur % 100000007;
        }
        return 0;
    }

    public int countWays1(int[][] ranges) {
        Arrays.sort(ranges, (x, y) -> x[0] - y[0]);
        List<int[]> list = new ArrayList<>();
        int last = -1;
        for (int[] arr : ranges) {
            int l = arr[0];
            int r = arr[1];
            if (last == -1) {
                list.add(new int[]{l, r});
                last = r;
            } else if (l > last) {
                list.add(new int[]{l, r});
                last=r;
            } else if (l <= last) {
                list.get(list.size() - 1)[1] = Math.max(r, list.get(list.size() - 1)[1]);
                last=Math.max(r, list.get(list.size() - 1)[1]);
            }
        }
        int cur = 1;
        for (int i = 0; i < list.size(); i++) {
            cur = cur * 2;
            cur = cur % 100000007;
        }
        return  cur;
    }
}
