package com.trip.algorithm.zuo.day0829;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Administrator
 * 打印所有子序列
 */
public class Code2_PrintAllSubsquences {
    public static void main(String[] args) {
        List<String> list = subs("abc");
        System.out.println(list);

        Set<String> set = subsNoRepeat("aaa");
        System.out.println(set);
    }


    /**
     * 打印子序列，不重复，可以直接将打印子序列的结果集缓存set即可
     * @param str
     * @return
     */
    public static Set<String> subsNoRepeat(String str){
        Set<String> set = new HashSet<>();
        String path = "";
        char[] chs = str.toCharArray();
        // 老师
        process2(chs,0,set,path);
        return set;
    }

    private static void process2(char[] chs, int index, Set<String> set, String path) {
        if(index == chs.length){
            set.add(path);
            return;
        }
        String no = path;
        process2(chs,index+1,set,no);
        String yes = path+chs[index];
        process2(chs,index+1,set,yes);
    }


    /**
     * 打印所有子序列
     * @param str
     * @return
     */
    public static List<String> subs(String str){
        List<String> list = new ArrayList<>();
        String path = "";
        char[] chs = str.toCharArray();
        // 老师
        process1(chs,0,list,path);
        // 我自己写的
       // print(chs, 0, list, path);
        return list;
    }

    private static void process1(char[] chs, int index, List<String> list, String path) {
        if(index == chs.length){
            list.add(path);
            return;
        }
        String no = path;
        process1(chs,index+1,list,no);
        String yes = path+chs[index];
        process1(chs,index+1,list,yes);
    }


    /**
     * 打印子序列，abc，每个元素都是要或者不要所以递归实现
     *
     * @param chars 固定参数
     * @param index 当前来到的下标，元素 要或者不要
     * @param result 结果集，递归结束时候放入其中，即元素到达了最后一个
     * @param str 沿途路径形成的子串
     */
    public static void print(char[] chars, int index, List<String> result, String str) {
        if (index == chars.length) {
            result.add(str);
            return;
        }
        print(chars, index + 1, result, str + chars[index]);
        print(chars, index + 1, result, str);
    }
}
