package com.trip.algorithm.zuo.day0829;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 两个字符串最长子序列
 */

public class Code08_StrMax {
    public static void main(String[] args) {
        String str1 = "a31cd2ef345gh";
        String str2 = "aq123rs4t5yz";
       /* String str1 = "123";
        String str2 = "123";*/
        int max = maxLength(str1, str2);
        System.out.println(max);
        int dp = maxLengthDp(str1, str2);
        System.out.println(dp);
    }

    public static int maxLength(String str1, String str2) {
        if (StringUtils.isBlank(str1) || StringUtils.isBlank(str2)) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        process(str1, str2, 0, 0, list);
        return list.stream().max(Comparator.naturalOrder()).get();
    }

    /**
     * @param str1      第一个字符串
     * @param str2      第二个字符串
     * @param str1Index 第一个字符串现在的下标
     * @param str2Index 第二个字符串现在的下标
     * @param list
     * @return
     */
    public static int process(String str1, String str2, int str1Index, int str2Index, List<Integer> list) {
        // 长度达到了最长，结束了
        if (str1.length() == str1Index || str2.length() == str2Index) {
            return 0;
        }
        char[] chars = str1.toCharArray();
        char[] chars1 = str2.toCharArray();
        int res = 0;
        for (int i = str1Index; i < chars.length; i++) {
            for (int j = str2Index; j < chars1.length; j++) {
                if (chars[i] == chars1[j] && i >= str1Index && j >= str2Index) {
                    //在展开递归的时候，要判断当前的结果和子结果的最大值
                    res = Math.max((process(str1, str2, i + 1, j + 1, list) + 1), res);
                }
            }
            // 以每个字符开始的结果都会存在这个里面，最后输出最大的即可
            list.add(res);
        }
        return res;
    }

    /**
     * 动态规划 两个字符串最大子序列
     * 两个字符串之间来回操作，要想到二位表，没个下标代表一个字符，然后再根据题意判断整个流程中的具体操作
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int maxLengthDp(String str1, String str2) {
        if (StringUtils.isBlank(str1) || StringUtils.isBlank(str2)) {
            return 0;
        }
        return process1(str1, str2);
    }

    public static int process1(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        // 动态规划表先出来
        int dp[][] = new int[length1][length2];
        /**
         * 基本赋值，dp[0][i]
         * dp[0][0] = str1[0]  == str2[0]
         * dp[0][1] = Math.max(dp[0][0],str1[0]  == str2[1] ?1:0)
         */
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        dp[0][0] = chars1[0] == chars2[0] ? 1 : 0;
        for (int i = 1; i < length2; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], chars1[0] == chars2[i] ? 1 : 0);
        }
        for (int i = 1; i < length1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], chars2[0] == chars1[i] ? 1 : 0);
        }

        /**
         * 分四种情况
         * 1.chars1[i] != chars1[j]-> dp[i-1][j-1];   abc  aee ->ab ae
         * 2.chars1[i] == chars1[j]-> dp[i-1][j-1]+1; abc  acc -> abc acc
         * 3.chars1[i] == chars1[j-1]-> dp[i][j-1];   abc  acz -> abc ac -> z没有在abc中出现
         * 4.chars1[i-1] == chars1[j]-> dp[i-1][j];   ace  azc -> ac aze -> c没有子aze中出现
         */
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i-1][j-1];
                if(chars1[i] == chars2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }

            }
        }

        System.out.println("----------------");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]+"    ");
            }
            System.out.println();
        }
        System.out.println("----------------");
        return dp[length1-1][length2-1];
    }
}
