package com.trip.algorithm.leet.l24.l03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/3/28 17:05
 */
public class Solution1997 {
    public static void main(String[] args) {
        Solution1997 solution1997 = new Solution1997();
        // int[] nextVisit = {0, 0};
        //   int[] nextVisit = {0,0,2};
        //  int[] nextVisit = {0,1,2,0};
        int[] nextVisit = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int i = solution1997.firstDayBeenInAllRooms1(nextVisit);
        System.out.println("ss" + i);
    }

    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int count = 0;
        int curIndex = 0;
        while (!list.isEmpty()) {
            list.remove(Integer.valueOf(curIndex));
            // int i = nextVisit[curIndex];
            arr[curIndex]++;
            //   System.out.println(curIndex);
            // 奇数
            if (arr[curIndex] % 2 == 1) {
                while (arr[curIndex] % 2 == 1) {
                    arr[curIndex]++;
                    curIndex = nextVisit[curIndex];
                    count++;
                }
            } else {
                // 偶数
                int nextIndex = (curIndex + 1) % n;
                while (curIndex == ((curIndex + 1) % n)) {
                    curIndex = (curIndex + 1) % n;
                    arr[curIndex]++;
                    count++;
                }
            }
            count++;
            count = count % 1000000007;
        }
        return count - 1;
    }

    public int firstDayBeenInAllRooms3(int[] nextVisit) {
        long[] dp = new long[nextVisit.length];
        int m = 1000000007;
        //dp[i] 第一次在i位置的时候是奇数是哪一天，dp[i] - dp[nextVisit[i]] 从 x-j 所需要的天数，+1是后退的那次，+1是往前走到i+1那次
        for (int i = 0; i < nextVisit.length-1; i++) {
            int j=nextVisit[i];
            dp[i + 1] = (dp[i]+dp[i] - dp[j] + 1  + m) % m+ 1;
        }
        return (int) (dp[dp.length - 1]% m);
    }

    public int firstDayBeenInAllRooms1(int[] nextVisit) {
        int n = nextVisit.length;
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int count = 0;
        int curIndex = 0;
        while (!list.isEmpty()) {
            list.remove(Integer.valueOf(curIndex));
            // int i = nextVisit[curIndex];
            arr[curIndex]++;
            System.out.println(curIndex);
            // 奇数
            if (arr[curIndex] % 2 == 1) {
                curIndex = nextVisit[curIndex];
            } else {
                // 偶数
                curIndex = (curIndex + 1) % n;
            }
            count++;
            count = count % 1000000007;
        }
        return count - 1;
    }
}
