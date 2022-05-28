package com.trip.algorithm.leet.some;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2022年04月05日 17:59:00
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * 通过次数492,040提交次数1,165,710
 */
public class Leet_34 {
    public static void main(String[] args) {

        Leet_34 leet_34 = new Leet_34();
        int[] arr = {7, 7, 7, 8, 8, 10};
        int[] ints = leet_34.searchRange(arr, 7);
        System.out.println(Arrays.toString(ints));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{};
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int val = nums[mid];
            if (target > val) {
                left = mid + 1;
            } else if (target < val) {
                right = mid - 1;
            } else {
                left = mid;
                break;
            }
        }
        List<Integer> list = new ArrayList<>();
        if (nums[left] == target) {
            for (int i = left; i < nums.length; i++) {
                if (nums[i] == target) {
                    list.add(i);
                }
                if (nums[i] > target) {
                    break;
                }
            }
            for (int i = left - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    list.add(i);
                }
                if (nums[i] > target) {
                    break;
                }
            }
        }
        if (list.size() == 0) {
            return new int[]{-1, -1};
        }
        if (list.size() == 1) {
            list.add(list.get(0));
        }
        List<Integer> collect = list.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        int[] result = new int[2];
        result[0] = collect.get(0);
        result[1] = collect.get(collect.size() - 1);
        return result;
    }
}
