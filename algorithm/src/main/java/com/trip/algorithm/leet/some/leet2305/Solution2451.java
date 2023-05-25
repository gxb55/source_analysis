package com.trip.algorithm.leet.some.leet2305;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/5/25 09:57
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["adc","wzy","abc"]
 * 输出："abc"
 * 解释：
 * - "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
 * - "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
 * - "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
 * 不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
 * 示例 2：
 * <p>
 * 输入：words = ["aaa","bob","ccc","ddd"]
 * 输出："bob"
 * 解释：除了 "bob" 的差值整数数组是 [13, -13] 以外，其他字符串的差值整数数组都是 [0, 0] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/odd-string-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2451 {
    public static void main(String[] args) {
        String[] words = {"adc", "wzy", "abc"};
        String s = oddString(words);
        System.out.println(s);
    }

    public static String oddString(String[] words) {
        int length = words.length;
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String word = words[i];
            stringBuilder.setLength(0);
            char[] chars = word.toCharArray();

            for (int j = 1; j < chars.length; j++) {
                stringBuilder.append(chars[j] - chars[j - 1]).append(",");
            }
            String s = stringBuilder.toString();
            list.add(s);
            if (list.size() >= 3 && list.stream().distinct().count() == 2) {
                Map<String, Integer> map = new HashMap<>();
                for (String s1 : list) {
                    int i1 = map.getOrDefault(s1, 0) + 1;
                    map.put(s1, i1);
                }
                String key = map.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey();
                return words[list.indexOf(key)];
            }
        }
        return "";
    }
}
