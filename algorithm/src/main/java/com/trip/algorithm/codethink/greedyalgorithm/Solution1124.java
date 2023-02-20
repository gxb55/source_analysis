package com.trip.algorithm.codethink.greedyalgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/2/14 10:01
 * @description 1124
 * 1124. 表现良好的最长时间段
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * <p>
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * <p>
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * <p>
 * 请你返回「表现良好时间段」的最大长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * 示例 2：
 * <p>
 * 输入：hours = [6,6,6]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= hours.length <= 104
 * 0 <= hours[i] <= 16
 * 通过次数23,482提交次数65,750
 */
public class Solution1124 {
    public static void main(String[] args) {
        int[] hours = {9, 9, 6, 0, 6, 6, 9};
        hours = new int[]{6, 9, 9};
         hours = new int[]{16,15,11,2,9,3};
        int i = Solution1124.longestWPI(hours);
        System.out.println(i);
    }

    public static int longestWPI(int[] hours) {
        int len = hours.length;
        int sum = 0;
        int cur = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            cur = cur + (hours[i] > 8 ? 1 : -1);
            sum = Math.max(sum, cur);
            if (cur > 0) {
                sum = Math.max(sum, i + 1);
            }
            if (!map.containsKey(cur)) {
                map.put(cur, i);
            }
            Integer integer = map.get(cur - 1);
            if (integer != null) {
                sum = Math.max(sum, (i - integer));
            }
        }
        return sum;
    }
}
