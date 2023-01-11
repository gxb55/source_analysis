package com.trip.algorithm.leet.some.leet08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/8/18  20:22
 * @description TODO
 */
public class Solution6 {
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
      /*  String str = "PAYPALISHIRING";
        int row = 4;*/

      /*  String str = "PAYPALISHIRING";
        int row = 4; */

        String str = "ABCDE";
        int row = 4;
        String convert = solution6.convert(str, row);
        System.out.println(convert);
    }

    public String convert(String s, int numRows) {
        List<List<String>> list = new ArrayList<>();
        if (numRows == 1) {
            return s;
        }
        int index = 0;
        int i = 0;
        while (i < s.length()) {
            List<String> list1 = new ArrayList<>();
            index = 0;
            for (; index < numRows && i < s.length(); index++, i++) {
                list1.add(String.valueOf(s.charAt(i)));
            }
            list.add(list1);
            index = 0;

            int j = 2;
            for (; index < numRows - 2&&i<s.length(); index++, i++) {
                list1 = new ArrayList<>();
                int count = numRows - j;
                for (int k = 0; k < count; k++) {
                    list1.add(" ");
                }
                list1.add(String.valueOf(s.charAt(i)));
                list.add(list1);
                j++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.get(0).size();
        int k = 0;

        while (k < size) {
            for (int j = 0; j < list.size(); j++) {
                List<String> list1 = list.get(j);
                for (; k < size; k++) {
                    if (list1.size() > k) {
                        String s1 = list1.get(k);
                        if (!s1.equals(" ")) {
                            stringBuilder.append(s1);
                        }
                    }
                    break;
                }
            }
            k++;
        }

        return stringBuilder.toString();
    }
}
