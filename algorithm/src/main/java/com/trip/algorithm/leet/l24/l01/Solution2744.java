package com.trip.algorithm.leet.l24.l01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/1/17 11:19
 */
public class Solution2744 {
    public static void main(String[] args) {
        String[] words = {"cd", "ac", "dc", "ca", "zz"};
        int i = maximumNumberOfStringPairs(words);
        System.out.println(i);
    }

    public static int maximumNumberOfStringPairs(String[] words) {
        List<String> list = new ArrayList<>();
        for (String str : words) {
            list.add(str);
        }
        int count = 0;
        for (String str : words) {
            if (list.contains(str)) {
                StringBuffer stringBuffer = new StringBuffer(str);
                String string = stringBuffer.reverse().toString();
                if (str.equals(string)) {
                    if (list.remove(str) && list.remove(str)) {
                        count++;
                        list.remove(str);
                        list.remove(string);
                        continue;
                    }
                }
                if (list.contains(string)) {
                    count++;
                    list.remove(str);
                    list.remove(string);
                }
            }
        }
        return count;
    }
}
