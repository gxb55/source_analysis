package com.trip.algorithm.leet.some;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author xbguo
 * @createTime 2022年03月27日 21:59:00
 * 456. 132 模式
 * 给你一个整数数组 nums ，数组中共有 n 个整数。
 * 132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
 * 并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * <p>
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * 示例 3：
 * <p>
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 */
public class Leet_456 {
    public static void main(String[] args) {
       // int[] arr = {3, 5, 0, 3, 4};
        int[] arr = {-2,1,-2};
        Leet_456 leet = new Leet_456();
        boolean pattern = leet.find132pattern(arr);
        System.out.println(pattern);
    }

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        // 单调栈 栈顶 - 栈底  大 - 小
        LinkedList<Integer> list = new LinkedList<>();
        TreeMap<Integer, Integer> set = new TreeMap<>();
        for (int j = 0; j < nums.length; j++) {
            int t = nums[j];
            Integer integer = set.get(t);
            if (integer == null) {
                integer = 0;
            }
            integer++;
            set.put(t, integer);
        }
        for (int j = 0; j < nums.length; j++) {
            int i = nums[j];
            while (!list.isEmpty() && list.peekLast() > i) {
                if (list.size() >= 2 && i > list.get(0)) {
                    return true;
                }
                if (list.size() >= 2) {
                    Integer integer = set.ceilingKey(list.get(0)+1);
                    if(integer!=null&& integer<list.peekLast() ){
                        return true;
                    }
                }
                list.pollLast();
            }
            list.addLast(i);
            Integer integer = set.get(i);
            integer--;
            if (integer == 0) {
                set.remove(i);
            } else {
                set.put(i, integer);
            }
        }
        return false;
    }
}
