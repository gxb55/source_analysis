package com.trip.algorithm.codethink.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/1/11 15:14
 * @description 131
 */
public class Solution131 {
    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
        String s = "aab";
        List<List<String>> partition = solution131.partition(s);
        partition.forEach(x -> {
            System.out.println(x);
        });
    }

    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        String[] strArr = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            strArr[i] = String.valueOf(chars[i]);
        }
        List<List<String>> list = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        process(strArr, 0, tempList, list);
        return list;
    }

    private void process(String[] strArr, int index, List<String> tempList, List<List<String>> list) {
        if (index >= strArr.length && !tempList.isEmpty()) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index; i < strArr.length; i++) {
            String s = strArr[i];
            stringBuilder.append(s);
            if (check(stringBuilder.toString())) {
                String s1 = stringBuilder.toString();
                tempList.add(s1);
                process(strArr, i + 1, tempList, list);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private boolean check(String toString) {
        if (toString.length() == 1) {
            return true;
        }
        return toString.equals(new StringBuilder(toString).reverse().toString());
    }
}
