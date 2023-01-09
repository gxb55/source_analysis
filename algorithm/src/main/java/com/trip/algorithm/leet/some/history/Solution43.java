package com.trip.algorithm.leet.some.history;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2022/4/26  16:39
 * @description 43
 */
public class Solution43 {
    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();

        // String multiply = solution43.multiply("23", "19");
        String multiply = solution43.multiply("123456789", "987654321");
        //String multiply = solution43.multiply("123", "456");
       // String multiply = solution43.multiply("9", "9");
        System.out.println(multiply);
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] result = new int[num1.length() + num2.length()];
        char[] chars = num1.toCharArray();
        char[] chars1 = num2.toCharArray();
        int x = chars.length - 1;
        int y = chars1.length - 1;
        for (int i = x; i >= 0; i--) {
            for (int j = y; j >= 0; j--) {
                int a = chars[i] - '0';
                int b = chars1[j] - '0';
                int mu = (x - i) + (y - j);
                int cur = a * b;
                buildList(result, cur, mu);
            }
        }
        for (int i = result.length - 1; i >= 0; i--) {
            while (result[i] >= 10) {
                result[i - 1] = result[i - 1] + result[i] / 10;
                result[i] = result[i] % 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0 && !flag) {
                flag = true;
            }
            if (flag) {
                stringBuilder.append(result[i]);
            }
        }
        return stringBuilder.toString();
    }

    private void buildList(int[] result, int cur, int mu) {
        int length = result.length - 1;
        System.out.println(cur + "mu" + mu);
        result[length - mu] = result[length - mu] + cur;

        System.out.println(Arrays.toString(result));
    }

}
