package com.trip.algorithm.leet.some.leet2209;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年09月06日 08:17:00
 * LCP 12. 小张刷题计划
 * 为了提高自己的代码能力，小张制定了 LeetCode 刷题计划，他选中了 LeetCode 题库中的 n 道题，编号从 0 到 n-1，并计划在 m 天内按照题目编号顺序刷完所有的题目（注意，小张不能用多天完成同一题）。
 *
 * 在小张刷题计划中，小张需要用 time[i] 的时间完成编号 i 的题目。此外，小张还可以使用场外求助功能，通过询问他的好朋友小杨题目的解法，可以省去该题的做题时间。为了防止“小张刷题计划”变成“小杨刷题计划”，小张每天最多使用一次求助。
 *
 * 我们定义 m 天中做题时间最多的一天耗时为 T（小杨完成的题目不计入做题总时间）。请你帮小张求出最小的 T是多少。
 *
 * 示例 1：
 *
 * 输入：time = [1,2,3,3], m = 2
 *
 * 输出：3
 *
 * 解释：第一天小张完成前三题，其中第三题找小杨帮忙；第二天完成第四题，并且找小杨帮忙。这样做题时间最多的一天花费了 3 的时间，并且这个值是最小的。
 *
 * 示例 2：
 *
 * 输入：time = [999,999,999], m = 4
 *
 * 输出：0
 *
 * 解释：在前三天中，小张每天求助小杨一次，这样他可以在三天内完成所有的题目并不花任何时间。
 *
 *
 *
 * 限制：
 *
 * 1 <= time.length <= 10^5
 * 1 <= time[i] <= 10000
 * 1 <= m <= 1000
 * 通过次数9,495提交次数21,970
 */
public class SolutionLCP12 {
    public static void main(String[] args) {
        /*int[] time = {1, 2, 3, 3};
        int m = 2;  */

        int[] time = {94,92,90,57,6,89,63,15,91,74};
        int m = 6;

        SolutionLCP12 solution12 = new SolutionLCP12();
        int i = solution12.minTime2(time, m);
        int j = solution12.minTime1(time, m);
        System.out.println(i);
        System.out.println(j);
    }

    public int minTime1(int[] time, int m) {
        int len = time.length;
        if (len <= m) {
            return 0;
        }
        int l = 1, r = (int) 1e9;
        int ans = 0;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int take = 1;
            int sum = 0, max = 0;
            boolean delete = true;
            for (int i = 0; i < time.length; ) {
                int t = time[i];
                sum += t;
                max = Math.max(max, t);
                if (sum > mid) {
                    if (delete) {
                        sum -= max;
                        delete = false;
                        i++;
                    } else {
                        sum = 0;
                        delete = true;
                        max = 0;
                        take++;
                    }
                } else {
                    i++;
                }
            }
            if (take <= m) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 假如x可以满足条件，则x+1也可以满足条件
     * 极小值的极大值问题
     */
    public int minTime2(int[] time, int m) {
        int len = time.length;
        if (len <= m) {
            return 0;
        }
        int l = 0;
        int r = 10000;
        int ans = 0;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int max = 0;
            long sum = 0;
            int take = 1;
            boolean check = true;
            for (int i = 0; i < time.length; ) {
                int t = time[i];
                sum = sum + t;
                max = Math.max(max, t);
                if (sum <= mid) {
                    i++;
                } else {
                    if (check) {
                        sum -= max;
                        check = false;
                        i++;
                    } else {
                        take++;
                        check = true;
                        sum = 0;
                        max = 0;
                    }
                }
            }
            if (take <= m) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    int max = Integer.MAX_VALUE;

    public int minTime(int[] time, int m) {
        if (m > time.length) {
            return 0;
        }
        process(time, 0, m);
        return max;
    }

    private void process(int[] time, int i, int m) {
        if (i == time.length || m <= 0) {
            return;
        }

        int len = time.length;
        if ((len - i) == m) {
            max = Math.max(max, 0);
            return;
        }
        List<Integer> list = new ArrayList<>();
        int curMax = -1;
        for (int j = i; j < (len - (m - 1)); j++) {
            list.add(time[j]);
            if (m == 1) {
                curMax = Math.max(curMax, time[j]);
                int x = 0;
                for (int i1 : list) {
                    x = x + i1;
                }
                int i1 = x - curMax;
                max = Math.min(max, i1);
            } else {
                curMax = Math.max(curMax, time[j]);
                int x = 0;
                for (int i1 : list) {
                    x = x + i1;
                }
                int i1 = x - curMax;
                max = Math.min(max, i1);
                process(time, j + 1, m - 1);
            }
        }
    }



}
