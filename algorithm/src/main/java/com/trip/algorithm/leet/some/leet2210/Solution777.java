package com.trip.algorithm.leet.some.leet2210;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2022年10月07日 15:00:00
 * 777. 在LR字符串中交换相邻字符
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
 * <p>
 * <p>
 * <p>
 * 示例 :
 * <p>
 * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * 输出: True
 * 解释:
 * 我们可以通过以下几步将start转换成end:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= len(start) = len(end) <= 10000。
 * start和end中的字符串仅限于'L', 'R'和'X'。
 */
public class Solution777 {
    public static void main(String[] args) {
        Solution777 solution777 = new Solution777();
       /* String start = "RXXLRXRXL";
        String end = "XRLXXRRLX"; */

      /*  String start = "XXXXXLXXXX";
        String end = "LXXXXXXXXX";*/
/*
        String start = "XXRXLXRXXX";
        String end =   "XXRLXXXXXR"; */

      /*  String start = "XLXRRXXRXX";
        String end =   "LXXXXXXRRR"; */

     /*   String start = "RXR";
        String end =   "XXR";*/
        String start = "XXXXRXLXXXLLXXRLXXLXLXRXLXXRRX";
        String end = "XXXXRLLLXXXXXXRLLLXXXXXRLXXXRR";


       /* String start = "LXXLXRLXXL";
        String end =   "XLLXRXLXLX";*/


        boolean b = solution777.canTransform(start, end);
        System.out.println(b);
    }
    //"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"

    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        if (start.equals(end)) {
            return true;
        }
        Map<String, String> map = new HashMap<>();
        map.put("XL", "LX");
        map.put("RX", "XR");
        char[] chars = start.toCharArray();
        char[] chars1 = end.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars1[i]) {
                if ((i + 1) < chars.length) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(chars[i]);
                    stringBuilder.append(chars[i + 1]);

                    StringBuilder stringBuilder1 = new StringBuilder();
                    stringBuilder1.append(chars1[i]);
                    stringBuilder1.append(chars1[i + 1]);

                    String s = stringBuilder.toString();
                    String s1 = stringBuilder1.toString();
                    if (map.containsKey(s) && map.get(s).equals(s1)) {
                        i++;
                    } else {
                        char c = chars1[i];
                        char aChar = chars[i];
                        if (aChar == 'X' && c == 'L') {
                            boolean flag = false;
                            for (int j = i; j < chars.length; j++) {
                                if (chars[j] == 'X') {

                                } else if (chars[j] == 'R') {
                                    return false;
                                } else {
                                    chars[j] = 'X';
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) {
                                continue;
                            }
                        } else if (aChar == 'R' && c == 'X') {
                            int len = check(start, chars, chars1, i);
                            if (len != -1) {
                                i = i + len;
                                continue;
                            }
                        }
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private int check(String start, char[] chars, char[] chars1, int i) {
        int x = 0;
        int r = 0;
        int j = i;
        for (; j < chars.length; j++) {
            if (chars[j] == 'L' || chars1[j] == 'L') {
                if (x == 0 && r == 0) {
                    break;
                } else {
                    return -1;
                }
            }
            if (chars[j] == 'X') {
                x++;
            } else if (chars[j] == 'R') {
                r++;
            }

            if (chars1[j] == 'X') {
                x--;
            } else if (chars1[j] == 'R') {
                r--;
            }
            if (x == 0 && r == 0) {
                break;
            }
        }
        if (x == 0 && r == 0 && start.substring(i, j+1).indexOf("RX") != -1) {
            return j - i;
        }
        return -1;
    }
}
