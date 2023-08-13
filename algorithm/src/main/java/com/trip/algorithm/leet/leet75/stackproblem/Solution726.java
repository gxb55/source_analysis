package com.trip.algorithm.leet.leet75.stackproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年08月13日 17:36:00
 */
public class Solution726 {
    public static void main(String[] args) {
        Solution726 solution726 = new Solution726();
        //   String formula = "K4(ON(SO3)2)2";
     //   String formula = "Mg(OH)2";
        String formula = "(H)";
        String s = solution726.countOfAtoms(formula);
        System.out.println(s);
    }

    public String countOfAtoms(String formula) {
        String v = process(formula);
        Map<String, Integer> map = new HashMap<>();
        StringBuilder str = new StringBuilder();
        StringBuilder count = new StringBuilder();
        for (int k = 0; k < v.length(); k++) {
            char c = v.charAt(k);
            if (c >= 'A' && c <= 'Z') {
                if (str.length() > 0) {
                    String s = str.toString();
                    int t = 1;
                    if (count.length() > 0) {
                        t = Integer.valueOf(count.toString());
                    }
                    map.put(s, map.getOrDefault(s, 0) + t);
                    str.setLength(0);
                    count.setLength(0);
                }
                str.append(c);
            } else if (c >= '0' && c <= '9') {
                count.append(c);
            } else if (c >= 'a' && c <= 'z') {
                str.append(c);
            }
        }
        if (str.length() > 0) {
            String s = str.toString();
            int t = 1;
            if (count.length() > 0) {
                t = Integer.valueOf(count.toString());
            }
            map.put(s, map.getOrDefault(s, 0) + t);
            str.setLength(0);
            count.setLength(0);
        }
        List<Map.Entry<String, Integer>> collect = map.entrySet().stream().sorted((x, y) -> {
            return x.getKey().compareTo(y.getKey());
        }).collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : collect) {
            stringBuilder.append(entry.getKey());
            if (entry.getValue() > 1) {
                stringBuilder.append(entry.getValue());
            }
        }
        return stringBuilder.toString();
    }

    private String process(String formula) {
        if (!formula.contains(")")) {
            return formula;
        }
        int i = formula.indexOf(")");
        StringBuilder count = new StringBuilder();
        int j = i;
        j++;
        for (; j < formula.length(); j++) {
            char c = formula.charAt(j);
            if (c >= '0' && c <= '9') {
                count.append(c);
            } else {
                break;
            }

        }
        int left = i;
        while (left >= 0) {
            if (formula.charAt(left) == '(') {
                break;
            }
            left--;
        }
        String substring = formula.substring(left + 1, i);
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for (int k = 0; k < substring.length(); k++) {
            char c = substring.charAt(k);
            if (c >= 'A' && c <= 'Z') {
                if (str.length() > 0) {
                    list.add(str.toString());
                    str.setLength(0);
                }
            }
            str.append(c);
        }
        list.add(str.toString());
        List<String> list1 = new ArrayList<>();
        if(count.length()>0){
            Integer integer = Integer.valueOf(count.toString());
            while (integer > 0) {
                list1.addAll(list);
                integer--;
            }
        }else{
            list1.addAll(list);
        }

        String collect = list1.stream().collect(Collectors.joining());
        String substring1 = formula.substring(0, left);
        String substring2 = formula.substring(j);
        String b = substring1 + collect + substring2;
        return process(b);
    }
}
