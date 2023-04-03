package com.trip.algorithm.leet.some.leet2303;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/3/29 14:44
 */
public class Solution1641 {
    public static void main(String[] args) {
        Solution1641 solution1641 = new Solution1641();
        int i = solution1641.countVowelStrings(33);
        //66045
        System.out.println(i);
    }

    public int countVowelStrings(int n) {
        String[] arr = new String[]{"a", "e", "i", "o", "u"};
        Set<String> set = new HashSet<>();
        LinkedList<String> strings = new LinkedList<>();
        process(arr, 0, n, strings, set);
        System.out.println(set);
        return set.size();
    }

    private void process(String[] arr, int i, int len, LinkedList<String> stringBuffer, Set<String> set) {
        if (i >= arr.length) {
            return;
        }
        if (stringBuffer.size() == len) {
            StringBuffer stringBuffer1 = new StringBuffer();
            stringBuffer.forEach(x->{
                stringBuffer1.append(x);
            });
            set.add(stringBuffer1.toString());
            return;
        }

        for (int j = i; j < arr.length; j++) {
            stringBuffer.addLast(arr[j]);
            process(arr, j, len, stringBuffer, set);
            stringBuffer.pollLast();
        }
    }
}
