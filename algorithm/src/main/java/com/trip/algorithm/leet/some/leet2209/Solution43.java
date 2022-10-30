package com.trip.algorithm.leet.some.leet2209;

/**
 * @author xbguo
 * @createTime 2022年09月26日 22:34:00
 */
public class Solution43 {
    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        String num1 = "5";
        String num2 = "12";
        String multiply = solution43.multiply(num1, num2);
        System.out.println(multiply);
    }

    public String multiply(String num1, String num2) {
        int[] arr = new int[num2.length() + num1.length()];
        if (num2.equals("0") || num1.equals("0")) {
            return "0";
        }
        char[] chars = num1.toCharArray();
        char[] chars1 = num2.toCharArray();
        int length = arr.length;
        int len = chars1.length;
        for (int i = chars1.length - 1; i >= 0; i--) {
            int x = chars1[i] - '0';
            int t = len - i;
            for (int j = chars.length - 1; j >= 0; j--) {
                int y = chars[j] - '0';
                arr[length - t] =arr[length - t]+ x * y;
                parseArr(arr);
                t++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        for (int i : arr) {
            if (flag && i == 0) {
                continue;
            } else {
                flag = false;
                stringBuilder.append(i);
            }
        }
        return stringBuilder.toString();
    }

    private void parseArr(int[] arr) {
        int length = arr.length;
        int t = 0;
        for (int i = length - 1; i >= 0; i--) {
            int val = arr[i];
            if (val >= 10) {
                t = val / 10;
                val = val % 10;
            }
            arr[i] = val;
            if ((i - 1) >=0) {
                arr[i - 1] = arr[i - 1] + t;
            }
            t = 0;
        }
    }
}
