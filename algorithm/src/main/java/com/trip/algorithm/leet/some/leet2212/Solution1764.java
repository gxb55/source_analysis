package com.trip.algorithm.leet.some.leet2212;

/**
 * @author xbguo
 * @createTime 2022年12月17日 19:27:00
 */
public class Solution1764 {
    public static void main(String[] args) {
        Solution1764 solution1764 = new Solution1764();
       /* int[][] groups = {{1, -1, -1}, {3, -2, 0}};
        int[] nums = {1, -1, 0, 1, -1, -1, 3, -2, 0};*/

      /*  int[][] groups = {{10, -2}, {1, 2, 3, 4}};
        int[] nums = {1, 2, 3, 4, 10, -2};*/

      /*  int[][] groups = {{1, 2, 3}, {3, 4}};
        int[] nums = {7, 7, 1, 2, 3, 4, 7, 7};*/

      /*  int[][] groups = {{-5,0}};
        int[] nums =  {2,0,-2,5,-1,2,4,3,4,-5,-5};*/

        int[][] groups = {{1,2}};
        int[] nums =  {1,3,2};
        boolean b = solution1764.canChoose(groups, nums);
        System.out.println(b);
    }

    public boolean canChoose(int[][] groups, int[] nums) {
        int index = 0;
        for (int i = 0; i < groups.length; i++) {
            index = check(groups[i], nums, index);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    private int check(int[] group, int[] nums, int index) {
        for (; index < nums.length; index++) {
            if (nums[index] == group[0]) {
                int curIndex = index;
                int i = 0;
                for (; i < group.length&&curIndex<nums.length; i++, curIndex++) {
                    if (nums[curIndex] != group[i]) {
                        break;
                    }
                }
                if (i == group.length) {
                    return curIndex;
                }
            }
        }
        return -1;
    }
}
