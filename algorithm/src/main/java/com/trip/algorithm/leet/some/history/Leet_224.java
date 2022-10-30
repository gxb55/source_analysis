package com.trip.algorithm.leet.some.history;

import java.util.*;

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
        String s = "- (30 - (- (4 + 5) ) )";
        // String s = "1+1";
        int calculate2 = leet_224.calculate2(s);
        int calculate = leet_224.calculate5(s);
        //int calculate = leet_224.calculate4("1+1");
        // int calculate = leet_224.calculate4(" 2-1 + 2 ");
        System.out.println(calculate);
        System.out.println(calculate2);
    }

    public int calculate5(String s) {
        Deque<Integer> queue = new LinkedList<>();
        Deque<Character> characters = new LinkedList<>();
        queue.add(0);
        s = s.replace(" ", "");
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '(') {
                characters.add(aChar);
            } else if (aChar == ')') {
                while (!characters.isEmpty() && characters.peekLast() != '(') {
                    cal(queue, characters);
                }
                characters.pollLast();
            } else if (Character.isDigit(aChar)) {
                int num = 0;
                while (i < chars.length && Character.isDigit(chars[i])) {
                    num = num * 10 + (chars[i] - '0');
                    i++;
                }
                queue.add(num);
                i--;
            } else if (aChar == '+') {
                if (!characters.isEmpty() && characters.peekLast() != '(') {
                    cal(queue, characters);
                }
                characters.add(aChar);
            } else if (aChar == '-') {
                if (!characters.isEmpty() && characters.peekLast() != '(') {
                    cal(queue, characters);
                }
                if (i > 0 && chars[i - 1] == '(') {
                    queue.add(0);
                }
                characters.add(aChar);
            }
        }
        while (!characters.isEmpty()) {
            cal(queue, characters);
        }
        return queue.peekLast();
    }

    private void cal(Deque<Integer> queue, Deque<Character> characters) {
        if (queue.size() < 2) {
            return;
        }
        if (characters.isEmpty()) {
            return;
        }
        Integer poll = queue.pollLast();
        Integer poll1 = queue.pollLast();
        Character poll2 = characters.pollLast();
        if (poll2 == '+') {
            queue.add(poll1 + poll);
        } else if (poll2 == '-') {
            queue.add(poll1 - poll);
        }
    }


    /**
     * 一个栈，每次更新符号位置，相当于把所有的括号去掉，然后计算结果。
     *
     * @param s
     * @return
     */
    public int calculate4(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        int sign = 1;
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == ' ') {
                continue;
            } else if (aChar == '+') {
                sign = stack.peek();
            } else if (aChar == '-') {
                sign = -stack.peek();
            } else if (aChar == '(') {
                stack.add(sign);
            } else if (aChar == ')') {
                stack.pop();
            } else {
                int num = 0;
                while (i < chars.length && Character.isDigit(chars[i])) {
                    num = num * 10 + (chars[i] - '0');
                    i++;
                }
                i--;
                res = res + sign * num;
            }
        }
        return res;
    }

    public int calculate2(String s) {
        // 存放所有的数字
        Deque<Integer> nums = new ArrayDeque<>();
        // 为了防止第一个数为负数，先往 nums 加个 0
        nums.addLast(0);
        // 将所有的空格去掉
        s = s.replaceAll(" ", "");
        // 存放所有的操作，包括 +/-
        Deque<Character> ops = new ArrayDeque<>();
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                // 计算到最近一个左括号为止
                while (!ops.isEmpty()) {
                    char op = ops.peekLast();
                    if (op != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (isNum(c)) {
                    int u = 0;
                    int j = i;
                    // 将从 i 位置开始后面的连续数字整体取出，加入 nums
                    while (j < n && isNum(cs[j])) {
                        u = u * 10 + (int) (cs[j++] - '0');
                    }
                    nums.addLast(u);
                    i = j - 1;
                } else {
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.addLast(0);
                    }
                    // 有一个新操作要入栈时，先把栈内可以算的都算了
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        calc(nums, ops);
                    }
                    ops.addLast(c);
                }
            }
        }
        while (!ops.isEmpty()) {
            calc(nums, ops);
        }
        return nums.peekLast();
    }

    void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) {
            return;
        }
        if (ops.isEmpty()) {
            return;
        }
        int b = nums.pollLast(), a = nums.pollLast();
        char op = ops.pollLast();
        nums.addLast(op == '+' ? a + b : a - b);
    }

    boolean isNum(char c) {
        return Character.isDigit(c);
    }

    public int calculate1(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;
        s = s.replace(" ", "");
        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            char charAt = s.charAt(i);
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    public int calculate(String s) {
        set.add('+');
        set.add('-');
        set.add(' ');
        s = s.replace(" ", "");
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