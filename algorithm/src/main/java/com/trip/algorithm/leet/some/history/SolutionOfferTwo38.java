package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xbguo
 * @date 2021/12/28  19:03
 * @description 字符串的排列
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 * <p>
 * 通过次数200,183提交次数345,080
 */
public class SolutionOfferTwo38 {
    boolean[] vis;

    public static void main(String[] args) {
        SolutionOfferTwo38 solutionOfferTwo38 = new SolutionOfferTwo38();
        String[] permutation = solutionOfferTwo38.permutation("aab");
        System.out.println(Arrays.toString(permutation));
    }

    public String[] permutation(String s) {
        if (s.length() == 1) {
            return new String[]{s};
        }
        char[] chars = s.toCharArray();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        process(chars, tempList, result);

        Set<String> set = new HashSet<>();
        for (int i = 0; i < result.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            List<Integer> list = result.get(i);
            for (Integer integer : list) {
                stringBuilder.append(s.charAt(integer));
            }
            set.add(stringBuilder.toString());
        }
        String[] arr = new String[set.size()];
        int i = 0;
        for (String s1 : set) {
            arr[i] = s1;
            i++;
        }

        return arr;
    }

    /**
     * @param chars    字符串
     * @param tempList 临时结果
     * @param result   整体结果
     */
    private void process(char[] chars, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == chars.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (tempList.contains(i)) {
                continue;
            }
            tempList.add(i);
            process(chars, tempList, result);
            tempList.remove(Integer.valueOf(i));
        }
    }

    public String[] permutation1(String s) {
        if (s.length() == 1) {
            return new String[]{s};
        }
        char[] chars = s.toCharArray();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        vis = new boolean[chars.length];
        int index = 0;
        process(chars, index, tempList, result);
        return null;
    }

    /**
     * @param chars
     * @param index    当前选到第几个数了
     * @param tempList
     * @param result
     */
    private void process(char[] chars, int index, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == chars.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (tempList.contains(i)) {
                continue;
            }
            // TODO 剪枝
            if (i > 0 && chars[i] == chars[i - 1] && !vis[i - 1]) {
                continue;
            }
            tempList.add(i);
            process(chars, index++, tempList, result);
            tempList.remove(Integer.valueOf(i));
        }

    }

}
