package com.trip.algorithm.zuo.day0613.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Administrator
 * 递归的字符串打印问题
 */
public class Code02_PrintAllSubsequences {
    public static void main(String[] args) {

        List<String> abcd = subs("abcd");
        System.out.println(abcd);
    }

    /**
     * 没有重复的情况
     * 使用set容器将重复的结果去掉比如字符串 aaa 可以有三种情况分别是a a a,对应的是第一个要其他不要，第二个要其他不要，第三个要其他不要
     * @param str
     * @return
     */
    public static Set<String> subsNoRepeat(String str) {
        char[] chars = str.toCharArray();
        Set<String> set = new HashSet<>();
        process2(chars, 0, "", set);
        return set;
    }

    /**
     * 求字符串str的所有子序列 str=abc，没个元素都会有两种选择，要或者不要依次循环递归
     * abc
     * 如果是aaa则会有重复的情况
     *
     * @param str
     * @return
     */
    public static List<String> subs(String str) {
        char[] chars = str.toCharArray();
        List<String> list = new ArrayList<>();
        process1(chars, 0, "", list);
        return list;
    }

    /**
     * @param chars list的数组
     * @param index 数组的第几个是否要
     * @param path 路径
     * @param list 结果集
     */
    public static void process1(char[] chars, Integer index, String path, List<String> list) {
        if (index == chars.length) {
            list.add(path);
            return;
        }
        // 不要这个char
        process1(chars, index+1, path, list);
        // 要这个元素
        path = path + chars[index];
        process1(chars, index+1, path, list);
    }

    /**
     * @param chars list的数组
     * @param index 数组的第几个是否要
     * @param path 路径
     * @param set 结果集 我们直接使用set来对结果集去重
     */
    public static void process2(char[] chars, Integer index, String path, Set<String> set) {
        if (index == chars.length) {
            set.add(path);
            return;
        }
        // 不要这个char
        process2(chars, index+1, path, set);
        // 要这个元素
        path = path + chars[index];
        process2(chars, index+1, path, set);
    }
}
