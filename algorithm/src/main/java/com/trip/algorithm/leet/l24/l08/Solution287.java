package com.trip.algorithm.leet.l24.l08;

/**
 * @author xbguo
 * @date 2024/8/14 19:06
 */
public class Solution287 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 5, 5};
        int duplicate = findDuplicate(arr);
        System.out.println(duplicate);
    }

    public static int findDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int v1 = nums[i];
            if (v1 == (i + 1)) {
                continue;
            }
            while (nums[i] != (i + 1)) {
                if (nums[i] < (i + 1)) {
                    return nums[i];
                }
                int v = nums[i];
                int num = nums[v];
                if (v == num) {
                    return v;
                }
                nums[i] = num;
                nums[v] = v;
            }
        }
        return -1;
    }
}
