package com.trip.algorithm.leet.some.history;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * 通过次数555,014提交次数857,727
 */
public class Leet_215 {
    public static void main(String[] args) {
        Leet_215 l = new Leet_215();
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int k=4;
        int kthLargest = l.findKthLargest(arr,k);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len-k];
    }
}
