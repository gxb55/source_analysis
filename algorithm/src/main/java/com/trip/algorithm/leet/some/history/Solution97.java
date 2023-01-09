package com.trip.algorithm.leet.some.history;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/4/28  15:09
 * @description 97
 * 97. 交错字符串
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * <p>
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 * <p>
 * <p>
 * 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它?
 * <p>
 * 通过次数82,162提交次数181,976
 */
public class Solution97 {
    public static void main(String[] args) {
        Solution97 solution97 = new Solution97();
      /*  String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc"; */

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
/*
        String s1 = "";
        String s2 = "";
        String s3 = "";*/
        boolean interleave = solution97.isInterleave1(s1, s2, s3);
        System.out.println(interleave);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if ((s1.length() + s2.length()) != s3.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        build(chars, map);
        build(chars1, map);
        Map<Character, Integer> map1 = new HashMap<>();
        build(s3.toCharArray(), map1);
        if (map.size() != map1.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (!entry.getValue().equals(map1.get(entry.getKey()))) {
                return false;
            }
        }
        int index3 = 0;
        int index1 = 0;
        int index2 = 0;
        return process(s1, index1, s2, index2, s3, index3);
    }

    private boolean process(String s1, int index1, String s2, int index2, String s3, int index3) {
        if (index3 == s3.length() && index1 == s1.length() && s2.length() == index2) {
            return true;
        }
        boolean flag = false;
        boolean flag1 = false;
        if (index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)) {
            flag = process(s1, index1 + 1, s2, index2, s3, index3 + 1);
        }
        if (index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)) {
            flag1 = process(s1, index1, s2, index2 + 1, s3, index3 + 1);
        }
        return flag1 || flag;
    }

    private void build(char[] chars, Map<Character, Integer> map) {
        for (Character character : chars) {
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else {
                map.put(character, 1);
            }
        }
    }

    public boolean isInterleave1(String s1, String s2, String s3) {
        if ((s1.length() + s2.length()) != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < dp.length ; i++) {
            for (int j = 0; j < dp[i].length ; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }

            }
        }
        return dp[s1.length()][s2.length()];
    }

    private boolean process1(String s1, String s2, String s3, int index1, int index2, int index3) {
        if (index3 == s3.length()) {
            return true;
        }
        while (index3 < s3.length()) {
            char c = s3.charAt(index3);
            char b = 0;
            char a = 0;
            if (index1 < s1.length()) {
                a = s1.charAt(index1);
            }
            if (index2 < s2.length()) {
                b = s2.charAt(index2);
            }

            if (a == c && b == c) {
                boolean p1 = process1(s1, s2, s3, index1 + 1, index2, index3 + 1);
                boolean p2 = process1(s1, s2, s3, index1, index2 + 1, index3 + 1);
                return p1 || p2;
            } else if (a == c) {
                index1++;
                index3++;
            } else if (b == c) {
                index2++;
                index3++;
            } else {
                return false;
            }
        }
        return true;
    }

}
