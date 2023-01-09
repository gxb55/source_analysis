package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/4/20  15:24
 * @description 140
 * 140. 单词拆分 II
 * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 * <p>
 * 注意：词典中的同一个单词可能在分段中被重复使用多次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * 输出:["cats and dog","cat sand dog"]
 * 示例 2：
 * <p>
 * 输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * 输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * 输出:[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中所有字符串都 不同
 */
public class Solution140 {
    public static void main(String[] args) {
        Solution140 solution140 = new Solution140();

        String str = "aaaaaaa";
        String[] wordDict = {"aaaa","aa","a"};
        List<String> collect = Arrays.stream(wordDict).collect(Collectors.toList());
        List<String> list = solution140.wordBreak(str, collect);
        for (String s : list) {
            System.out.println(s);
        }
    }

    private int max;
    private int min;
    private Set set = new HashSet();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (wordDict.contains(s)) {
            result.add(s);
            return result;
        }
        List<String> list = new ArrayList<>();
        max = wordDict.get(0).length();
        min = wordDict.get(0).length();
        for (String w : wordDict) {
            max = Math.max(max, w.length());
            min = Math.min(min, w.length());
        }
        List<String> tempList = new ArrayList<>();
        int index = 0;
        getResult(s, wordDict, index, list, tempList);
        return list.stream().distinct().collect(Collectors.toList());
    }

    private boolean getResult(String s, List<String> wordDict, int index, List<String> list, List<String> tempList) {
        if (index == s.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s1 : tempList) {
                stringBuilder.append(" ").append(s1);
            }
            list.add(stringBuilder.toString().trim());
            return true;
        }
        for (int i = min; i <= max && (index + i) <= s.length(); i++) {
            String substring = s.substring(index, index + i);
            String substring1 = s.substring(index + i);
            if (wordDict.contains(substring)) {
                tempList.add(substring);
                boolean flag = getResult(s, wordDict, index + i, list, tempList);
                tempList.remove(substring);
                if(!flag){
                    set.add(substring1);
                }
            }
        }
        return false;
    }
}
