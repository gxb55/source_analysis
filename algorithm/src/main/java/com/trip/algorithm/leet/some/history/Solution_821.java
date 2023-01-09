package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/4/19  9:36
 * @description 821
 * 821. 字符的最短距离
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 * <p>
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 * <p>
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "loveleetcode", c = "e"
 * 输出：[3,2,1,0,1,0,0,1,2,2,1,0]
 * 解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
 * 距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
 * 距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
 * 对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
 * 距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
 * 示例 2：
 * <p>
 * 输入：s = "aaab", c = "b"
 * 输出：[3,2,1,0]
 * <p>
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s[i] 和 c 均为小写英文字母
 * 题目数据保证 c 在 s 中至少出现一次
 */
public class Solution_821 {
    public static void main(String[] args) {
        Solution_821 solution_821 = new Solution_821();
        /*int[] ints = solution_821.shortestToChar("loveleetcode", 'e');
        System.out.println(Arrays.toString(ints));*/

       /* String s = solution_821.digitSum("233", 3);
        System.out.println(s);*/
        int[] tasks = {2,2,3,3,2,4,4,4,4,4};
        int i = solution_821.minimumRounds(tasks);
        System.out.println(i);
    }

    public int[] shortestToChar(String s, char c) {
        int length = s.length();
        int[] arr = new int[length];
        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            Character character = chars[i];
            if (character == c) {
                list.add(i);
            }
        }
        for (int i = 0; i < length; i++) {
            arr[i] = getVal(i, list);
        }
        return arr;
    }

    private int getVal(int i, List<Integer> list) {
        if (list.contains(i)) {
            return 0;
        }
        int min = -1;
        for (int index : list) {
            if (min == -1) {
                min = Math.abs(index - i);
            } else {
                min = Math.min(min, Math.abs(index - i));
            }
        }
        return min;
    }

    public String digitSum(String s, int k) {
        if (k >= s.length()) {
            return s;
        }
        while (true) {
            char[] chars = s.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            int sum = 0;
            int num = k;
            for (int i = 0; i < chars.length; i++) {
                num--;
                sum = sum + (chars[i] - '0');
                if (num == 0) {
                    stringBuilder.append(sum);
                    num = k;
                    sum = 0;
                }
            }
            if (chars.length % k != 0) {
                stringBuilder.append(sum);
            }

            s = stringBuilder.toString();
            if (stringBuilder.length() <= k) {
                break;
            }
        }
        return s;
    }

    public int minimumRounds(int[] tasks) {
        if (tasks.length < 2) {
            return -1;
        }
        if (tasks.length == 2) {
            return checkTwo(tasks, 0, 2) ? 1 : -1;
        }
        if (tasks.length == 3) {
            return checkTwo(tasks, 0, 3) ? 1 : -1;
        }

        Arrays.sort(tasks);
        return getResult(tasks, 0);
    }

    private int getResult(int[] tasks, int i) {
        if (i == tasks.length ) {
            return 0;
        }
        // 不符合要求的结果
        if (tasks.length - i < 2) {
            return Integer.MIN_VALUE;
        }
        int p2 = -1;
        int p3 = -1;
        if ((i + 2) < tasks.length && checkTwo(tasks, i, 3)) {
            p3 = getResult(tasks, i + 3) + 1;
        }
        if (p3 > 0) {
            return p3;
        }
        if ((i + 1) < tasks.length && checkTwo(tasks, i, 2)) {
            p2 = getResult(tasks, i + 2) + 1;
        }
        if (p2 > 0) {
            return p2;
        } else if (p3 > 0) {
            return p3;
        }
        return -1;
    }

    private boolean checkTwo(int[] tasks, int i, int len) {
        int val = tasks[i];
        for (int j = i + 1; j < i + len; j++) {
            if (val != tasks[j]) {
                return false;
            }
        }
        return true;
    }


}
