package com.trip.algorithm.leet.some.leet2208;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2022年08月14日 10:10:00
 * 1422. 分割字符串的最大得分
 * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
 * <p>
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "011101"
 * 输出：5
 * 解释：
 * 将字符串 s 划分为两个非空子字符串的可行方案有：
 * 左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5
 * 左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4
 * 左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3
 * 左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2
 * 左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
 * 示例 2：
 * <p>
 * 输入：s = "00111"
 * 输出：5
 * 解释：当 左子字符串 = "00" 且 右子字符串 = "111" 时，我们得到最大得分 = 2 + 3 = 5
 * 示例 3：
 * <p>
 * 输入：s = "1111"
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 500
 * 字符串 s 仅由字符 '0' 和 '1' 组成。
 * 通过次数18,946提交次数33,858
 */
public class Solution1422 {
    public static void main(String[] args) {

    }

    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        int cur = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '0') {
                cur++;
            }
            map.put(i, cur);
        }
        cur = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            char aChar = chars[i];
            if (aChar == '1') {
                cur++;
            }
            map1.put(i, cur);
        }
        int max = Math.max(map.get(chars.length - 1), map1.get(0));
        for (int i = 1; i < chars.length; i++) {
            Integer integer = map.get(i - 1);
            Integer integer1 = map1.get(i);
            max = Math.max(max, integer + integer1);
        }
        return max;
    }

}
