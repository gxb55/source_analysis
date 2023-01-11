package com.trip.algorithm.leet.some.leet10;

import java.util.Arrays;

/**
 * @auther: xbguo
 * @date: 2022/10/24 11:17
 * @description: Solution915
 * 输入：nums = [5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-array-into-disjoint-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution915 {
    public static void main(String[] args) {
        Solution915 solution915 = new Solution915();
       // int[] arr = {5, 0, 3, 8, 6};
     //  int[] arr = {1,1,1,1,1,1};
     //  int[] arr = {1,1,1,0,6,12};
       int[] arr = {32,57,24,19,0,24,49,67,87,87};
      // int[] arr = {26,51,40,58,42,76,30,48,79,91};
        int i = solution915.partitionDisjoint1(arr);
        System.out.println(i);
    }

    public int partitionDisjoint(int[] nums) {
        int leftIndex = -1;
        int rightIndex = -1;
        int leftMax = -1;
        int rightMin = -1;
        while (true) {
            if (leftIndex == (rightIndex-1) && leftIndex != -1) {
                break;
            }
            if (leftIndex == -1) {
                leftIndex = 0;
                leftMax = nums[leftIndex];
                rightIndex = nums.length - 1;
                rightMin = nums[rightIndex];
            } else {
                rightIndex--;
                rightMin = Arrays.stream(nums).skip(rightIndex+1).min().getAsInt();
                if (rightMin >= leftMax) {

                } else {
                    leftIndex++;
                    rightIndex++;
                    leftMax = Math.max(leftMax, nums[leftIndex]);
                }
            }
        }
        while (leftIndex>=1){
            leftIndex--;
            int max = Arrays.stream(nums).limit(leftIndex+1).max().getAsInt();
            int min = Arrays.stream(nums).skip(leftIndex+1).min().getAsInt();
            if(min<max){
                leftIndex++;
                return leftIndex+1;
            }
        }
        return leftIndex+1;

    }

    public int partitionDisjoint1(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int leftMax = A[0];
        int max = A[0];
        int index = 0;

        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            if(A[i] < leftMax) {
                leftMax = max;
                index = i;
            }
        }

        return index + 1;
    }

        public int partitionDisjoint2(int[] nums) {
            int n = nums.length;
            int[] minRight = new int[n];
            minRight[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                minRight[i] = Math.min(nums[i], minRight[i + 1]);
            }

            int maxLeft = 0;
            for (int i = 0; i < n - 1; i++) {
                maxLeft = Math.max(maxLeft, nums[i]);
                if (maxLeft <= minRight[i + 1]) {
                    return i + 1;
                }
            }
            return n - 1;
        }

}
