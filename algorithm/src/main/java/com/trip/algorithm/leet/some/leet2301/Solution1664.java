package com.trip.algorithm.leet.some.leet2301;

/**
 * @author xbguo
 * @date 2023/1/28 13:53
 * @description 1664
 * 1664. 生成平衡数组的方案数
 * 给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
 * <p>
 * 比方说，如果 nums = [6,1,7,4,1] ，那么：
 * <p>
 * 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
 * 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
 * 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
 * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
 * <p>
 * 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,6,4]
 * 输出：1
 * 解释：
 * 删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
 * 删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
 * 删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
 * 删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
 * 只有一种让剩余数组成为平衡数组的方案。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：3
 * 解释：你可以删除任意元素，剩余数组都是平衡数组。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：0
 * 解释：不管删除哪个元素，剩下数组都不是平衡数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class Solution1664 {
    public static void main(String[] args) {
        Solution1664 solution1664 = new Solution1664();
       // int[] nums = {2, 1, 6, 4};
        int[] nums = {1,1,1};
        int i = solution1664.waysToMakeFair(nums);
        System.out.println(i);
    }

    public int waysToMakeFair(int[] nums) {
        int res = 0;
        // 偶数和
        long x = 0;
        // 奇数和
        long y = 0;
        int len = nums.length;
        // 奇数和
        long[] arr2 = new long[len];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if ((i % 2) == 0) {
                x = x + num;
                arr2[i] = x;
            } else {
                y = y + num;
                arr2[i] = y;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            // 上一个偶数和
            long lastX = 0;
            // 上一个奇数和
            long lastY = 0;
            if (i % 2 == 0) {
                if (i - 2 >= 0) {
                    lastY = arr2[i - 1];
                    lastX = arr2[i - 2];
                } else if (i - 1 >= 0) {
                    lastY = arr2[i - 1];
                }
                // 左边的奇数和+右边的偶数和
                long l = lastY + (x - arr2[i]);
                // 左边的偶数和+右边的奇数和
                long l1 = lastX + (y - lastY);
                if (l == l1) {
                    res++;
                }
            } else {
                if (i - 2 >= 0) {
                    lastX = arr2[i - 1];
                    lastY = arr2[i - 2];
                } else if (i - 1 >= 0) {
                    lastX = arr2[i - 1];
                }

                // 左边的奇数和+右边的偶数和
                long l = lastY + (x - lastX);
                // 左边的偶数和+右边的奇数和
                long l1 = lastX + (y - arr2[i]);
                if (l == l1) {
                    res++;
                }
            }
        }
        return res;
    }
}
