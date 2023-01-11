package com.trip.algorithm.leet.some.leet08;

/**
 * @author xbguo
 * @date 2022/8/8  16:32
 * @description Solution637
 */
public class Solution647 {
    public static void main(String[] args) {
        Solution647 solution647 = new Solution647();
        String str = "aaa";
        int i = solution647.countSubstrings2(str);
        System.out.println(i);
    }

    public int countSubstrings2(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < dp.length; j++) {
                // 当前元素自身
                if ((j - i) == 0) {
                    dp[i][j] = true;
                    //当前元素和右边元素
                } else if ((j - i) == 1) {
                    if (chars[i] == chars[j]) {
                        dp[i][j] = true;
                    }
                    // 如果 dp[i][j]要为true，则 chars[i] == chars[j] && dp[i + 1][j - 1] 即 边界元素相等，中间也是回文
                } else if (chars[i] == chars[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                } else {
                    break;
                }
                if (dp[i][j]) {
                    sum++;
                }
            }
        }
        return sum;
    }


    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= 1; j++) {
                int l = i;
                int r = i + j;
                while (l >= 0 && r < len && chars[l] == chars[r]) {
                    l--;
                    r++;
                    sum++;
                }
            }
        }
        return sum;
    }

    public int countSubstrings1(String s) {
        int ans = 0;
        int n = s.length();
        //dp[i][j]标识i~j序列是否为回文串
        //dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j)，依赖于dp矩阵中下一行左一列的结果
        //因此从下往上，从左往右进行遍历
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; --i) {
            //i<=j才是合法子串范围
            for (int j = i; j < n; ++j) {
                if (s.charAt(j) == s.charAt(i)) {
                    //i~j长度为1必为回文，长度为2时i、j位置字符相等即回文
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    ++ans;
                }
            }
        }
        return ans;
    }

}
