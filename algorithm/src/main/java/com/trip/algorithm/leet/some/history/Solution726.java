package com.trip.algorithm.leet.some.history;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/4/12  20:33
 * 726. 原子的数量
 * 给你一个字符串化学式 formula ，返回 每种原子的数量 。
 * <p>
 * 原子总是以一个大写字母开始，接着跟随 0 个或任意个小写字母，表示原子的名字。
 * <p>
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。
 * <p>
 * 例如，"H2O" 和 "H2O2" 是可行的，但 "H1O2" 这个表达是不可行的。
 * 两个化学式连在一起可以构成新的化学式。
 * <p>
 * 例如 "H2O2He3Mg4" 也是化学式。
 * 由括号括起的化学式并佐以数字（可选择性添加）也是化学式。
 * <p>
 * 例如 "(H2O2)" 和 "(H2O2)3" 是化学式。
 * 返回所有原子的数量，格式为：第一个（按字典序）原子的名字，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：formula = "H2O"
 * 输出："H2O"
 * 解释：原子的数量是 {'H': 2, 'O': 1}。
 * 示例 2：
 * <p>
 * 输入：formula = "Mg(OH)2"
 * 输出："H2MgO2"
 * 解释：原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 * 示例 3：
 * <p>
 * 输入：formula = "K4(ON(SO3)2)2"
 * 输出："K4N2O14S4"
 * 解释：原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 */
public class Solution726 {
    public static void main(String[] args) {
        Solution726 solution726 = new Solution726();
        String s = solution726.countOfAtoms("K4(ON(SO3)2)2");
        System.out.println(s);
    }

    public String countOfAtoms(String formula) {
        String process = process(formula);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");
        return getResult(process, 0, process.length() - 1, stringBuilder);
    }

    private String process(String str) {
        if (str.indexOf("(") == -1) {
            return str;
        }
        char[] chars = str.toCharArray();
        int left = -1;
        int right = -1;

        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        StringBuilder builder = new StringBuilder();
        while (flag) {
            boolean f = true;
            for (Character c : chars) {
                if (c == '(') {
                    f = false;
                    break;
                }
            }
            if (f) {
                break;
            }
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if (aChar == '(') {
                    left = j;
                } else if (aChar == ')') {
                    right = j;
                }
                if (right != -1 && aChar > '0' && aChar < '9') {
                    stringBuilder.append(aChar);
                } else if (right != -1 && left != -1 && (aChar > 'A'||aChar==')')) {
                    String result = getResult(str, left, right, stringBuilder);
                    builder = new StringBuilder();
                    builder.append(str, 0, left).append(result).append(str, right + stringBuilder.length(), str.length() - 1);
                    chars = builder.toString().toCharArray();
                    j = 0;
                    left = right = -1;
                    stringBuilder = new StringBuilder();
                }
            }

            if (right != -1 && left != -1) {
                String result = getResult(str, left, right, stringBuilder);
                builder = new StringBuilder();
                builder.append(str, 0, left).append(result).append(str, right + stringBuilder.length(), str.length() - 1);
                chars = builder.toString().toCharArray();
            }

        }
        return builder.toString();
    }

    private String getResult(String str, int left, int right, StringBuilder stringBuilder) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder number = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for (int i = left; i <= right; i++) {
            Character aChar = chars[i];
            if (aChar >= 'A' && aChar<='Z') {
                if (sb.length() > 0) {
                    Integer integer = 0;
                    if (number.toString().length() == 0) {
                        integer = 1;
                    } else {
                        integer = Integer.valueOf(number.toString());
                    }
                    if (map.get(sb.toString()) != null) {
                        integer = integer + Integer.valueOf(map.get(sb.toString()));
                    }
                    map.put(sb.toString(), integer);
                }
                sb = new StringBuilder();
                number = new StringBuilder();
                sb.append(aChar);
            } else if (aChar > '1' && aChar < '9') {
                number.append(aChar);
            } else if (aChar >= 'a'&& aChar<='z') {
                sb.append(aChar);
            }
        }
        Integer num = Integer.valueOf(stringBuilder.toString());
        StringBuilder result = new StringBuilder();

        Integer integer = 0;
        if (number.toString().length() == 0) {
            integer = 1;
        } else {
            integer = Integer.valueOf(number.toString());
        }
        if (map.get(sb.toString()) != null) {
            integer = integer + Integer.valueOf(map.get(sb.toString()));
        }
        map.put(sb.toString(), integer);
        List<Map.Entry<String, Integer>> collect = map.entrySet().stream().sorted((x, y) -> x.getKey().compareTo(y.getKey())).collect(Collectors.toList());
        for (Map.Entry entry : collect) {
            Integer i = Integer.valueOf(entry.getValue().toString()) * num;
            if(i>1){
                result.append(entry.getKey()).append(i);
            }else{
                result.append(entry.getKey());
            }
        }
        return result.toString();
    }
}
