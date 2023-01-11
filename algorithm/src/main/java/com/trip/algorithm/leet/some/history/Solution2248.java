package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/4/25  20:52
 * @description 2248
 * 给你一个二维整数数组 nums ，其中 nums[i] 是由 不同 正整数组成的一个非空数组，按 升序排列 返回一个数组，数组中的每个元素在 nums 所有数组 中都出现过。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
 * 输出：[3,4]
 * 解释：
 * nums[0] = [3,1,2,4,5]，nums[1] = [1,2,3,4]，nums[2] = [3,4,5,6]，在 nums 中每个数组中都出现的数字是 3 和 4 ，所以返回 [3,4] 。
 * 示例 2：
 * <p>
 * 输入：nums = [[1,2,3],[4,5,6]]
 * 输出：[]
 * 解释：
 * 不存在同时出现在 nums[0] 和 nums[1] 的整数，所以返回一个空列表 [] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= sum(nums[i].length) <= 1000
 * 1 <= nums[i][j] <= 1000
 * nums[i] 中的所有值 互不相同
 */
public class Solution2248 {
    public static void main(String[] args) {
        Solution2248 solution2248 = new Solution2248();
        int[][] arr = {{1,2,3},{4,5,6}};
        List<Integer> intersection = solution2248.intersection(arr);
        System.out.println(intersection);
    }

    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> cur = new HashMap<>();
            for (int j = 0; j < nums[i].length; j++) {
                int i1 = nums[i][j];
                if (!cur.containsKey(i1)) {
                    cur.put(i1, 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : cur.entrySet()) {
                if (map.containsKey(entry.getKey())) {
                    map.put(entry.getKey(), map.get(entry.getKey()) + 1);
                } else {
                    map.put(entry.getKey(), entry.getValue());
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == len) {
                list.add(entry.getKey());
            }
        }
        if (list.size() > 1) {
            return list.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        }
        return list;
    }
}
