package com.trip.algorithm.leet.some.leet2209;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年09月26日 21:13:00
 * <p>
 * 面试题 17.19. 消失的两个数字
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * <p>
 * 以任意顺序返回这两个数字均可。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1]
 * 输出: [2,3]
 * 示例 2:
 * <p>
 * 输入: [2,3]
 * 输出: [1,4]
 * 提示：
 * <p>
 * nums.length <= 30000
 * 通过次数32,004提交次数53,160
 */
public class Solution17_19 {
    public int[] missingTwo(int[] nums) {

        int[] arr = new int[2];
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (i == 0) {
                int cur = 1;
                while (val > cur) {
                    arr[index] = cur;
                    cur++;
                    index++;
                }
            } else {
                int last = nums[i - 1]+1;
                while (val != last) {
                    arr[index] = last;
                    last++;
                    index++;
                }
            }
        }
        if (index < 2) {
            int val = nums[nums.length - 1];
            while (index < 2) {
                arr[index] = val + 1;
                val++;
                index++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution17_19 solution17_19 = new Solution17_19();
       // int[] arr ={1};
       // int[] arr = {2, 3};
        int[] arr = {1, 2, 3, 4, 6, 7, 9, 10};
        int[] ints = solution17_19.missingTwo1(arr);
        System.out.println(Arrays.toString(ints));
    }

    public int[] missingTwo1(int[] nums) {
        int[] ext = new int[2];
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i])-1;
            if(abs >= nums.length){
                ext[abs-nums.length] = -1;
            }else {
                nums[abs] = -nums[abs];
            }
        }

        int id = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                ans[id++] = i+1;
            }
        }

        for (int i = 0; i < 2; i++) {
            if(ext[i] >= 0){
                ans[id++] = i+nums.length+1;
            }
        }
        return ans;


    }
}
