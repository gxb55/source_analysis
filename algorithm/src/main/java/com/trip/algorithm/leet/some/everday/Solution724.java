package com.trip.algorithm.leet.some.everday;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年07月16日 21:25:00
 * 724. 寻找数组的中心下标
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * <p>
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * <p>
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * 示例 2：
 * <p>
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * 示例 3：
 * <p>
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 * <p>
 * <p>
 * 注意：本题与主站 1991 题相同：https://leetcode-cn.com/problems/find-the-middle-index-in-array/
 * <p>
 * 通过次数201,686提交次数407,011
 */
public class Solution724 {
    public static void main(String[] args) {

    }

    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            sum = sum - val;
            if(i>0){
                left=left+nums[i-1];
            }
            if (left == sum) {
                return i;
            }
        }
        return -1;
    }
}
