package com.trip.algorithm.leet.some;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2022年04月30日 18:39:00
 * 剑指 Offer II 035. 最小时间差
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 * <p> ["23:59","00:00"]
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= timePoints <= 2 * 104
 * timePoints[i] 格式为 "HH:MM"
 */
public class Leet_offer2_035 {
    public static void main(String[] args) {
        Leet_offer2_035 leet_offer2_035 = new Leet_offer2_035();
        List<String> list = List.of("05:31","22:08","00:35");
        int minDifference = leet_offer2_035.findMinDifference(list);
        System.out.println(minDifference);
    }

    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();
        for (String str : timePoints) {
            String[] split = str.split(":");
            int hours = Integer.parseInt(split[0].startsWith("0") ? split[0].substring(1) : split[0]);
            int sec = Integer.parseInt(split[1].startsWith("0") ? split[1].substring(1) : split[1]);
            int result = hours * 60 + sec;
            list.add(result);
            list.add(result+24 * 60);
        }
        List<Integer> collect = list.stream().sorted((x, y) -> y.compareTo(x)).collect(Collectors.toList());
        long min = Integer.MAX_VALUE;
        for (int i = 1; i < collect.size(); i++) {
            min = Math.min(min, collect.get(i-1) - collect.get(i ));
        }
        return (int) min;
    }
}
