package com.trip.algorithm.leet.some.leet08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/8/10  11:29
 * @description Solution640
 * 640. 求解方程
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 * <p>
 * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 * <p>
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 * <p>
 * 输入: equation = "x=x"
 * 输出: "Infinite solutions"
 * 示例 3:
 * <p>
 * 输入: equation = "2x=x"
 * 输出: "x=0"
 * <p>
 * <p>
 * 提示:
 * <p>
 * 3 <= equation.length <= 1000
 * equation 只有一个 '='.
 * equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。
 */
public class Solution640 {
    public static void main(String[] args) {
        Solution640 solution640 = new Solution640();
        // String str = "x+5-3+x=6+x-2";
        //String str = "2x=x";
      //  String str = "x=x";
        String str = "x=x+2";
        String s = solution640.solveEquation(str);
        System.out.println(s);
    }

    public String solveEquation(String equation) {
        char[] chars = equation.toCharArray();
        // 数字
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        // 数字
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        int middle = equation.indexOf("=");
        StringBuilder stringBuilder = new StringBuilder();
        build(chars, list1, list2, 0, middle, stringBuilder);
        build(chars, list3, list4, middle, chars.length, stringBuilder);

        int res1 = getRes(list1);
        int res3 = getRes(list3);
        int res2 = getRes(list2);
        int res4 = getRes(list4);
        int left = res2 - res4;
        int right = res3 - res1;
        if (right == 0 && left != 0) {
            return "x=0";
        } else if (left == 0 && right == 0) {
            return "Infinite solutions";
        }else if(left==0&&right!=0){
            return "No solution";
        }
        String s = "x=" + right / left;
        return s;
    }

    private void build(char[] chars, List<String> list1, List<String> list2, int begin, int end, StringBuilder stringBuilder) {
        for (int i = begin; i < end; i++) {
            char aChar = chars[i];
            if (aChar == '+' || aChar == '-') {
                stringBuilder.append(aChar);
            } else if (Character.isDigit(aChar)) {
                int sum = 0;
                boolean flag = false;
                while (i < end && (Character.isDigit(chars[i]) || chars[i] == 'x')) {
                    if (chars[i] == 'x') {
                        flag = true;
                        i++;
                        break;
                    }
                    sum = sum * 10 + chars[i] - '0';
                    i++;
                }
                i--;
                stringBuilder.append(sum);
                String s = stringBuilder.toString();
                if (s.startsWith("+")) {
                    s = s.substring(1);
                }
                if (flag) {
                    list2.add(s);
                } else {
                    list1.add(s);
                }
                stringBuilder.setLength(0);
            } else if (aChar == 'x') {
                stringBuilder.append("1");
                String s = stringBuilder.toString();
                if (s.startsWith("+")) {
                    s = s.substring(1);
                }
                list2.add(s);
                stringBuilder.setLength(0);
            }
        }
    }


    private int getRes(List<String> list1) {
        int res = 0;
        for (int i = 0; i < list1.size(); i++) {
            res = res + Integer.valueOf(list1.get(i));
        }
        return res;
    }
}