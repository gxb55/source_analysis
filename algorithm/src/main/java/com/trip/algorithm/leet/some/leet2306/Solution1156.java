package com.trip.algorithm.leet.some.leet2306;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年06月04日 18:41:00
 * 示例 1：
 * <p>
 * 输入：text = "ababa"
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：text = "aaabaaa"
 * 输出：6
 * 示例 3：
 * <p>
 * 输入：text = "aaabbaaa"
 * 输出：4
 * 示例 4：
 * <p>
 * 输入：text = "aaaaa"
 * 输出：5
 * 示例 5：
 * <p>
 * 输入：text = "abcdef"
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/swap-for-longest-repeated-character-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1156 {
    public static void main(String[] args) {
        // String text = "ababa";
        //  String text = "aaabaaa";
        // String text = "aaabbaaa";
        // String text = "aaaaa";
        // String text = "abcdef";
        String text = "babbaaabbbbbaa";
        int i = maxRepOpt1(text);
        System.out.println(i);
    }

    public static int maxRepOpt1(String text) {
        char[] chars = text.toCharArray();
        int[] dp = new int[text.length()];
        dp[0] = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(chars[0], 1);
        int max = 1;
        List<int[]> list = new ArrayList<>();

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                list.add(new int[]{i - dp[i - 1], dp[i - 1]});
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        list.add(new int[]{chars.length - dp[chars.length - 1], dp[chars.length - 1]});
        for (int i = 0; i < list.size(); i++) {
            int i1 = list.get(i)[1];
            if (map.get(chars[list.get(i)[0]]) > i1) {
                max = Math.max(i1 + 1, max);
            }
            for (int j = i + 2; j < list.size(); j++) {
                if (list.get(i + 1)[1] == 1) {
                    if (chars[list.get(i)[0]] == chars[list.get(j)[0]]) {
                        i1 = list.get(i)[1] + list.get(j)[1];
                        max = Math.max(i1, max);
                        if (map.get(chars[list.get(i)[0]]) > i1) {
                            max = Math.max(i1 + 1, max);
                        }
                    }
                }
                break;
            }
        }
        return max;
    }
}
