package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年05月31日 09:53:00
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 * 通过次数739,511提交次数1,205,612
 */
public class Solution11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        //int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] arr = {1,1};
        int i = solution11.maxArea(arr);
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        int len = height.length;

        int sum = 0;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int weight = Math.min(height[left], height[right]);
            int x = right - left;
            sum = Math.max(x * weight, sum);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return sum;
    }
}
