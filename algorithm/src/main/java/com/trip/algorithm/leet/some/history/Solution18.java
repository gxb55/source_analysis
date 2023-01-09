package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/2/16  14:57
 * @description 四数之和
 * <p>
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 通过次数264,857提交次数670,735
 */
public class Solution18 {
    public static void main(String[] args) {
        Solution18 solution = new Solution18();
        int[] arr ={2,2,2,2,2};
        int target = 8;
        List<List<Integer>> list = solution.fourSum(arr, target);
        list.stream().forEach(x->{
            System.out.println(x);
        });
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int res = target - nums[i] - nums[j];
                int left = j + 1;
                int right = length - 1;
                while (right > left) {
                    int curTotal = nums[left] + nums[right];
                    if (curTotal == res) {
                        List<Integer> curList = new ArrayList<Integer>();
                        curList.add(nums[i]);
                        curList.add(nums[j]);
                        curList.add(nums[left]);
                        curList.add(nums[right]);
                        curList.sort(Comparator.comparingInt(o -> o));
                        if (!list.contains(curList)) {
                            list.add(curList);
                        }
                        right--;
                        left++;
                    } else if (curTotal > res) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return list;
    }
}
