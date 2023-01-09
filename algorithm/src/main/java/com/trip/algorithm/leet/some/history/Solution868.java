package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/4/24  9:26
 * @description 868
 * 868. 二进制间距
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 * <p>
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 22
 * 输出：2
 * 解释：22 的二进制是 "10110" 。
 * 在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
 * 第一对相邻的 1 中，两个 1 之间的距离为 2 。
 * 第二对相邻的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 * 示例 2：
 * <p>
 * 输入：n = 8
 * 输出：0
 * 解释：8 的二进制是 "1000" 。
 * 在 8 的二进制表示中没有相邻的两个 1，所以返回 0 。
 * 示例 3：
 * <p>
 * 输入：n = 5
 * 输出：2
 * 解释：5 的二进制是 "101" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * 通过次数23,492提交次数35,683
 */
public class Solution868 {
    public static void main(String[] args) {
        Solution868 solution868 = new Solution868();
        int i = solution868.binaryGap(22);
        System.out.println(i);
    }

    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                list.add(i);
            }
        }
        if (list.size() <= 1) {
            return 0;
        } else {
            int max = -1;
            int last = -1;
            for (Integer integer : list) {
                if (last == -1) {
                    last = integer;
                } else {
                    max = Math.max(max, (integer - last));
                    last = integer;
                }
            }
            return max;
        }
    }
}
