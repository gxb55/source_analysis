package com.trip.algorithm.leet.some.history;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年05月29日 16:13:00
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能尽量减少完成的操作次数吗？
 * <p>
 * 通过次数758,424提交次数1,185,429
 */
public class Solution283 {
    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        int[] nums = {1, 1, 0, 0, 12, 12, 23};
        solution283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int x = -1;
        int y = -1;
        int t = -1;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val == 0 && x == -1) {
                x = i;
                t = i;
            }
            if (val != 0) {
                y = i;
            }

            if (x != -1 && y != -1 && y > x) {
                swap(x, y, nums);
                x = y;
                for (int j = x + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        y = j;

                        swap(x, y, nums);
                        x = y;
                    }
                }
                x = y = -1;
                i = t;
            }

        }
    }



    private void swap(int x, int y, int[] nums) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}
