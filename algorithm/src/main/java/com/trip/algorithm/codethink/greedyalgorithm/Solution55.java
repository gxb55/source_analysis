package com.trip.algorithm.codethink.greedyalgorithm;

/**
 * @author xbguo
 * @date 2023/2/10 18:48
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution55 {
    public static void main(String[] args) {
        // int[] nums = {2,3,1,1,4};
        int[] nums = {3, 2, 1, 1, 4};
        boolean b = canJump(nums);
        System.out.println(b);
    }

    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            int cur = nums[i];
            max = Math.max(cur + i, max);
        }
        return true;
    }
}
