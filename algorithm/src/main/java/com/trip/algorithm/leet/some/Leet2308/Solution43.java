package com.trip.algorithm.leet.some.Leet2308;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年07月30日 09:38:00
 */
public class Solution43 {
    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
          String num1 = "123", num2 = "456";
       // String num1 = "5", num2 = "12";
        String multiply = solution43.multiply1(num1, num2);
        System.out.println(multiply);

    }

    public String multiply1(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int[] res = new int[chars2.length + chars1.length];
        for (int i = chars1.length - 1; i >= 0; i--) {
            for (int j = chars2.length - 1; j >= 0; j--) {
                int val = (chars1[i] - '0') * (chars2[j] - '0');
                res[i + j + 1] =  res[i + j + 1]+val;
            }
        }
        for (int i = res.length-1; i > 0; i--) {
            Integer val = res[i];
            int k = val % 10;
            int z = val / 10;
            res[i] = k;
            res[i - 1] = res[i - 1] + z;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int x : res) {
            stringBuilder.append(x);
        }
        String s = stringBuilder.toString();
        if (s.startsWith("0")) {
            s = s.substring(1 );
        }
        return s;
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] chars = num1.toCharArray();
        char[] chars1 = num2.toCharArray();
        int i = chars.length - 1;
        int index = i;
        Map<Integer, String> map = new HashMap<>();
        int max = 0;
        while (i >= 0) {
            int val = chars[i] - '0';
            String s = getRes(val, chars1);
            int len = index - i;
            while (len > 0) {
                s = s + '0';
                len--;
            }
            map.put(i, s);
            i--;
            max = Math.max(max, s.length());
        }
        Collection<String> values = map.values();
        StringBuilder stringBuilder = new StringBuilder();
        Integer last = 0;
        for (int j = 0; j < max; j++) {
            int cur = 0;
            for (String v : values) {
                int k = v.length() - j - 1;
                if (k >= 0) {
                    cur = cur + (v.charAt(k) - '0');
                }
            }
            cur += last;
            int x = cur % 10;
            last = cur / 10;
            stringBuilder.append(x);
        }
        if (last != 0) {
            stringBuilder.append(last);
        }
        StringBuilder reverse = stringBuilder.reverse();
        return reverse.toString();
    }

    private String getRes(int val, char[] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        Integer last = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int i1 = val * (chars[i] - '0');
            i1 = i1 + last;
            int i2 = i1 % 10;
            last = i1 / 10;
            stringBuilder.append(i2);
        }
        if (last != 0) {
            stringBuilder.append(last);
        }
        StringBuilder reverse = stringBuilder.reverse();
        return reverse.toString();
    }
}
