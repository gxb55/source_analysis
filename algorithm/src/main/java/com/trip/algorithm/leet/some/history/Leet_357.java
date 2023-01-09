package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/4/11  17:45
 * 357. 统计各位数字都不同的数字个数
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：91
 * 解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 8
 * 通过次数48,101提交次数82,719
 */
public class Leet_357 {
    public static void main(String[] args) {
        Leet_357 leet_357 = new Leet_357();
        int i = leet_357.countNumbersWithUniqueDigits(2);
        System.out.println(i);
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int last = 10;
        int result = 10;
        for (int i = 2; i <= n; i++) {
            result = 9 * 9;
            for (int j = 2; j < i; j++) {
                result = result * (10 - j);
            }
            result = result + last;
            last = result;
        }
        return result;
    }
}
