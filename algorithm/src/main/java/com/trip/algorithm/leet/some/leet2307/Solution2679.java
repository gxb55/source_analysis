package com.trip.algorithm.leet.some.leet2307;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年07月04日 22:28:00
 */
public class Solution2679 {
    public static void main(String[] args) {
        Solution2679 solution2679 = new Solution2679();
        //int[][] nums = {{7,2,1},{6,4,2},{6,5,3},{3,2,1}};
        int[][] nums = {{1}};
        int i = solution2679.matrixSum(nums);
        System.out.println(i);
    }

    public int matrixSum(int[][] nums) {
        int length = nums[0].length;
        List<LinkedList<Integer>> list = new ArrayList<>();
        for (int[] a : nums) {
            Arrays.sort(a);
            LinkedList list1 = new LinkedList();
            for (int x : a) {
                list1.add(x);
            }
            list.add(list1);
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int cur = 0;
            for (int j = 0; j < list.size(); j++) {
                Integer integer1 = list.get(j).pollLast();
                cur = Math.max(integer1, cur);
            }
            sum += cur;
        }
        return sum;
    }
}
