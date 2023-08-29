package com.trip.algorithm.leet.leet75.prefixandproblem;

/**
 * @author xbguo
 * @createTime 2023年08月27日 16:35:00
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * 示例 2：
 *
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * 示例 3：
 *
 * 输入：nums = [2, 1, -1]
 * 输出：0
 */
public class Solution724 {
    public static void main(String[] args) {
        int[] nums = {2, 1, -1};
        int i = Solution724.pivotIndex(nums);
        System.out.println(i);
    }
    public static int pivotIndex(int[] nums) {
        int length = nums.length;
        int[] right=new int[length];
        int sum=0;
        for (int i = length-1; i >=0; i--) {
            sum+=nums[i];
            right[i]=sum;
        }

        sum=0;
        for (int i = 0; i < length; i++) {
            if((i+1)<length&&sum==right[i+1]){
                return i;
            }
            if((i+1)==length&&sum==0){
                return i;
            }
            sum+=nums[i];
        }
        return -1;
    }
}
