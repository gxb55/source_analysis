package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年05月29日 11:34:00
 * 738. 单调递增的数字
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * <p>
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 10
 * 输出: 9
 * 示例 2:
 * <p>
 * 输入: n = 1234
 * 输出: 1234
 * 示例 3:
 * <p>
 * 输入: n = 332
 * 输出: 299
 * <p>
 * <p>
 * 提示:
 * <p>
 * 0 <= n <= 109
 * 通过次数59,701提交次数119,345
 */
public class Solution738 {
    public static void main(String[] args) {
        Solution738 solution738 = new Solution738();
        int val = 399443;
        int i = solution738.monotoneIncreasingDigits(val);
        System.out.println(i);
    }

    public int monotoneIncreasingDigits(int n) {
        String str = n + "";
        if (str.length() == 1) {
            return n;
        }
        int index = getIndex(str);
        if (index == -1) {
            return n;
        }
        int len = str.length();
        StringBuilder stringBuilder = new StringBuilder();

        while (index >= 0) {
            int left = index - 1;
            if (left < 0) {
                len = len - 1;
                while (len > 0) {
                    stringBuilder.append(9);
                    len--;
                }
                return Integer.valueOf(stringBuilder.toString());
            }
            char c = str.charAt(index);
            char c1 = str.charAt(left);
            if (check(str, (char) (c - 1), index)) {
                stringBuilder.append(str, 0, index).append((c - '1'));
                len = len - stringBuilder.length();
                while (len > 0) {
                    stringBuilder.append(9);
                    len--;
                }
                return Integer.valueOf(stringBuilder.toString());
            }
            if (left == 0 && c1 > '1') {
                stringBuilder.append(str, 0, left).append((c1 - '1'));
                while (len > 1) {
                    stringBuilder.append(9);
                    len--;
                }
                return Integer.valueOf(stringBuilder.toString());
            }
            index--;
        }
        return Integer.valueOf(stringBuilder.toString());
    }

    private boolean check(String str, char c1, int left) {
        if (left == 0 && c1 == '0') {
            return false;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < left; i++) {
            char aChar1 = chars[i];
            if (c1 < aChar1) {
                return false;
            }
        }
        return true;
    }

    private int getIndex(String str) {
        char[] chars = str.toCharArray();
        char temp = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char aChar1 = chars[i];
            if (temp <= aChar1) {
                temp = aChar1;
            } else {
                return i;
            }
        }
        return -1;
    }
}
