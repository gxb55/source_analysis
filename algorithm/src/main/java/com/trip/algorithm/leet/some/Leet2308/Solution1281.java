package com.trip.algorithm.leet.some.Leet2308;

/**
 * @author xbguo
 * @date 2023/8/9 16:54
 */
public class Solution1281 {
    public static void main(String[] args) {
        int x = 234;
        int i = subtractProductAndSum(x);
        System.out.println(i);
    }

    public static int subtractProductAndSum(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int sum = 0;
        int t = 1;
        for (Character character : chars) {
            int v = character - '0';
            sum += v;
            t = t * v;
        }
        return t - sum;
    }
}
