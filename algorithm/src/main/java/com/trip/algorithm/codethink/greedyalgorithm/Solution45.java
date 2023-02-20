package com.trip.algorithm.codethink.greedyalgorithm;

/**
 * @author xbguo
 * @date 2023/2/10 18:58
 * @description 45
 */
public class Solution45 {
    public static void main(String[] args) {
          int[] nums = {3, 5,1,1,1, 1, 1, 4};
        //int[] nums = {1, 2, 3};
        // int[] nums = {2,3,0,1,4};
        //  int[] nums = {2,1};
        int jump = jump1(nums);
        System.out.println(jump);
    }

    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int j = i;
            int index = i;
            int curMax = nums[i] + i;
            if (curMax >= nums.length-1) {
                break;
            }
            for (; j <= cur + i; j++) {
                if ((nums[j] + j) > curMax) {
                    index = j;
                    curMax = nums[j] + j;
                }
            }
            if (index != i) {
                i = index - 1;
            } else {
                i = curMax - 1;
            }
            count++;
        }
        return count;
    }

    public static int jump1(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃的次数
        int count=0;
        //当前的覆盖最大区域
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance,i+nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance>=nums.length-1){
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i==curDistance){
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
}
