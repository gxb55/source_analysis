package com.trip.algorithm.leet.some.leet2304;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年04月09日 08:50:00
 * 示例 1：
 * <p>
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * 示例 2：
 * <p>
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * 示例 3：
 * <p>
 * 输入：s = ")("
 * 输出：[""]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-invalid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution301 {
    public static void main(String[] args) {
        Solution301 solution301 = new Solution301();
        String s = "()())()";
        s = "(a)())()";
        s = ")(";
        s = "n";
        s = "))(())()((l())((()))";
        s = "((((((((((((((((((((aaaaa";

        s = "()(()((";
        List<String> list = solution301.removeInvalidParentheses1(s);
        System.out.println(list);
    }

    public List<String> removeInvalidParentheses1(String s) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Deque<String> stringDeque = new ArrayDeque<>();
        stringDeque.addLast(s);
        set.add(s);
        int len=-1;
        while (!stringDeque.isEmpty()) {
            String s1 = stringDeque.pollFirst();
            boolean check = check(s1.toCharArray());
            if (check) {
                list.add(s1);
                len=s1.length();
                break;
            }
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                if (c == ')' || c == '(') {
                    String s2 = s1.substring(0, i) + s1.substring(i + 1);
                    if (set.add(s2)) {
                        stringDeque.addLast(s2);
                    }
                }
            }
        }
        while (!stringDeque.isEmpty()) {
            String s1 = stringDeque.pollFirst();
            if(s1.length()<len){
                break;
            }
            boolean check = check(s1.toCharArray());
            if (check) {
                list.add(s1);
            }
        }
        return list;
    }
    private boolean check(char[] s) {
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ')') {
                index++;
            } else if (s[i] == '(') {
                index--;
            }
            if (index > 0) {
                return false;
            }
        }
        if (index == 0) {
            return true;
        }
        return false;
    }
    public List<String> removeInvalidParentheses(String s) {
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        if (check(s.toCharArray())) {
            list.add(s);
            return list;
        }
        Set<String> set = new HashSet<>();
        Set<String> pre = new HashSet<>();
        process(chars, 0, pre, set);
        List<String> collect = set.stream().sorted((x, y) -> y.length() - x.length()).collect(Collectors.toList());
        String s1 = collect.get(0);
        for (String s2 : collect) {
            if (s2.length() != s1.length()) {
                break;
            }
            list.add(s2);
        }
        System.out.println(pre);
        return list;
    }

    private void process(char[] s, int index, Set<String> pre, Set<String> set) {
        if (index > s.length) {
            return;
        }
        String s2 = new String(s);
        if (check(s)) {
            set.add(s2.replace("-", ""));
            return;
        }
        if (pre.contains(s2.substring(0, index).replace("-", "") + index)) {
            return;
        }
        for (int i = index; i < s.length; i++) {
            char c = s[i];
            if (c != ')' && c != '(') {
                continue;
            }
           /* if(i!=index&&s[i]==s[i-1]){
                continue;
            }*/
            s[i] = '-';
            process(s, i + 1, pre, set);
            String s1 = new String(s);
            pre.add(s1.substring(0, i).replace("-", "") + i);
            s[i] = c;
        }
    }




}
