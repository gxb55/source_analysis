package com.trip.algorithm.leet.some.Leet2308;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @createTime 2023年07月30日 21:33:00
 */
public class Solution76 {
    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
       // String s = "ADOBECODEBANC", t = "ABC";
        String s = "a", t = "a";
        String v = solution76.minWindow(s, t);
        System.out.println(v);

    }

    public String minWindow(String s, String t) {
        int[] ints = new int[256];
        char[] chars = t.toCharArray();
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            int val = chars[i] - 'A';
            ints[val]++;
            list.add(val);
        }
        String res = "";
        int left = 0;
        int right = 0;
        int[] w = new int[256];
        for (int i = 0; i < s.length(); i++) {
            right++;
            int val = s.charAt(i) - 'A';
            w[val]++;
            if ((right - left) >= t.length()) {
                if (list.stream().allMatch(x -> ints[x] <= w[x])) {
                   // 把第一个目标数字剔除
                    while (list.stream().allMatch(x -> ints[x] <= w[x])) {
                        // 只要符合条件就更新结果
                        if ("".equals(res) || res.length() > (right - left)) {
                            res = s.substring(left, right);
                        }
                        val = s.charAt(left) - 'A';
                        w[val]--;
                        left++;
                    }
                    //把第一个目标数字剔除后，把第一个目标数字和第二个目标数字之前的无用字符去除
                    while (left < right) {
                        val = s.charAt(left) - 'A';
                        if (list.contains(val) && ints[val] >= w[val]) {
                            break;
                        }
                        w[val]--;
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
