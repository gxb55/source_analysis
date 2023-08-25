package com.trip.algorithm.leet.leet75.arraystringproblem;

/**
 * @author xbguo
 * @date 2023/8/25 14:54
 */
public class Solution1071 {
    public static void main(String[] args) {
        Solution1071 solution1071 = new Solution1071();
        String str1 = "AAAAAAAAAA";
        String str2 = "AAAAA";
        String s = solution1071.gcdOfStrings(str1, str2);
        System.out.println(s);
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str2.equals(str1)) {
            return str2;
        }
        //短串
        String s1 = str1.length() >= str2.length() ? str2 : str1;
        String s2 = str1.length() >= str2.length() ? str1 : str2;
        String res1 = getRes(s1);
        if (res1 == null) {
            return "";
        }
        String res2 = getRes(s2);
        if (res2 == null) {
            return "";
        }
        if (res1.equals(res2) && res1.length() == 1) {
            int right = s1.length();
            int count = 1;
            for (int i = right; i > 0; i--) {
                if (s1.length() % i == 0 && s2.length() % i == 0) {
                    count = i;
                    break;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (count > 0) {
                stringBuilder.append(res1);
                count--;
            }
            return stringBuilder.toString();
        }
        if (res1.equals(res2)) {
            String pre = res1;
            String cur = pre + pre;
            while (true) {
                if (check(cur, str1, str2)) {
                    pre = cur;
                    cur = cur + res2;
                } else {
                    return pre;
                }
            }
        }
        return "";
    }

    private boolean check(String cur, String str1, String str2) {
        if (cur.length() > str1.length() || cur.length() > str2.length()) {
            return false;
        }
        int i = str1.length() % cur.length();
        int j = str2.length() % cur.length();
        if (i != 0 || j != 0) {
            return false;
        }
        i = str1.length() / cur.length();
        j = str2.length() / cur.length();
        StringBuilder stringBuilder = new StringBuilder();
        while (i > 0) {
            stringBuilder.append(cur);
            i--;
        }
        if (!stringBuilder.toString().equals(str1)) {
            return false;
        }
        stringBuilder = new StringBuilder();
        while (j > 0) {
            stringBuilder.append(cur);
            j--;
        }
        if (!stringBuilder.toString().equals(str2)) {
            return false;
        }
        return true;
    }

    public String getRes(String s1) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (stringBuilder.length() > 0 && chars.length % stringBuilder.length() == 0) {
                StringBuilder stb = new StringBuilder();
                while (stb.length() != chars.length) {
                    stb.append(stringBuilder);
                }
                if (stb.toString().equals(s1)) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(aChar);
        }
        return s1;
    }
}
