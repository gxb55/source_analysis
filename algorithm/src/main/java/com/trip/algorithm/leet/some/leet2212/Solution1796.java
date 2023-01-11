package com.trip.algorithm.leet.some.leet2212;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author xbguo
 * @createTime 2022年12月03日 09:54:00
 * 1796. 字符串中第二大的数字
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 * <p>
 * 混合字符串 由小写英文字母和数字组成。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "dfa12321afd"
 * 输出：2
 * 解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
 * 示例 2：
 * <p>
 * 输入：s = "abc1111"
 * 输出：-1
 * 解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 只包含小写英文字母和（或）数字。
 * 通过次数15,973提交次数31,029
 */
public class Solution1796 {
    public static void main(String[] args) {
        Solution1796 solution1796 = new Solution1796();
     //   String s = "dfa12321afd";
        String s = "abc1111";
        int i = solution1796.secondHighest(s);
        System.out.println(i);
    }

    public int secondHighest(String s) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        char[] chars = s.toCharArray();
        for (Character character : chars) {
            int i = character - '0';
            if (i >= 0 && i <= 9 && set.add(i)) {
                queue.add(i);
            }
        }
        if (queue.size() < 2) {
            return -1;
        }
        queue.poll();
        return queue.poll();
    }
}
