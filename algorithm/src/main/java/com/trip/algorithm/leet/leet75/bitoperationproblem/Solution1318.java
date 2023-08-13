package com.trip.algorithm.leet.leet75.bitoperationproblem;

import java.util.Objects;

/**
 * @author xbguo
 * @createTime 2023年08月13日 19:33:00
 */
public class Solution1318 {
    public static void main(String[] args) {
    //   int a = 2, b = 6, c = 5;
       int a = 8, b = 3, c = 5;
        int i = minFlips(a,b,c);
        System.out.println(i);
    }

    public static int minFlips(int a, int b, int c) {
        String aStr = Integer.toBinaryString(a);
        String bStr = Integer.toBinaryString(b);
        String cStr = Integer.toBinaryString(c);
        int max=aStr.length();
        max=Math.max(max,bStr.length());
        max=Math.max(max,cStr.length());
        while (aStr.length()<max){
            aStr="0"+aStr;
        }
        while (bStr.length()<max){
            bStr="0"+bStr;
        }
        while (cStr.length()<max){
            cStr="0"+cStr;
        }
        int res = 0;
        int len1 = aStr.length() - 1;
        int len2 = bStr.length() - 1;
        int len3 = cStr.length() - 1;
        while (len3 >= 0) {
            if (len1 >= 0 && len2 >= 0) {
                Integer c1 = Integer.valueOf(aStr.charAt(len1)+"");
                Integer c2 = Integer.valueOf(bStr.charAt(len2)+"");
                Integer c3 = Integer.valueOf(cStr.charAt(len3)+"");
                if ((c1 | c2) != c3) {
                    res++;
                }
                // 都为1的情况要翻转两个
                if(c3==0&&c1==1&&c2==1){
                    res++;
                }
                len2--;
                len1--;
            } else if (len1 >= 0 && len2 < 0) {
                Integer c1 = Integer.valueOf(aStr.charAt(len1)+"");
                Integer c3 = Integer.valueOf(cStr.charAt(len3)+"");
                if (!c1.equals(c3)) {
                    res++;
                }
                len1--;
            } else if (len1 < 0 && len2 >= 0) {
                Integer c2 = Integer.valueOf(bStr.charAt(len2)+"");
                Integer c3 = Integer.valueOf(cStr.charAt(len3)+"");
                if (!Objects.equals(c2, c3)) {
                    res++;
                }
                len2--;
            }
            len3--;
        }
        return res;

    }
}
