package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2021/11/23  16:35
 * @description 三数之和
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * 通过次数710,605提交次数2,095,079
 */
public class Solution1123l2 {
    public static void main(String[] args) {
        Solution1123l2 solution1123l2 = new Solution1123l2();
        //int[] arr = {-1, 0, 1, 2, -1, -4};
        int[] arr = {0,0,0,0};
        List<List<Integer>> lists = solution1123l2.threeSum(arr);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[l]);
                    tempList.add(nums[r]);
                    tempList.sort(Integer::compareTo);
                    if (!list.contains(tempList)){
                        list.add(tempList);
                    }
                }
                if (sum > 0) {
                    int r0 = r;
                    if (r > l) {
                        r0--;
                    }
                    r = r0;
                } else {
                    int l0 = l;
                    if (r > l) {
                        l0++;
                    }
                    l = l0;
                }
            }
        }
        return list;
    }
}
