package com.trip.algorithm.leet.some.leet09;

/**
 * @author xbguo
 * @date 2022/9/13  18:48
 * @description 670. 最大交换
 * 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 * <p>
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 * <p>
 * 给定数字的范围是 [0, 108]
 * 通过次数49,379提交次数104,081
 */
public class Solution670 {
    public static void main(String[] args) {
        Solution670 solution670 = new Solution670();
       // int num=9973; 9913
        int num=1993;
        int i = solution670.maximumSwap(num);
        System.out.println(i);
    }

    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int left = -1;
        int right = -1;
        Character max = '0';
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '9') {
                continue;
            } else {
                left = i;
                for (int j = i + 1; j < chars.length; j++) {
                    char swapChar = chars[j];
                    if (swapChar > aChar && swapChar > max) {
                        max = swapChar;
                        right = j;
                    }else if(swapChar > aChar && swapChar == max){
                        right = j;
                    }
                }
                if (left != -1 && right != -1) {
                    break;
                }
            }
        }
        if (left != -1 && right != -1) {
            char aChar = chars[left];
            chars[left] = chars[right];
            chars[right] = aChar;
            String s1 = new String(chars);
            return Integer.valueOf(s1);
        }
        return num;
    }
}
