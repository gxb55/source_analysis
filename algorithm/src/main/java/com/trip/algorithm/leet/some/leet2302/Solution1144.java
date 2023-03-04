package com.trip.algorithm.leet.some.leet2302;

/**
 * @author xbguo
 * @createTime 2023年02月27日 21:23:00
 * <p>
 * 1144. 递减元素使数组呈锯齿状
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 * <p>
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 * <p>
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：我们可以把 2 递减到 0，或把 3 递减到 1。
 * 示例 2：
 * <p>
 * 输入：nums = [9,6,1,6,2]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * 通过次数27,379提交次数55,153
 */
public class Solution1144 {
    public static void main(String[] args) {
        // int[] nums = {1, 2, 3};
        int[] nums = {9, 6, 1, 6, 2};
        int i = movesToMakeZigzag(nums);
        System.out.println(i);
    }

    public static int movesToMakeZigzag(int[] nums) {
        int count = 0;
        int count1 = 0;
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                int cur = nums[i];
                while ((i - 1) >= 0 && nums[i - 1] >= cur) {
                    nums[i - 1]--;
                    count++;
                }
                while ((i + 1) < nums.length && nums[i + 1] >= cur) {
                    nums[i + 1]--;
                    count++;
                }
            } else {
                int cur = arr[i];
                while ((i - 1) >= 0 && arr[i - 1] >= cur) {
                    arr[i - 1]--;
                    count1++;
                }
                while ((i + 1) < nums.length && arr[i + 1] >= cur) {
                    arr[i + 1]--;
                    count1++;
                }
            }
        }

        return Math.min(count1, count);
    }
}
