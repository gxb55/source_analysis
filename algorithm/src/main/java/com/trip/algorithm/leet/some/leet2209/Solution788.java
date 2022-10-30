package com.trip.algorithm.leet.some.leet2209;

/**
 * @author xbguo
 * @createTime 2022年09月25日 09:43:00
 * 788. 旋转数字
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * <p>
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；
 * 2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；
 * 6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * <p>
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 * <p>
 * <p>
 * 提示：
 * <p>
 * N 的取值范围是 [1, 10000]。
 * 通过次数23,131提交次数36,996
 */
public class Solution788 {
    public static void main(String[] args) {
        Solution788 solution788 = new Solution788();
        int n = 857;
        int i = solution788.rotatedDigits(n);
        System.out.println(i);
    }

    public int rotatedDigits(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            /**
             * 2 5 6 9
             * 1 8 0
             * 4 7 3
             */
            if (s.contains("2") || s.contains("5") || s.contains("6") || s.contains("9")) {
                if (!s.contains("4") && !s.contains("7")&& !s.contains("3")) {
                    sum = sum + 1;
                }
            }
        }
        return sum;
    }
}
