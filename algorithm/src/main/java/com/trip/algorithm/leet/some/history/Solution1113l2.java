package com.trip.algorithm.leet.some.history;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xbguo 郭晓兵
 * @date 2020-11-13 16:43
 */
public class Solution1113l2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        getNums(arr);
        Solution1113l2 solution1113l2 = new Solution1113l2();
        int[] nums = {0,0,0};
        int i = solution1113l2.threeSumClosest(nums, 1);
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        System.out.println(i);
    }

    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * 示例：
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * <p>
     * 提示：
     * <p>
     * 3 <= nums.length <= 10^3
     * -10^3 <= nums[i] <= 10^3
     * -10^4 <= target <= 10^4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum-closest
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int threeSumClosest(int[] nums, int target) {
        int temp = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(Math.abs(target-temp)-Math.abs(target-sum)>0){
                        temp = target-sum;
                    }else{
                        temp = target-temp;
                    }
                }
            }
        }
        return temp;
    }
    public static void getNums(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.println(arr[i]+"_"+arr[j]);
            }
        }
    }

}
