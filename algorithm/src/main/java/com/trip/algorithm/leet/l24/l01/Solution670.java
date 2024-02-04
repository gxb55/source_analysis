package com.trip.algorithm.leet.l24.l01;

/**
 * @author xbguo
 * @date 2024/1/22 15:03
 */
public class Solution670 {
    public static void main(String[] args) {
        Solution670 solution670 = new Solution670();
        //  int cur = 9973;
        // int cur = 98368;
        int cur = 1993;
        int i = solution670.maximumSwap(cur);
        System.out.println(i);
    }

    public int maximumSwap(int num) {
        String val = String.valueOf(num);
        int left = 0;
        int right = -1;
        char[] charArray = val.toCharArray();
        boolean flag = false;
        while (left < val.length()) {
            while (left < val.length() && val.charAt(left) == '9') {
                left++;
            }
            for (int i = left + 1; i < charArray.length; i++) {
                if (charArray[i] > charArray[left] && (right == -1 || charArray[i] >= charArray[right])) {
                    right = i;
                    flag = true;
                }
            }
            if (flag) {
                break;
            }
            left++;
        }
        if (!flag) {
            return num;
        }

        char c = charArray[left];
        charArray[left] = charArray[right];
        charArray[right] = c;
        String string = new String(charArray);
        return Integer.parseInt(string);
    }
}
