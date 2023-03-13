package com.trip.algorithm.leet.some.leet2303;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/3/7 09:53
 * 1096. 花括号展开 II
 * 如果你熟悉 Shell 编程，那么一定了解过花括号展开，它可以用来生成任意字符串。
 * <p>
 * 花括号展开的表达式可以看作一个由 花括号、逗号 和 小写英文字母 组成的字符串，定义下面几条语法规则：
 * <p>
 * 如果只给出单一的元素 x，那么表达式表示的字符串就只有 "x"。R(x) = {x}
 * 例如，表达式 "a" 表示字符串 "a"。
 * 而表达式 "w" 就表示字符串 "w"。
 * 当两个或多个表达式并列，以逗号分隔，我们取这些表达式中元素的并集。R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...
 * 例如，表达式 "{a,b,c}" 表示字符串 "a","b","c"。
 * 而表达式 "{{a,b},{b,c}}" 也可以表示字符串 "a","b","c"。
 * 要是两个或多个表达式相接，中间没有隔开时，我们从这些表达式中各取一个元素依次连接形成字符串。R(e_1 + e_2) = {a + b for (a, b) in R(e_1) × R(e_2)}
 * 例如，表达式 "{a,b}{c,d}" 表示字符串 "ac","ad","bc","bd"。
 * 表达式之间允许嵌套，单一元素与表达式的连接也是允许的。
 * 例如，表达式 "a{b,c,d}" 表示字符串 "ab","ac","ad"​​​​​​。
 * 例如，表达式 "a{b,c}{d,e}f{g,h}" 可以表示字符串 "abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"。
 * 给出表示基于给定语法规则的表达式 expression，返回它所表示的所有字符串组成的有序列表。
 * <p>
 * 假如你希望以「集合」的概念了解此题，也可以通过点击 “显示英文描述” 获取详情。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：expression = "{a,b}{c,{d,e}}"
 * 输出：["ac","ad","ae","bc","bd","be"]
 * 示例 2：
 * <p>
 * 输入：expression = "{{a,z},a{b,c},{ab,z}}"
 * 输出：["a","ab","ac","z"]
 * 解释：输出中 不应 出现重复的组合结果。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= expression.length <= 60
 * expression[i] 由 '{'，'}'，',' 或小写英文字母组成
 * 给出的表达式 expression 用以表示一组基于题目描述中语法构造的字符串
 * 通过次数4,761提交次数7,034
 */
public class Solution1096 {
    public static void main(String[] args) {
        Solution1096 solution1096 = new Solution1096();
          String expression = "{a,b}{c,{d,e}}";
        //String expression = "{{a,z},a{b,c},{ab,z}}";
        List<String> list = solution1096.braceExpansionII(expression);
        System.out.println(list);
    }

    public List<String> braceExpansionII(String expression) {
        char[] chars = expression.toCharArray();
        int type = 0;
        LinkedList<String> list1 = new LinkedList<>();
        List<List<String>> charList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            String s = String.valueOf(chars[i]);
            StringBuilder stringBuilder = new StringBuilder();
            boolean flag = false;
            while ((i) < chars.length && chars[i] >= 'a' && chars[i] <= 'z') {
                stringBuilder.append(chars[i]);
                i++;
                flag = true;
            }
            if (flag) {
                i--;
            }
            char aChar = chars[i];
            if (stringBuilder.length() > 0) {
                list1.add(stringBuilder.toString());
            } else {
                list1.add(String.valueOf(aChar));
            }

            if (aChar == '{' && !list1.isEmpty() && list1.size() > 2 && list1.get(list1.size() - 2).equals(",")) {
                type = 1;
            } else if (aChar == '{' && list1.size() > 2 && !list1.get(list1.size() - 2).equals(",") && !list1.get(list1.size() - 2).equals("}")) {
                LinkedList<String> list2 = new LinkedList<>();
                list2.add(String.valueOf(list1.get(list1.size() - 2)));
                charList.add(list2);
                type = 3;
            } else if (aChar == '{' && list1.size() > 2 && list1.get(list1.size() - 2).equals("}")) {
                type = 3;
            }
            if (aChar == '}' && !list1.get(list1.size() - 2).equals("}")) {
                LinkedList<String> list2 = new LinkedList<>();
                for (int j = list1.size() - 1; j >= 0; j--) {
                    String character = list1.get(j);
                    if (character.equals("{")) {
                        break;
                    }
                    if (character.equals(",") || character.equals("}")) {
                        continue;
                    }
                    list2.addFirst(character);
                }
                if (type == 1 || type == 3) {
                    list2 = handle(list2, charList.get(charList.size() - 1), type, charList);
                }
                charList.add(list2);
                type = 0;
            }
        }
        Set<String> strings1 = new HashSet<>();
        List<String> list = new ArrayList<>();
        charList.forEach(x -> {
            x.forEach(z -> {
                if (strings1.add(z)) {
                    list.add(z);
                }
            });

        });
        return list;
    }

    private LinkedList<String> handle(LinkedList<String> list2, List<String> characters, int type, List<List<String>> charList) {
        LinkedList<String> list = new LinkedList<>();
        if (type == 1) {
            charList.remove(characters.size() - 1);
            for (String character : characters) {
                list.add(character);
            }
            for (String character : list2) {
                list.add(character);
            }
        } else {
            charList.remove(characters.size() - 1);
            for (String character : characters) {
                for (String character1 : list2) {
                    list.add(character + character1);
                }
            }
        }
        return list;
    }


    List<String> strings = new ArrayList<>();
    Set<String> set = new HashSet<>();

    private void getRes(List<List<String>> list, int index, String str) {
        if (index >= list.size()) {
            if (set.add(str)) {
                strings.add(str);
            }
            return;
        }
        List<String> list1 = list.get(index);
        for (int i = 0; i < list1.size(); i++) {
            String s = list1.get(i);
            if (s.equals(",") || s.equals("}") || s.equals("{")) {
                continue;
            }
            getRes(list, index + 1, str + list1.get(i));
        }
    }

    private void process(LinkedList<String> linkedList) {
        linkedList.pollLast();
        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();
        boolean flag = false;
        while (!linkedList.isEmpty()) {
            String character = linkedList.pollLast();
            if (character.equals(",")) {
                continue;
            }
            if (character.equals("{")) {
                flag = true;
                continue;
            }
            if (!flag) {
                if (!character.equals("{") && !character.equals("}") && !character.equals(",")) {
                    list2.addFirst(character);
                }

            } else {
                if (!character.equals("{") && !character.equals("}") && !character.equals(",")) {
                    list1.addFirst(character);
                }
            }
        }
        linkedList.clear();
        Set<String> set = new HashSet<>();
        for (String character : list1) {
            for (String character1 : list2) {
                String s = character + character1;
                if (set.add(s)) {
                    linkedList.add(s);
                }
            }
        }

    }
}
