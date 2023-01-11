package com.trip.algorithm.leet.some.leet12;

import java.util.*;

/**
 * @author xbguo
 * @date 2022/12/29 09:34
 * @description 2032
 * 2032. 至少在两个数组中出现的值
 * 给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按 任意 顺序排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
 * 输出：[3,2]
 * 解释：至少在两个数组中出现的所有值为：
 * - 3 ，在全部三个数组中都出现过。
 * - 2 ，在数组 nums1 和 nums2 中出现过。
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
 * 输出：[2,3,1]
 * 解释：至少在两个数组中出现的所有值为：
 * - 2 ，在数组 nums2 和 nums3 中出现过。
 * - 3 ，在数组 nums1 和 nums2 中出现过。
 * - 1 ，在数组 nums1 和 nums3 中出现过。
 * 示例 3：
 * <p>
 * 输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
 * 输出：[]
 * 解释：不存在至少在两个数组中出现的值。
 */
public class Solution2032 {
    public static void main(String[] args) {
        Solution2032 solution2032 = new Solution2032();
        int[] nums1 = {1, 1, 3, 2}, nums2 = {2, 3}, nums3 = {3};
        List<Integer> list = solution2032.twoOutOfThree(nums1, nums2, nums3);
        System.out.println(list);
    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums1).distinct().forEach(x -> {
            set.add(x);
        });
        Arrays.stream(nums2).distinct().forEach(x -> {
            if (!set.add(x)) {
                list.add(x);
            }
        });
        Arrays.stream(nums3).distinct().forEach(x -> {
            if (!set.add(x) && !list.contains(x)) {
                list.add(x);
            }
        });
        return list;
    }
}
