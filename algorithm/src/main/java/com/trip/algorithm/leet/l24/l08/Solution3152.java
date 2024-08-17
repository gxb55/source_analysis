package com.trip.algorithm.leet.l24.l08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/8/14 16:14
 */
public class Solution3152 {
    public static void main(String[] args) {

    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int begin = queries[i][0];
            int end = queries[i][1];
            if (list.stream().anyMatch(x -> begin >= x[0] && end <= x[1])) {
                res[i] = true;
                continue;
            }
            boolean check = check(nums, begin, end);
            if (check) {
                list.add(new int[]{begin, end});
            }
            res[i] = check;
        }
        return res;
    }

    private boolean check(int[] nums, int begin, int end) {
        boolean flag = nums[begin] % 2 == 0 ? true : false;
        for (int i = begin + 1; i <= end; i++) {
            boolean flag1 = nums[i] % 2 == 0 ? true : false;
            if (!flag != flag1) {
                return false;
            }
            flag = flag1;
        }
        return true;
    }
}
