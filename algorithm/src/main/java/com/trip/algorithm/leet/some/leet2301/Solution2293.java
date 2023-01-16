package com.trip.algorithm.leet.some.leet2301;

/**
 * @author xbguo
 * @createTime 2023年01月15日 11:33:00
 */
public class Solution2293 {
    public static void main(String[] args) {
        Solution2293 solution2293 = new Solution2293();
       // int[] nums = {1, 3, 5, 2, 4, 8, 2, 2};
        int[] nums = { 2};
        int i = solution2293.minMaxGame(nums);
        System.out.println(i);
    }

    /**
     * 对于满足 0 <= i < n / 2 的每个 偶数 下标 i ，将 newNums[i] 赋值 为 min(nums[2 * i], nums[2 * i + 1]) 。
     * 对于满足 0 <= i < n / 2 的每个 奇数 下标 i ，将 newNums[i] 赋值 为 max(nums[2 * i], nums[2 * i + 1])
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/min-max-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int minMaxGame(int[] nums) {
        int len = nums.length;
        while (len > 1) {
            int[] temp = new int[len / 2];
            for (int i = 0; i < temp.length; i++) {
                if (i % 2 == 0) {
                    temp[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    temp[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            len = temp.length;
            nums = temp;
        }
        return nums[0];
    }
}
