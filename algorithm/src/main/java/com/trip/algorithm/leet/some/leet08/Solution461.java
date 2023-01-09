package com.trip.algorithm.leet.some.leet08;

/**
 * @author xbguo
 * @date 2022/8/10  19:29
 * @description Solution461
 */
public class Solution461 {
    public static void main(String[] args) {
        Solution461 solution461 = new Solution461();
        int  x = 1, y = 4;
        int i = solution461.hammingDistance(x,y);
        System.out.println(i);
    }

    public int hammingDistance(int x, int y) {
        String s = Integer.toBinaryString(x);
        String s1 = Integer.toBinaryString(y);
        int sub=0;
        StringBuilder stringBuilder=new StringBuilder();
        if(s.length()>s1.length()){
            sub=s.length()-s1.length();
            for (int i = 0; i < sub; i++) {
                stringBuilder.append("0");
            }
            s1 = stringBuilder.append(s1).toString();
        }else {
            sub=s1.length()-s.length();
            for (int i = 0; i < sub; i++) {
                stringBuilder.append("0");
            }
            s = stringBuilder.append(s).toString();
        }
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            char c = s1.charAt(i);
            if (aChar != c) {
                res++;
            }
        }
        return res;
    }
}
