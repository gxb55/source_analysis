package com.trip.algorithm.leet.some.leet2210;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年10月07日 16:46:00
 */
public class Solution927 {
    public static void main(String[] args) {
        Solution927 solution927 = new Solution927();
        int[] arr = {1, 0, 1, 0, 1};
        arr = new int[]{1, 1, 0, 1, 1};
        arr = new int[]{1, 1, 0, 0, 1};
        arr = new int[]{0, 1, 1, 0, 0, 1, 1, 1, 1, 1};
        int[] ints = solution927.threeEqualParts(arr);
        System.out.println(Arrays.toString(ints));
    }

    public int[] threeEqualParts(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        int firstZero = 0;
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            if (i1 == 0 && flag == true) {
                firstZero++;
            } else {
                flag = false;
                stringBuilder.append(i1);
            }
        }
        if (firstZero == arr.length) {
            if (firstZero > 3) {
                return new int[]{0, 1};
            } else {
                return new int[]{-1, -1};
            }
        }
        String s = stringBuilder.toString();
        int index = s.length() / 2;
        int i = -1;
        while (true) {
            String s0 = s.substring(0, index);
            String substring1 = s.substring(s.length() - index);
            if (substring1.equals(s0)) {
                String substring = s.substring(index, s.length() - index);
                char[] chars = substring.toCharArray();
                int secondZero = 0;
                stringBuilder = new StringBuilder();
                int len = index;
                flag = true;
                boolean flag1 = true;
                for (int j = 0; j < chars.length; j++) {
                    Character i1 = chars[j];
                    if (i1 == '0' && flag == true) {
                        secondZero++;
                    } else if (len > 0) {
                        flag = false;
                        len--;
                        stringBuilder.append(i1);
                    } else {
                        if (i1 != '0') {
                            flag1 = false;
                            break;
                        }
                    }
                }
                if (flag1 && stringBuilder.toString().equals(s0)) {
                    return new int[]{firstZero + index - 1, firstZero + index + secondZero + index};
                }
            }
            index--;
            if (index <= 0) {
                break;
            }
        }
        return new int[]{-1, -1};
    }
}
