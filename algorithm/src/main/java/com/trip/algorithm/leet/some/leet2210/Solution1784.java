package com.trip.algorithm.leet.some.leet2210;

/**
 * @author xbguo
 * @createTime 2022年10月07日 16:08:00
 */
public class Solution1784 {
    public static void main(String[] args) {

    }

    public boolean checkOnesSegment(String s) {
        char[] chars = s.toCharArray();
        int len = 0;
        int t=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                len = 0;
            } else {
                t++;
                len++;
            }
            if (len > 1) {
                return true;
            }
            if(t>1){

            }
        }
        return true;
    }
}
