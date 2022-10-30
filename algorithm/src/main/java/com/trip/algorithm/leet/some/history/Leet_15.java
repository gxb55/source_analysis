package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年04月05日 11:18:00
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
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
 * 通过次数895,060提交次数2,554,625
 */
public class Leet_15 {
    public static void main(String[] args) {
        int[] nums = {34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15, 21, -43, 57, -6, 86, 56, 94, 74, 83, -14, 28, -66, 46, -49, 62, -11, 43, 65, 77, 12, 47, 61, 26, 1, 13, 29, 55, -82, 76, 26, 15, -29, 36, -29, 10, -70, 69, 17, 49};
        Leet_15 leet_15 = new Leet_15();
        List<List<Integer>> list = leet_15.threeSum(nums);
        for (List<Integer> list1 : list) {
            System.out.println(list1);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int index = 0;
        process(nums, index, tempList, result);
        return result;
    }

    private void process(int[] nums, int index, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == 3) {
            int sum = 0;
            for (Integer integer : tempList) {
                sum += integer;
            }
            if (sum == 0) {
                result.add(new ArrayList<>(tempList));
            }
            return;
        }
        if (index >= nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i == index && nums[index] > 0 && tempList.size() == 0) {
                break;
            }
            // 本层重复的调过
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            int val = nums[i];
            tempList.add(val);
            process(nums, i + 1, tempList, result);
            tempList.remove(Integer.valueOf(val));
        }
    }



}
