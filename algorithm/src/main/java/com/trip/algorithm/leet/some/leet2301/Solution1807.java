package com.trip.algorithm.leet.some.leet2301;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/1/12 19:31
 * @description 1807
 */
public class Solution1807 {
    public static void main(String[] args) {
        Solution1807 solution1807 = new Solution1807();
        String s = "(name)is(age)yearsold";
        String[][] knowledge = {{"name", "bob"}, {"age", "two"}};
        List<List<String>> list = new ArrayList<>();
        for (String[] strings:knowledge){
            List<String> temp = new ArrayList<>();
            temp.add(strings[0]);
            temp.add(strings[1]);
            list.add(temp);
        }
        String evaluate = solution1807.evaluate(s, list);
        System.out.println(evaluate);
    }

    public String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> map = new HashMap<>();
        for (List<String> strings : knowledge) {
            map.put(strings.get(0), strings.get(1));
        }
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder tempBuilder = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '(') {
                flag = true;
            } else if (aChar == ')') {
                flag = false;
                String s1 = map.get(tempBuilder.toString());
                stringBuilder.append(s1 == null ? "?" : s1);
                tempBuilder.setLength(0);
            } else if (flag) {
                tempBuilder.append(aChar);
            } else if (!flag) {
                stringBuilder.append(aChar);
            }
        }
        return stringBuilder.toString();
    }
}
