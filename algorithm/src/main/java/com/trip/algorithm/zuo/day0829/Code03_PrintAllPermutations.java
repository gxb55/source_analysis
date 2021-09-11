package com.trip.algorithm.zuo.day0829;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串全排列
 */
public class Code03_PrintAllPermutations {
    public static void main(String[] args) {

        String str = "abcd";
        List<String> list = permutationNoRepeat(str);
        System.out.println(list);
    }

    public static List<String> permutation(String str) {
        List<String> list = new ArrayList<>();
        if (StringUtils.isBlank(str)) {
            return list;
        }
        process(str.toCharArray(), 0, list);
        return list;
    }

    /**
     *
     * @param str char数组
     * @param i 下标，当前下标之前的字符拍好了，当前字符之后的字符未排好序
     * @param res 结果集
     */
    public static void process(char[] str, int i, List<String> res) {
        // 如果长度最大则结束
        if (i == str.length - 1) {
            res.add(new String(str));
            return;
        }
        for (int j = i; j < str.length; j++) {
            swap(str, i, j);
            process(str, i + 1, res);
            swap(str, i, j);
        }
    }


    public static List<String> permutationNoRepeat(String str){
        List<String> list = new ArrayList<>();
        if (StringUtils.isBlank(str)) {
            return list;
        }
        process2(str.toCharArray(), 0, list);
        return list;
    }

    /**
     *
     * @param str
     * @param i
     * @param res
     */
    public static void process2(char[] str,int i,List<String> res){
        if(i==str.length){
            res.add(new String(str));
            return;
        }
        boolean[] booleans = new boolean[26];
        for(int j=i;j<str.length;j++){
            if(!booleans[str[j]-'a']){
                swap(str,i,j);
                process2(str,i+1,res);
                swap(str,i,j);
            }
        }
    }

    private static void swap(char[] str, int i, int j) {
        char t = str[i];
        str[i] = str[j];
        str[j] = t;
    }
}
