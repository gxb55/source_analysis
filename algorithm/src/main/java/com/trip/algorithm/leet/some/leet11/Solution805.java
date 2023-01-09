package com.trip.algorithm.leet.some.leet11;

import java.util.*;

/**
 * @author xbguo
 * @date 2022/11/14 10:10
 * @description Solution805
 * 805. 数组的均值分割
 * 给定你一个整数数组 nums
 * <p>
 * 我们要将 nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和 B 数组不为空，并且 average(A) == average(B) 。
 * <p>
 * 如果可以完成则返回true ， 否则返回 false  。
 * <p>
 * 注意：对于数组 arr ,  average(arr) 是 arr 的所有元素除以 arr 长度的和。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7,8]
 * 输出: true
 * 解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
 * 示例 2:
 * <p>
 * 输入: nums = [3,1]
 * 输出: false
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 30
 * 0 <= nums[i] <= 104
 * 通过次数6,344提交次数18,327
 */
public class Solution805 {
    public static void main(String[] args) {
        Solution805 solution805 = new Solution805();
        // int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        // int[] arr = {1, 3};
        // int[] arr = {17, 3, 7, 12, 1};
        int[] arr = {4, 4, 4, 4, 4, 4, 5, 4, 4, 4, 4, 4, 4, 5};
        boolean b = solution805.splitArraySameAverage2(arr);
        System.out.println(b);
        int x=1<<5;
        System.out.println(x);
        solution805.getNum();
    }

    public boolean splitArraySameAverage(int[] nums) {
        double sum = 0;
        for (int x : nums) {
            sum = sum + x;
        }
        double res = sum / nums.length;
        if (res * nums.length != sum) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        return process(nums, res, 0, 0, list);
    }

    private boolean process(int[] nums, double res, int index, double sum, List<Integer> list) {
        if (list.size() != 0 && sum / list.size() == res && list.size() != nums.length) {
            return true;
        }
        for (; index < nums.length; index++) {
            list.add(nums[index]);
            boolean process = process(nums, res, index + 1, sum + nums[index], list);
            if (process) {
                return true;
            }
            list.remove(list.size() - 1);
        }
        return false;
    }

    public boolean splitArraySameAverage2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return false;
        }
        int s = Arrays.stream(nums).sum();
        for (int i = 0; i < n; ++i) {
            nums[i] = nums[i] * n - s;
        }
        int m = n >> 1;
        Set<Integer> vis = new HashSet<>();
        for (int i = 1; i < 1 << m; ++i) {
            int t = 0;
            for (int j = 0; j < m; ++j) {
                if (((i >> j) & 1) == 1) {
                    t += nums[j];
                }
            }
            if (t == 0) {
                return true;
            }
            vis.add(t);
        }
        int count=n-m;
        for (int i = 1; i < (1 << count); ++i) {
            int t = 0;
            for (int j = 0; j < count; ++j) {
                if (((i >> j) & 1) == 1) {
                    // m + j 这是重点，这代表选了数组的右半部分
                    t += nums[m + j];
                }
            }
            if (t == 0 || (i != (1 << (n - m)) - 1) && vis.contains(-t)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 我们来看一个可以用二进制枚举的方法解决的题目。
     *
     * 话说大诗人李白，一生好饮。幸好他从不开车。
     *
     * —天，他提着酒壶，从家里出来，酒壶中有酒两斗。他边走边唱:
     *
     * 无事街上走，提壶去打酒。
     * 逢店加一倍，遇花喝一斗。
     * 这一路上，他一共遇到店 5 次，遇到花 10 次，已知最后一次遇到的是花，他正好把酒喝光了。请你计算李白遇到店和花的次序，有多少种可能的方案。
     * 这个题目解法很多，二进制枚举是一种写起来非常简洁的解法。
     * 我们已知遇店 5 次，遇花 10 次，并且最后一次遇到花，正好把酒喝光。
     * 那么我们可以把店作为二进制中的 1，把花作为二进制中的 0，因为已经确定最后一次遇到的是花，所以我们需要判断枚举的结果是否刚好有 5 个 1 和 9 个 0。那么我们就枚举出 14 位二进制的所有可能并加以判断即可，
     * 判断思路为判断二进制是否有 9 个 0，5 个 1,并且最终酒刚好剩 1 斗。
     *
     * 根据这个思路，可以写出如下的代码：
     * @return
     */
    public int getNum() {
        int ans = 0;
        for (int i = 0; i < (1 << 14); ++i) {
            int tot_1 = 0;
            int tot_0 = 0;
            int num = 2;
            for (int j = 0; j < 14; ++j) {
                // 这里判断二进制 i 从右数第 j + 1 位是否为 1
               /* if (((i >> j) & 1) == 1) {
                    t += nums[j];
                }*/
                if ((1 & (i >> j))==1) {
                    tot_1++;
                    num = num * 2;
                } else {
                    tot_0++;
                    num = num - 1;
                }
            }
            if (tot_1 == 5 && tot_0 == 9 && num == 1) {
                ++ans; // 记录合法方案数
            }
        }
        System.out.println(ans);
        return ans;
    }

}
