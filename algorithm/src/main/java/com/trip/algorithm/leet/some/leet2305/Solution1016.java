package com.trip.algorithm.leet.some.leet2305;

/**
 * @author xbguo
 * @date 2023/5/11 09:42
 * 示例 1：
 * <p>
 * 输入：s = "0110", n = 3
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "0110", n = 4
 * 输出：false
 */
public class Solution1016 {
    public static void main(String[] args) {
        /*String s = "0110";
        int n = 3; */

     /*   String s = "0110";
        int n = 4;*/

        String s = "1";
        int n = 1;
        boolean b = queryString(s, n);
        System.out.println(b);
    }

    public static boolean queryString(String s, int n) {
        int t = n / 2;
        int k = n;
        while (k >= t && k <= n && k >= 1) {
            String s1 = Integer.toBinaryString(k);
            if (!s.contains(s1)) {
                return false;
            }
            k--;
        }
        return true;
    }
}
