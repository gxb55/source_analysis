package com.trip.algorithm.leet.some.leet2301;

/**
 * @author xbguo
 * @date 2023/1/6 09:28
 * 2180. 统计各位数字之和为偶数的整数个数
 * 给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。
 * <p>
 * 正整数的 各位数字之和 是其所有位上的对应数字相加的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 4
 * 输出：2
 * 解释：
 * 只有 2 和 4 满足小于等于 4 且各位数字之和为偶数。
 * 示例 2：
 * <p>
 * 输入：num = 30
 * 输出：14
 * 解释：
 * 只有 14 个整数满足小于等于 30 且各位数字之和为偶数，分别是：
 * 2、4、6、8、11、13、15、17、19、20、22、24、26 和 28 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 1000
 */
public class Solution2180 {
    public static void main(String[] args) {
        Solution2180 solution2180 = new Solution2180();

    }

    public int countEven(int num) {
        int res = 0;
        int cur = 1;
        int sum;
        while (cur <= num) {
            sum = 0;
            String s = String.valueOf(cur);
            char[] chars = s.toCharArray();
            for (Character character : chars) {
                int i = character - '0';
                sum = sum + i;
            }
            cur++;
            if (sum % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
