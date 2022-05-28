package com.trip.algorithm.zuo.day0914;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法
 * ab,ac,ef,eas,era,ewq
 * 按照最小字典序来组成一个字符串
 *
 */
public class Code02_LowestLexicography {
    public static class Mycomparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }
    }

    public static String lowestString(String[] strs){
        if(strs==null||strs.length==0){
            return "";
        }
        Arrays.sort(strs,new Mycomparator());
        StringBuilder str =new StringBuilder();
        for (String s:strs){
            str.append(s);
        }
        return str.toString();

    }
    public static void main(String[] args) {

    }
}
