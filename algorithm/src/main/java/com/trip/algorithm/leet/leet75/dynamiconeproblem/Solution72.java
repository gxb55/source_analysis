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
      //    String word1 = "ros", word2 = "horse";
         String word1 = "horse", word2 = "ros";
      //  String word1 = "intention", word2 = "execution";
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

        int[][] dp = new int[word2.length() + 1][word1.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            dp[i][0] = i;
        }
        // word2 长度
        for (int i = 1; i < dp.length; i++) {
            // word1 长度 word1 转换成 word2
            for (int j = 1; j < dp[i].length; j++) {
                boolean b = word1.charAt(j - 1) == word2.charAt(i - 1);
                int c = b ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + c);
            }
        }
        for (int[] d : dp) {
            System.out.println(Arrays.toString(d));
        }
        return dp[word2.length()][word1.length()];
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
