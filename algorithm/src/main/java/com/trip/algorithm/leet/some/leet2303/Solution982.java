package com.trip.algorithm.leet.some.leet2303;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年03月04日 16:54:00
 * 982. 按位与为零的三元组
 * 给你一个整数数组 nums ，返回其中 按位与三元组 的数目。
 * <p>
 * 按位与三元组 是由下标 (i, j, k) 组成的三元组，并满足下述全部条件：
 * <p>
 * 0 <= i < nums.length
 * 0 <= j < nums.length
 * 0 <= k < nums.length
 * nums[i] & nums[j] & nums[k] == 0 ，其中 & 表示按位与运算符。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,3]
 * 输出：12
 * 解释：可以选出如下 i, j, k 三元组：
 * (i=0, j=0, k=1) : 2 & 2 & 1
 * (i=0, j=1, k=0) : 2 & 1 & 2
 * (i=0, j=1, k=1) : 2 & 1 & 1
 * (i=0, j=1, k=2) : 2 & 1 & 3
 * (i=0, j=2, k=1) : 2 & 3 & 1
 * (i=1, j=0, k=0) : 1 & 2 & 2
 * (i=1, j=0, k=1) : 1 & 2 & 1
 * (i=1, j=0, k=2) : 1 & 2 & 3
 * (i=1, j=1, k=0) : 1 & 1 & 2
 * (i=1, j=2, k=0) : 1 & 3 & 2
 * (i=2, j=0, k=1) : 3 & 2 & 1
 * (i=2, j=1, k=0) : 3 & 1 & 2
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：27
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] < 216
 * 通过次数8,875提交次数13,767
 */
public class Solution982 {
    public static void main(String[] args) {
        Solution982 solution982 = new Solution982();
        int[] nums = {2, 1, 3};
        //int[] nums = {0, 0, 0};
        int i = solution982.countTriplets1(nums);
        System.out.println(i);
    }

    public int countTriplets1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            for (int y : nums) {
                int z = x & y;
                Integer integer = map.get(z);
                if (integer != null) {
                    map.put(z, integer + 1);
                } else {
                    map.put(z, 1);
                }
            }
        }
        int count = 0;
        for (int x : nums) {
            for (Map.Entry<Integer, Integer> t : map.entrySet()) {
                if ((t.getKey() & x) == 0) {
                    count += t.getValue();
                }
            }

        }
        return count;
    }


    public int countTriplets(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        process(nums, list, 0);
        return count;
    }

    int count = 0;

    private void process(int[] nums, LinkedList<Integer> list, int index) {
        if (list.size() == 3) {
            int i = list.get(0) & list.get(1) & list.get(2);
            if (i == 0) {
                count++;
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            list.add(val);
            process(nums, list, i);
            list.pollLast();
        }
    }
}
