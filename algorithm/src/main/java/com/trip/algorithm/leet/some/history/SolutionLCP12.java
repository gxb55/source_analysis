package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/5/10  20:38
 * @description LCP12
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
 * 通过次数8,232提交次数19,373
 */
public class SolutionLCP12 {
        public int minTime(int[] time, int m) {
            int n = time.length;
            if (m >= n) { //如果天数大于等于题目数，每题都可以分配在不同天，并由求助完成
                return 0;
            }
            int l = 0, r = 1000000000;
            while (l < r) { //二分查找
                int mid = (l + r) >> 1;
                if (check(time, m, mid)) { //如果当前限制下可以满足，缩小右边界
                    r = mid;
                } else { //否则左边界加一
                    l = mid + 1;
                }
            }
            return l;
        }

        public boolean check(int[] time, int m, int limit) {
            int cur = 0, sum = 0, max = 0, day = 1; //当前遍历到的题目，当前组的总耗时，当前组的最大耗时，需要的天数
            while (cur < time.length) {
                sum += time[cur];
                max = Math.max(max, time[cur]);
                if (sum - max > limit) { //当前组总耗时减去组内最大耗时仍超出限制，则需要开启额外一天
                    day++;
                    if (day > m) { //超出总天数m，无法完成分配
                        return false;
                    }
                    sum = time[cur]; //sum和max更新为新组的值
                    max = time[cur];
                }
                cur++;
            }
            return true; //能遍历完所有题目即完成了分配
        }
    }
