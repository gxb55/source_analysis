package com.trip.algorithm.leet.some.leet2311;

/**
 * @author xbguo
 * @date 2023/11/16 10:00
 */
public class Solution2760 {
    public static void main(String[] args) {
        Solution2760 solution2760 = new Solution2760();
       /* int[] nums = {3, 2, 5, 4};
        int threshold = 5; */

       /* int[] nums = {2,3,4,5};
        int threshold = 4;
        */
       /* int[] nums = {8,4};
        int threshold = 6;*/

        int[] nums = {4, 10, 3};
        int threshold = 10;
        int i = solution2760.longestAlternatingSubarray(nums, threshold);
        System.out.println(i);
    }

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0 || nums[i] > threshold) {
                continue;
            }
            int j = i;
            while (j < nums.length) {
                int cur = nums[j];
                if (cur > threshold) {
                    break;
                }
                if (j != 0 && j != i) {
                    boolean b = nums[j] % 2 != nums[j - 1] % 2;
                    if (!b) {
                        break;
                    }
                }
                j++;
            }
            max = Math.max(max, j - i);
            i = j - 1;
        }
        return max;
    }
}
