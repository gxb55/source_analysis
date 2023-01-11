package com.trip.algorithm.leet.some.leet2211;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xbguo
 * @createTime 2022年11月05日 12:59:00
 * 1106. 解析布尔表达式
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 * <p>
 * 有效的表达式需遵循以下约定：
 * <p>
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：expression = "!(f)"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：expression = "|(f,t)"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：expression = "&(t,f)"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= expression.length <= 20000
 * expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。
 * expression 是以上述形式给出的有效表达式，表示一个布尔值。
 */
public class Solution1106 {
    public static void main(String[] args) {
        Solution1106 solution1106 = new Solution1106();
        //  String expression = "!(f)";
        String expression = "&(|(f))";
        //  String  expression = "|(f,t)";
        // String  expression = "&(t,f)";
       // String expression = "|(&(t,f,t),!(t))";
        boolean b = solution1106.parseBoolExpr(expression);
        System.out.println(b);
    }

    public boolean parseBoolExpr(String expression) {
        expression = expression.replace(",", "");
        char[] chars = expression.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == ')') {
                Boolean flag = null;
                List<Boolean> list = new ArrayList<>();
                while (!stack.isEmpty()) {
                    Character peek = stack.peek();
                    if (peek == '|' || peek == '&' || peek == '!') {
                        break;
                    } else if (peek == '(') {
                        stack.pop();
                    } else {
                        Character pop = stack.pop();
                        if (pop == 'f') {
                            list.add(false);
                        } else {
                            list.add(true);
                        }
                    }
                }
                Character character = stack.pop();
                for (int j = 0; j < list.size(); j++) {
                    Boolean aBoolean = list.get(j);
                    if (flag == null) {
                        flag = aBoolean;
                    } else if (character == '|') {
                        flag = flag || aBoolean;
                    } else if (character == '&') {
                        flag = flag & aBoolean;
                    } else if (character == '!') {
                        flag = !(flag & aBoolean);
                    }
                }
                if (list.size() == 1) {
                    if (character == '!') {
                        flag = !flag;
                    }
                }
                if (flag) {
                    stack.add('t');
                } else {
                    stack.add('f');
                }
            } else {
                stack.add(aChar);
            }
        }
        return stack.pop() == 'f' ? false : true;
    }
}
