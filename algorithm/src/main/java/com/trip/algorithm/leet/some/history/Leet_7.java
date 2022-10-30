package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年04月05日 18:25:00
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 * 通过次数984,611提交次数2,796,543
 */
public class Leet_7 {
    public static void main(String[] args) {
        Leet_7 leet_7 = new Leet_7();
        int reverse = leet_7.reverse(-2147483648);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        String prefix = "";
        String str = String.valueOf(x);
        if (x < 0) {
            str = str.substring(1);
            prefix = "-";
        }
        StringBuilder stringBuilder = new StringBuilder().append(str);
        String reverse = stringBuilder.reverse().toString();
        while (reverse.startsWith("0")) {
            reverse = reverse.substring(1);
        }
        String s = prefix + reverse;
        Long aLong = Long.valueOf(s);
        if (aLong > Integer.MAX_VALUE || aLong < Integer.MIN_VALUE) {
            return 0;
        }
        return Integer.valueOf(String.valueOf(aLong));
    }
}
