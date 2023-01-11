package com.trip.algorithm.leet.some.leet11;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: xbguo
 * @date: 2022/11/9 19:11
 * 面试题 16.18. 模式匹配
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 * 示例 2：
 * <p>
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 * 示例 3：
 * <p>
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 * 示例 4：
 * <p>
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 * 提示：
 * <p>
 * 1 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 * 通过次数17,183提交次数50,645
 */
public class Solution16_18 {
    public static void main(String[] args) {
        Solution16_18 solution16_18 = new Solution16_18();
        //    String pattern = "abba", value = "dogcatcatdog";
        //   String pattern = "abba", value = "dogcatcatfish";
        // String pattern = "abba", value = "dogdogdogdog";
        //  String pattern = "aaaa", value = "dogcatcatdog";
        //  String pattern = "abbaa", value = "dogdogdogdogdog";
        String pattern = "a", value = "";
        //  String pattern = "bbb", value = "xxxxxx";
        // String pattern = "bbbbbbbbbbbbbbabbbbb", value = "ppppppppppppppjsftcleifftfthiehjiheyqkhjfkyfckbtwbelfcgihlrfkrwireflijkjyppppg";
        //     String pattern = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", value = "p";

        boolean b = solution16_18.patternMatching(pattern, value);
        System.out.println(b);
    }

    public boolean patternMatching(String pattern, String value) {
        int aLen = 0;
        int bLen = 0;
        int firstA = -1;
        int firstB = -1;
        char[] chars = pattern.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];
            if (character == 'a') {
                if (firstA == -1) {
                    firstA = i;
                }
                aLen++;
            } else {
                if (firstB == -1) {
                    firstB = i;
                }
                bLen++;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        if (aLen == 0) {
            if ((value.length() % bLen) != 0) {
                return false;
            }
            map.put(0, value.length() / bLen);
        } else if (bLen == 0) {
            if ((value.length() % aLen) != 0) {
                return false;
            }
            map.put(value.length() / aLen, 0);
        } else {
            for (int i = 0; i <= value.length(); i++) {
                int len1 = i * aLen;
                if ((value.length() - len1) >= 0 && (value.length() - len1) % bLen == 0) {
                    map.put(i, (value.length() - len1) / bLen);
                }
            }
        }

        if (value.equals("")) {
            if (aLen == 0 || bLen == 0) {
                return true;
            } else {
                return false;
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value1 = entry.getValue();
            String a = "";
            String b = "";
            int index = 0;
            boolean flag = true;
            for (int i = 0; i < chars.length; i++) {
                char character = chars[i];
                if (character == 'a') {
                    String a1 = value.substring(index, index + key);
                    index = index + key;
                    if (a.equals("")) {
                        a = a1;
                    } else {
                        if (!a.equals(a1) || a.equals(b)) {
                            flag = false;
                            break;
                        }
                    }
                } else {
                    String b1 = value.substring(index, index + value1);
                    index = index + value1;
                    if (b.equals("")) {
                        b = b1;
                    } else {
                        if (!b.equals(b1) || a.equals(b)) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }


    public boolean patternMatching1(String pattern, String value) {
        int count_a = 0, count_b = 0;
        for (char ch : pattern.toCharArray()) {
            if (ch == 'a') {
                ++count_a;
            } else {
                ++count_b;
            }
        }
        if (count_a < count_b) {
            int temp = count_a;
            count_a = count_b;
            count_b = temp;
            char[] array = pattern.toCharArray();
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] == 'a' ? 'b' : 'a';
            }
            pattern = new String(array);
        }
        if (value.length() == 0) {
            return count_b == 0;
        }
        if (pattern.length() == 0) {
            return false;
        }
        for (int len_a = 0; count_a * len_a <= value.length(); ++len_a) {
            int rest = value.length() - count_a * len_a;
            if ((count_b == 0 && rest == 0) || (count_b != 0 && rest % count_b == 0)) {
                int len_b = (count_b == 0 ? 0 : rest / count_b);
                int pos = 0;
                boolean correct = true;
                String value_a = "", value_b = "";
                for (char ch : pattern.toCharArray()) {
                    if (ch == 'a') {
                        String sub = value.substring(pos, pos + len_a);
                        if (value_a.length() == 0) {
                            value_a = sub;
                        } else if (!value_a.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += len_a;
                    } else {
                        String sub = value.substring(pos, pos + len_b);
                        if (value_b.length() == 0) {
                            value_b = sub;
                        } else if (!value_b.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += len_b;
                    }
                }
                if (correct && !value_a.equals(value_b)) {
                    return true;
                }
            }
        }
        return false;
    }


}
