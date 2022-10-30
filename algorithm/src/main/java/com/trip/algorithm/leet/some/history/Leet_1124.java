package com.trip.algorithm.leet.some.history;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @version 1.0.0
 * @ClassName Leet_1124.java
 * @createTime 2022年03月26日 17:02:00
 * <p>
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
 * 通过次数14,991提交次数45,597
 */
public class Leet_1124 {
    public static void main(String[] args) {
        Leet_1124 leet_1124 = new Leet_1124();
         int[] arr = {9, 9, 6, 0, 6, 6, 9};
        //int[] arr = {6, 6, 9};
        int i = leet_1124.longestWPI(arr);
        System.out.println(i);
    }

    public int longestWPI(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < hours.length; i++) {
            int hour = hours[i];
            if (hour > 8) {
                sum++;
            } else {
                sum--;
            }

            if (sum > 0) {
                max = i + 1;
            } else {
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }

                if (map.containsKey(sum - 1)) {
                    max = Math.max((i - map.get(sum - 1)), max);
                }
            }
        }
        return max;
    }
}

