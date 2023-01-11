package com.trip.algorithm.codethink.recall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/1/11 11:04
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Solution17 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        String digits = "999";
        List<String> list = solution17.letterCombinations(digits);
        System.out.println(list);
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> list2 = List.of("a", "b", "c");
        List<String> list3 = List.of("d", "e", "f");
        List<String> list4 = List.of("g", "h", "i");
        List<String> list5 = List.of("j", "k", "l");
        List<String> list6 = List.of("m", "n", "o");
        List<String> list7 = List.of("p", "q", "r", "s");
        List<String> list8 = List.of("t", "u", "v");
        List<String> list9 = List.of("w", "x", "y", "z");
        map.put(2, list2);
        map.put(3, list3);
        map.put(4, list4);
        map.put(5, list5);
        map.put(6, list6);
        map.put(7, list7);
        map.put(8, list8);
        map.put(9, list9);
        char[] chars = digits.toCharArray();
        List<List<String>> list = new ArrayList<>();
        for (Character character : chars) {
            list.add(map.get(character - '0'));
        }
        List<String> res = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        process(0, list, res, tempList);
        return res;
    }

    private void process(int index, List<List<String>> list, List<String> res, List<String> tempList) {
        if (list.size() == tempList.size()) {
            StringBuilder stringBuilder = new StringBuilder();
            tempList.forEach(x -> stringBuilder.append(x));
            res.add(stringBuilder.toString());
            return;
        }
        for (int i = index; i < list.size(); i++) {
            List<String> list1 = list.get(i);
            for (int j = 0; j < list1.size(); j++) {
                tempList.add(list1.get(j));
                process(i + 1, list, res, tempList);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
