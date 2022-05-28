package com.trip.algorithm.leet.some;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author xbguo
 * @createTime 2022年04月30日 22:58:00
 * 224. 基本计算器
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
 * '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
 * 输入中不存在两个连续的操作符
 * 每个数字和运行的计算将适合于一个有符号的 32位 整数
 * 通过次数87,160提交次数208,106
 */
public class Leet_224 {
    public static void main(String[] args) {
        Leet_224 leet_224 = new Leet_224();
        int calculate = leet_224.calculate("- (3 - (- (4 + 5) ) )");
        System.out.println(calculate);
    }

    public int calculate(String s) {
        set.add('+');
        set.add('-');
        set.add(' ');
        s = s.replace(" ","");
        if (s.contains("(")) {
            Stack<String> stack = new Stack<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                stack.add(String.valueOf(aChar));
                if (aChar == ')') {
                    stack.pop();
                    String str = getString(stack);
                    int result = getResult(str, 0);
                    stack.add(String.valueOf(result));
                }
            }
            String s1 = getString(stack);
            int result = getResult(s1, 0);
            return result;
        } else {
            return getResult(s.trim(), 0);
        }
    }

    private String getString(Stack<String> stack) {
        Stack<String> pop1 = new Stack<>();
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            if (pop.equals("(")) {
                break;
            } else {
                pop1.add(pop);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!pop1.isEmpty()) {
            stringBuilder.append(pop1.pop());
        }
        return stringBuilder.toString();
    }

    private int getResult(String s, int i) {
        int sum = 0;
        int index = i;
        Res num = getNum(s, index);
        sum = Integer.valueOf(num.res);
        index = num.index;
        while (index < s.length()) {
            Res str1 = getF(s, index);
            Res num1 = getNum(s, str1.index);
            sum = getRes(sum, str1.res, num1.res);
            index = num1.index;
        }
        return sum;
    }

    private int getRes(Integer str, String str1, String str2) {
        Integer x = Integer.valueOf(str);
        Integer y = Integer.valueOf(str2);
        if (str1.equals("+")) {
            return x + y;
        } else {
            return x - y;
        }
    }

    private Res getF(String s, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                if (c == ' ') {
                } else {
                    stringBuilder.append(c);
                    i++;
                    break;
                }
            } else {
                break;
            }
            i++;
        }
        return new Res(i, stringBuilder.toString());
    }

    Set<Character> set = new HashSet<>();

    private Res getNum(String s, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        int temp = i;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                if (c == ' ') {

                } else if (c == '-' && temp == i) {
                    stringBuilder.append(c);
                } else {
                    break;
                }
            } else {
                stringBuilder.append(c);
            }
            i++;
        }
        return new Res(i, stringBuilder.toString());
    }
}

class Res {
    public int index;
    public String res;

    public Res(int index, String res) {
        this.index = index;
        this.res = res;
    }

    @Override
    public String toString() {
        return "Res{" +
                "index=" + index +
                ", res='" + res + '\'' +
                '}';
    }
}