package com.trip.algorithm.leet.some.leet2303;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年03月26日 13:34:00
 * 1234. 替换子串得到平衡字符串
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 * <p>
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 * <p>
 * <p>
 * <p>
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * <p>
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 * <p>
 * 请返回待替换子串的最小可能长度。
 * <p>
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "QWER"
 * 输出：0
 * 解释：s 已经是平衡的了。
 * 示例 2：
 * <p>
 * 输入：s = "QQWE"
 * 输出：1
 * 解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
 * 示例 3：
 * <p>
 * 输入：s = "QQQW"
 * 输出：2
 * 解释：我们可以把前面的 "QQ" 替换成 "ER"。
 * 示例 4：
 * <p>
 * 输入：s = "QQQQ"
 * 输出：3
 * 解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s.length 是 4 的倍数
 * s 中只含有 'Q', 'W', 'E', 'R' 四种字符
 * 通过次数28,683提交次数64,272
 */
public class Solution1234 {
    public static void main(String[] args) {
        Solution1234 solution1234 = new Solution1234();
        String s = "QQWE";
       // s = "QQQQ";
        //s = "QQQW";
         s = "WQWRQQQW";
         s = "WQWRQQQW";
        int i = solution1234.balancedString1(s);
        System.out.println(i);
    }

    public int balancedString1(String s) {
        int[] arr = new int[4];
        char[] chars = s.toCharArray();
        //'Q', 'W', 'E', 'R'
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            arr[getIndex(aChar)]++;
        }
        int res = s.length() / 4;
        boolean b = Arrays.stream(arr).allMatch(x -> x == res);
        if (b) {
            return 0;
        }
        int len = s.length();
        int left = 0;
        int right = 0;
        for (; right < chars.length; right++) {
            char aChar = chars[right];
            arr[getIndex(aChar)]--;
            while (left <= right && Arrays.stream(arr).allMatch(x -> x <=res)) {
                len = Math.min(len, right - left + 1);
                char aChar1 = chars[left];
                arr[getIndex(aChar1)]++;
                left++;
            }
        }
        return len;
    }

    private int getIndex(char aChar) {
        if (aChar == 'Q') {
            return 0;
        } else if (aChar == 'W') {
            return 1;
        } else if (aChar == 'E') {
            return 2;
        } else {
            return 3;
        }
    }

    public int balancedString(String s) {
        int[] arr = new int[4];
        char[] chars = s.toCharArray();
        //'Q', 'W', 'E', 'R'
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == 'Q') {
                arr[0]++;
            } else if (aChar == 'W') {
                arr[1]++;
            } else if (aChar == 'E') {
                arr[2]++;
            } else if (aChar == 'R') {
                arr[3]++;
            }
        }
        int res = s.length() / 4;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > res) {
                Character character = 'Q';
                if (i == 1) {
                    character = 'W';
                } else if (i == 2) {
                    character = 'E';
                } else if (i == 3) {
                    character = 'R';
                }
                map.put(character, arr[i] - res);
                count += arr[i] - res;
            }
        }
        if (count == 0) {
            return 0;
        }
        int left = 0;
        int right = count - 1;
        int len = s.length();
        while (left <= right && right < s.length()) {
            if ((right - left + 1) < count) {
                right++;
            } else {
                boolean flag = check(map, left, right, s);
                if (flag) {
                    len = Math.min(len, right - left + 1);
                    left++;
                } else {
                    right++;
                }
            }
        }
        return len;
    }

    private Map<Integer, int[]> totalMap;

    private boolean check(Map<Character, Integer> map, int left, int right, String s) {
        char[] chars = s.toCharArray();
        if (totalMap == null) {
            totalMap = new HashMap<>();
            totalMap.put(-1, new int[4]);
            int[] arr = new int[4];
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                if (aChar == 'Q') {
                    arr[0]++;
                } else if (aChar == 'W') {
                    arr[1]++;
                } else if (aChar == 'E') {
                    arr[2]++;
                } else if (aChar == 'R') {
                    arr[3]++;
                }
                totalMap.put(i, Arrays.copyOf(arr, arr.length));
            }
        }

        int[] ints = totalMap.get(right);
        int[] ints1 = totalMap.get(left - 1);
        for (int i = 0; i < ints.length; i++) {
            Character character = 'Q';
            if (i == 1) {
                character = 'W';
            } else if (i == 2) {
                character = 'E';
            } else if (i == 3) {
                character = 'R';
            }
            int count = ints[i] - ints1[i];
            Integer integer = map.get(character);
            if (integer != null && integer > count) {
                return false;
            }
        }
        return true;

    }
}
