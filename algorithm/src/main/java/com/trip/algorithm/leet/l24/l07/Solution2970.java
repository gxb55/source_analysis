package com.trip.algorithm.leet.l24.l07;

import java.util.ArrayList;
import java.util.List;

public class Solution2970 {
    public static void main(String[] args) {

    }

    public int incremovableSubarrayCount(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (check(i, j, nums)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean check(int x, int y, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= x && i <= y) {
                continue;
            }
            list.add(nums[i]);
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                return false;
            }
        }
        return true;
    }
}
