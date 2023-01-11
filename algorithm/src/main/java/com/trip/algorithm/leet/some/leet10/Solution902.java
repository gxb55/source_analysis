package com.trip.algorithm.leet.some.leet10;

import java.util.HashSet;
import java.util.Set;

/**
 * @auther: xbguo
 * @date: 2022/10/18 10:49
 * @description: 902
 * 902. 最大为 N 的数字组合
 * 给定一个按 非递减顺序 排列的数字数组 digits 。你可以用任意次数 digits[i] 来写的数字。
 * 例如，如果 digits = ['1','3','5']，我们可以写数字，如 '13', '551', 和 '1351315'。
 * <p>
 * 返回 可以生成的小于或等于给定整数 n 的正整数的个数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = ["1","3","5","7"], n = 100
 * 输出：20
 * 解释：
 * 可写出的 20 个数字是：
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 * 示例 2：
 * <p>
 * 输入：digits = ["1","4","9"], n = 1000000000
 * 输出：29523
 * 解释：
 * 我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
 * 81 个四位数字，243 个五位数字，729 个六位数字，
 * 2187 个七位数字，6561 个八位数字和 19683 个九位数字。
 * 总共，可以使用D中的数字写出 29523 个整数。
 * 示例 3:
 * <p>
 * 输入：digits = ["7"], n = 8
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 9
 * digits[i].length == 1
 * digits[i] 是从 '1' 到 '9' 的数
 * digits 中的所有值都 不同
 * digits 按 非递减顺序 排列
 * 1 <= n <= 109
 * 通过次数10,604提交次数24,177
 */
public class Solution902 {
    public static void main(String[] args) {
        Solution902 s = new Solution902();
        //24
        String[] digits = {"1", "3", "5", "7"};
        int n = 120;

      /*  String[] digits = {"1", "4", "9"};
        int n = 1000000000;*/

       /* String[] digits = {"1", "2", "3", "4", "7", "8", "9"};
        int n = 32901345;*/


        int i = s.atMostNGivenDigitSet(digits, n);
        System.out.println(i);
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        if (n < 10) {
            Set<Long> set = new HashSet<>();
            process(digits, 0, n, set, "");
            return set.size();
        } else {
            int sum = 0;
            int length = digits.length;
            String nStr = String.valueOf(n);
            int len = nStr.length();
            for (int i = 1; i < len; i++) {
                int t = i;
                int cur = i;
                while (t > 0) {
                    cur = cur * length;
                    t--;
                }
                sum = sum + cur;
            }

            for (int i = 0; i < nStr.length(); i++) {
                char c = nStr.charAt(i);
                int val = c - '0';
                int bigLen=0;
                int eLen=0;
                for (int j = 0; j < digits.length; j++) {
                    String digit = digits[j];
                    Integer integer = Integer.valueOf(digit);
                    if(val>integer){
                        bigLen++;
                    }else if(val==integer){
                        eLen++;
                    }else{
                        break;
                    }
                }
                sum+=bigLen* Math.pow(digits.length-i+1,nStr.length()-i-1);
            }

            return sum;
        }
    }

    private boolean process(String[] digits, int index, int max, Set<Long> set, String curStr) {
        if (!curStr.equals("")) {
            Long integer = Long.valueOf(curStr);
            if (integer > max) {
                return false;
            }
            set.add(integer);
        }

        for (int i = index; i < digits.length; i++) {
            String digit = digits[i];
            boolean process = process(digits, index, max, set, curStr + digit);
            if (!process) {
                break;
            }
        }
        return true;
    }
}
