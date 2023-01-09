package com.trip.algorithm.leet.some.leet12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/12/26 09:39
 * @description Solution1759
 * 1759. 统计同构子字符串的数目
 * 给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 109 + 7 取余 后的结果。
 * <p>
 * 同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abbcccaa"
 * 输出：13
 * 解释：同构子字符串如下所列：
 * "a"   出现 3 次。
 * "aa"  出现 1 次。
 * "b"   出现 2 次。
 * "bb"  出现 1 次。
 * "c"   出现 3 次。
 * "cc"  出现 2 次。
 * "ccc" 出现 1 次。
 * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13
 * 示例 2：
 * <p>
 * 输入：s = "xy"
 * 输出：2
 * 解释：同构子字符串是 "x" 和 "y" 。
 * 示例 3：
 * <p>
 * 输入：s = "zzzzz"
 * 输出：15
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 由小写字符串组成
 * 通过次数8,668提交次数17,997
 */
public class Solution1759 {
    public static void main(String[] args) {
        Solution1759 solution1759 = new Solution1759();
        //  String str = "abbcccaa";
        // String str = "xy";
        String str = "zzzzz";
        int i = solution1759.countHomogenous1(str);
        System.out.println(i);
    }

    int mod = 1000000007;

    public int countHomogenous1(String s) {
        char[] chars = s.toCharArray();
        long sum = 0;
        List<Character> list = new ArrayList<>();
        list.add(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                list.add(chars[i]);
            } else {
                int res = 0;
                for (long j = 1; j <= list.size(); j++) {
                    res += j % mod;
                    res = res % mod;
                }
                sum += res % mod;
                sum = sum % mod;
                list.clear();
                list.add(chars[i]);
            }
        }
        if (list.size() > 0) {
            int res = 0;
            for (int j = 1; j <= list.size(); j++) {
                res += j;
            }
            sum += res % mod;
            sum = sum % mod;
        }
        return (int) sum;
    }

    public int countHomogenous(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        long sum = 0;
        List<Character> list = new ArrayList<>();
        while (left <= right && right < s.length()) {
            if (list.size() == 0) {
                list.add(chars[right]);
                right++;
                continue;
            }
            int res = check(list);
            if (res > 0) {
                System.out.println(list);
                sum += res % mod;
                sum = sum % mod;
                list.add(chars[right]);
                right++;
            } else {
                list.remove(0);
                left++;
            }

        }
        while (list.size() > 0) {
            int res = check(list);
            if (res > 0) {
                System.out.println(list);
                sum += res % mod;
                sum = sum % mod;
            }
            list.remove(0);
        }
        return (int) sum;
    }

    public int check(List<Character> list) {
        if (list.size() > 0) {
            char c = list.get(0);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != c) {
                    return -1;
                }
            }
            int x = 0;
            for (int i = 0; i < list.size(); i++) {
                x++;
            }
            return x;
        }
        return -1;
    }
}
