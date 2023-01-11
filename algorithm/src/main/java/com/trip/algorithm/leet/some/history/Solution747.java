package com.trip.algorithm.leet.some.history;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2022/1/13  17:26
 * @description 至少是其他数字两倍的最大数
 * <p>
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * <p>
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：4 没有超过 3 的两倍大，所以返回 -1 。
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * 解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * nums 中的最大元素是唯一的
 * 通过次数67,947提交次数150,830
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution747 {
    public static void main(String[] args) {
        int[] arr = {3,6,1,0};
        Solution747 solution747 = new Solution747();
        int i = solution747.dominantIndex(arr);
        System.out.println(i);
    }

    public int dominantIndex(int[] nums) {
        if (nums == null ) {
            return -1;
        }
        if(nums.length==1){
            return 1;
        }

        int max = Arrays.stream(nums).max().getAsInt();

        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if(max==val){
                index=i;
            }else{
                if(val*2>max){
                    return -1;
                }
            }
        }
        return index;
    }
}
