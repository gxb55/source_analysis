package com.trip.algorithm.leet.some.history;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xbguo
 * @date 2022/6/10  10:57
 * @description 730
 * 给定一个字符串 s，返回 s 中不同的非空「回文子序列」个数 。
 * <p>
 * 通过从 s 中删除 0 个或多个字符来获得子序列。
 * <p>
 * 如果一个字符序列与它反转后的字符序列一致，那么它是「回文字符序列」。
 * <p>
 * 如果有某个 i , 满足 ai != bi ，则两个序列 a1, a2, ... 和 b1, b2, ... 不同。
 * <p>
 * 注意：
 * <p>
 * 结果可能很大，你需要对 109 + 7 取模 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = 'bccb'
 * 输出：6
 * 解释：6 个不同的非空回文子字符序列分别为：'b', 'c', 'bb', 'cc', 'bcb', 'bccb'。
 * 注意：'bcb' 虽然出现两次但仅计数一次。
 * 示例 2：
 * <p>
 * 输入：s = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
 * 输出：104860361
 * 解释：共有 3104860382 个不同的非空回文子序列，104860361 对 109 + 7 取模后的值。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s[i] 仅包含 'a', 'b', 'c' 或 'd' 
 * 通过次数7,903提交次数13,526
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-different-palindromic-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution730 {
    public static void main(String[] args) {
        Solution730 solution730 = new Solution730();
        //String s = "bccb";
        String s = "abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba";
        int i = solution730.countPalindromicSubsequences(s);
        System.out.println(i);
    }

    public int countPalindromicSubsequences(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        Set<String> set = new HashSet<>();
        Map<String, Set<String>> map = new HashMap<>();
        process(chars, stringBuilder, index, set, map);
        long l = set.size() % 1000000007;
        return (int) l;
    }


    private void process(char[] chars, StringBuilder stringBuilder, int index, Set<String> set, Map<String, Set<String>> map) {
        if (map.containsKey(stringBuilder.toString())) {
            return;
        }

        if (stringBuilder.length() > 0) {
            String s = stringBuilder.toString();
            String s1 = new StringBuilder(s).reverse().toString();
            if (s.equals(s1)) {
                set.add(stringBuilder.toString());
            }
        }

        for (int i = index; i < chars.length; i++) {
            char aChar = chars[i];
            stringBuilder.append(aChar);
            process(chars, stringBuilder, i + 1, set, map);
            map.put(stringBuilder.toString(), null);
            stringBuilder.setLength(stringBuilder.length() - 1);
        }

    }
}
