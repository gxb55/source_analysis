package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/5/25  21:28
 * @description 42. 接雨水
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 * 通过次数487,763提交次数799,939
 */
public class Solution42 {
    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = solution42.trap(height);
        System.out.println(trap);
    }

    public int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int val = height[i];
            int left = val;
            int right = val;
            for (int j = i - 1; j >= 0; j--) {
                int i1 = height[j];
                left = Math.max(i1, left);
            }
            for (int j = i + 1; j < height.length; j++) {
                int i1 = height[j];
                right = Math.max(i1, right);
            }
            int cur = Math.min(left, right);
            if (cur > val) {
                sum = sum + (cur - val);
            }
        }
        return sum;
    }
}
