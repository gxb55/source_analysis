package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年04月30日 16:49:00
 * 908. 最小差值 I
 * 给你一个整数数组 nums，和一个整数 k 。
 * <p>
 * 在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。
 * <p>
 * nums 的 分数 是 nums 中最大和最小元素的差值。
 * <p>
 * 在对  nums 中的每个索引最多应用一次上述操作后，返回 nums 的最低 分数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1], k = 0
 * 输出：0
 * 解释：分数是 max(nums) - min(nums) = 1 - 1 = 0。
 * 示例 2：
 * <p>
 * 输入：nums = [0,10], k = 2
 * 输出：6
 * 解释：将 nums 改为 [2,8]。分数是 max(nums) - min(nums) = 8 - 2 = 6。
 * 示例 3：
 * <p>
 * 输入：nums = [1,3,6], k = 3
 * 输出：0
 * 解释：将 nums 改为 [4,4,4]。分数是 max(nums) - min(nums) = 4 - 4 = 0。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 104
 * 0 <= k <= 104
 */
public class Leet_908 {
    public static void main(String[] args) {
        Leet_908 leet_908 = new Leet_908();

        int[] arr = Util.getArr("[0,10]");
        int i = leet_908.smallestRangeI(arr, 2);
        System.out.println(i);
    }

    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0];
        int min = nums[0];
        for (int index : nums) {
            max = Math.max(max, index);
            min = Math.min(min, index);
        }
        int temp = max - min;
        if (temp == 0 || temp <= 2 * k) {
            return 0;
        }
        return temp - (2 * k);
    }

}
