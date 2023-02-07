package com.trip.algorithm.codethink.greedyalgorithm;

/**
 * @author xbguo
 * @date 2023/2/6 10:29
 * 示例 1：
 * <p>
 * 输入：nums = {1,7,4,9,2,5}
 * 输出：6
 * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
 * 示例 2：
 * <p>
 * 输入：nums = {1,17,5,10,13,15,10,5,16,8}
 * 输出：7
 * 解释：这个序列包含几个长度为 7 摆动序列。
 * 其中一个是 {1, 17, 10, 13, 10, 16, 8} ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
 * 示例 3：
 * <p>
 * 输入：nums = {1,2,3,4,5,6,7,8,9}
 * 输出：2
 */
public class Solution376 {
    public static void main(String[] args) {
           int[] nums = {1, 7, 4, 9, 2, 5};
        //    int[] nums = {1,17,5,10,13,15,10,5,16,8};
        //  int[] nums = {1,2,3,4,5,6,7,8,9};
       // int[] nums = {0, 0};
        int i = Solution376.wiggleMaxLength1(nums);
        System.out.println(i);
    }

    public static int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[2][len];
        dp[0][0] = dp[1][0] = 1;
        //0 up ;1 down
        for (int i = 1; i < nums.length; i++) {
            int res = nums[i] - nums[i - 1];
            if (res > 0) {
                dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + 1);
            } else if (res < 0) {
                dp[1][i] = Math.max(dp[0][i - 1] + 1, dp[1][i - 1]);
            } else {
                dp[0][i] = dp[0][i - 1];
                dp[1][i] = dp[1][i - 1];
            }
        }
        return Math.max(dp[0][len-1],dp[1][len-1]);
    }

    public static int wiggleMaxLength1(int[] nums) {
        int lastDif=0;
        int count=1;
        for (int i = 1; i < nums.length; i++) {
            int cur=nums[i]-nums[i-1];
            if((cur>0&&lastDif<=0)||(cur<0&&lastDif>=0)){
                count++;
                lastDif=cur;
            }
        }
        return count;
    }
}
