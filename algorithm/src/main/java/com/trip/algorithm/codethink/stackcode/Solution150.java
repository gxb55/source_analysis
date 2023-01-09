package com.trip.algorithm.codethink.stackcode;

import java.util.Stack;

/**
 * @author xbguo
 * @date 2022/11/16 16:04
 * @description Solution150
 * 150. 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 注意 两个整数之间的除法只保留整数部分。
 * <p>
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例 3：
 * <p>
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= tokens.length <= 104
 * tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
 * <p>
 * <p>
 * 逆波兰表达式：
 * <p>
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * <p>
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 * <p>
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
 * 通过次数233,367提交次数443,679
 */
public class Solution150 {
    public static void main(String[] args) {
        Solution150 solution150 = new Solution150();
       // String[] tokens = {"2","1","+","3","*"};
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int i = solution150.evalRPN(tokens);
        System.out.println(i);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+")) {
                Integer pop = stack.pop();
                Integer pop1 = stack.pop();
                stack.add(pop1+pop);
            } else if (token.equals("-")) {
                Integer pop = stack.pop();
                Integer pop1 = stack.pop();
                stack.add(pop1-pop);
            } else if (token.equals("/")) {
                Integer pop = stack.pop();
                Integer pop1 = stack.pop();
                stack.add(pop1/pop);
            } else if (token.equals("*")) {
                Integer pop = stack.pop();
                Integer pop1 = stack.pop();
                stack.add(pop1*pop);
            } else {
                stack.add(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
