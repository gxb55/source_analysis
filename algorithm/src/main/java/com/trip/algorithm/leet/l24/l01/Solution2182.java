package com.trip.algorithm.leet.l24.l01;

public class Solution2182 {
    public static void main(String[] args) {
        Solution2182 solution2182 = new Solution2182();
        // String s = "aababab";
        String s = "cczazcc";
        int repeatLimit = 3;
        String string = solution2182.repeatLimitedString(s, repeatLimit);
        System.out.println(string);
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr = new int[26];
        char[] charArray = s.toCharArray();
        for (Character c : charArray) {
            arr[c - 'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int index = arr.length - 1;
        while (true) {
            while (index >= 0 && arr[index] == 0) {
                index--;
            }
            if (index < 0) {
                break;
            }
            int t = index - 1;
            int len = repeatLimit;
            int i = arr[index];
            if (i <= repeatLimit) {
                while (i > 0) {
                    Character val = (char) ('a' + index);
                    stringBuilder.append(val);
                    arr[index]--;
                    i--;
                }
            } else {
                while (len > 0) {
                    Character val = (char) ('a' + index);
                    stringBuilder.append(val);
                    arr[index]--;
                    len--;
                }
                if (index == 0) {
                    break;
                }
                while ((t) >= 0 && arr[t] == 0) {
                    t--;
                }
                if (t < 0) {
                    break;
                }
                Character val = (char) ('a' + t);
                stringBuilder.append(val);
                arr[t]--;
            }
        }
        return stringBuilder.toString();
    }
}
