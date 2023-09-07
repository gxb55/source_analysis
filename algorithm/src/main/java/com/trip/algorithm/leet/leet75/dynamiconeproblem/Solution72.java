package com.trip.algorithm.leet.leet75.dynamiconeproblem;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author xbguo
 * @createTime 2023年09月07日 21:49:00
 */
public class Solution72 {
    public static void main(String[] args) {
        Solution72 solution72 = new Solution72();
      //  String word1 = "ros", word2 = "horse";
         String word1 = "intention", word2 = "execution";
        // String word1 = "a", word2 = "ab";
        int i = solution72.minDistance(word1, word2);
        System.out.println(i);
    }

    /**
     * word1 转换成 word2
     *
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word2.equals(word1)) {
            return 0;
        }
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        int[][] dp = new int[word2.length()][word1.length()];
        dp[0][0] = (word1.charAt(0) == word2.charAt(0)) ? 0 : 1;
        for (int i = 1; i < word1.length(); i++) {
            boolean b = word1.charAt(i) == word2.charAt(0);
            int change = b ? 0 : 1;
            // 删除自己
            int p1 = 1 + dp[0][i - 1];
            // 改变自己
            int p2 = change + dp[0][i - 1];
            dp[0][i] = Math.min(p1, p2);
        }
        for (int i = 1; i < word2.length(); i++) {
            boolean b = word1.charAt(0) == word2.charAt(i);
            // 自己+1
            int p1 = dp[i - 1][0] + 1;
            int change = b ? 0 : 1;
            // 自己对上了，其他的增加
            int p2 = change + i;
            dp[i][0] = Math.min(p1, p2);
        }
        // word2 长度
        for (int i = 1; i < dp.length; i++) {
            // word1 长度;因为word2长度不能变，所以word1的长度必须大于word2
            for (int j = 1; j < dp[i].length; j++) {
                boolean b = word1.charAt(j) == word2.charAt(i);
                int change = b ? 0 : 1;
                int c = 0;
                // 删除自己
                int p1 = 1 + dp[i ][j- 1];
                // 改变自己
                int p2 = change + dp[i - 1][j - 1];
                if (i == dp.length - 1) {
                    if (j >= i) {
                        c = dp[i].length - j;
                    } else {
                        //需要增加的情况
                        //c = dp.length - j;
                    }

                }
                dp[i][j] = Math.min(p1, p2) + c;
            }
        }
        int length = word2.length();
        int integer = Integer.MAX_VALUE;
        for (int i = 0; i < word1.length(); i++) {
            integer = Math.min(dp[length - 1][i], integer);
        }
        return integer;
    }

    private int process(char[] chars1, char[] chars2, int index1, int index2) {
        if (index2 >= chars2.length) {
            return chars1.length - index1 - 1;
        }
        if (index1 >= chars1.length) {
            return -1;
        }
        int p1 = -1;
        int p2 = -1;
        int p3 = -1;
        // 直接往后走
        if (chars1[index1] == chars2[index2]) {
            p1 = process(chars1, chars2, index1 + 1, index2 + 1);
        }
        // 替换一个，需要付出一个的代价
        p2 = process(chars1, chars2, index1 + 1, index2 + 1) + 1;
        // 删除其中一个
        p3 = process(chars1, chars2, index1 + 1, index2) + 1;
        List<Integer> list = Arrays.asList(p3, p2, p1);
        Optional<Integer> min = list.stream().filter(x -> x != -1).min(Integer::compareTo);
        if (min.isPresent()) {
            return min.get();
        }
        return -1;
    }


}
