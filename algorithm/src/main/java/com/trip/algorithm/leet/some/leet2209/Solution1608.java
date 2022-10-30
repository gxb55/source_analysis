package com.trip.algorithm.leet.some.leet2209;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年09月12日 20:42:00
 * 1608. 特殊数组的特征值
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 * <p>
 * 注意： x 不必 是 nums 的中的元素。
 * <p>
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,5]
 * 输出：2
 * 解释：有 2 个元素（3 和 5）大于或等于 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0]
 * 输出：-1
 * 解释：没有满足题目要求的特殊数组，故而也不存在特征值 x 。
 * 如果 x = 0，应该有 0 个元素 >= x，但实际有 2 个。
 * 如果 x = 1，应该有 1 个元素 >= x，但实际有 0 个。
 * 如果 x = 2，应该有 2 个元素 >= x，但实际有 0 个。
 * x 不能取更大的值，因为 nums 中只有两个元素。
 * 示例 3：
 * <p>
 * 输入：nums = [0,4,3,0,4]
 * 输出：3
 * 解释：有 3 个元素大于或等于 3 。
 * 示例 4：
 * <p>
 * 输入：nums = [3,6,7,7,0]
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * 通过次数40,964提交次数66,733
 */
public class Solution1608 {
    public static void main(String[] args) {
        Solution1608 solution1608 = new Solution1608();
        // int[] nums={0,4,3,0,4};
        //int[] nums={3,6,7,7,0};
        //  int[] nums = {3, 6, 7, 7, 0};
        int[] nums = {2, 3, 0, 2};
        //int[] nums = {3, 5};
        int i = solution1608.specialArray(nums);
        System.out.println(i);
    }

    /**
     * 如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值
     */

    public int specialArray(int[] nums) {
        int res = -1;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int cur = nums[i];
            int right = length - i;
            while (true) {
                if (cur >= right && cur == right) {
                    if (i == 0 || nums[i - 1] != nums[i]) {
                        return right;
                    }
                }
                if (cur < right) {
                    break;
                }
                if (i >= 1 && nums[i - 1] < cur - 1) {
                    cur--;
                } else if (i == 0) {
                    cur--;
                } else if (cur < 0) {
                    break;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
