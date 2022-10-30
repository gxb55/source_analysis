package com.trip.algorithm.leet.some.everday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2022年08月06日 10:19:00
 * 1408. 数组中的字符串匹配
 * 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
 * <p>
 * 如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["mass","as","hero","superhero"]
 * 输出：["as","hero"]
 * 解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
 * ["hero","as"] 也是有效的答案。
 * 示例 2：
 * <p>
 * 输入：words = ["leetcode","et","code"]
 * 输出：["et","code"]
 * 解释："et" 和 "code" 都是 "leetcode" 的子字符串。
 * 示例 3：
 * <p>
 * 输入：words = ["blue","green","bu"]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 30
 * words[i] 仅包含小写英文字母。
 * 题目数据 保证 每个 words[i] 都是独一无二的。
 * 通过次数23,054提交次数36,219
 */
public class Solution1408 {
    public static void main(String[] args) {
        Solution1408 solution1408 = new Solution1408();
        //String[] words = {"mass", "as", "hero", "superhero"};
        String[] words = {"leetcoder","leetcode","od","hamlet","am"};
        List<String> list = solution1408.stringMatching(words);
        System.out.println(list);
    }

    public List<String> stringMatching(String[] words) {
        List<String> collect = Arrays.stream(words).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < collect.size(); i++) {
            String str = collect.get(i);
            for (int j = i + 1; j < collect.size(); j++) {
                if (collect.get(j).contains(str)) {
                    list.add(str);
                    break;
                }
            }
        }
        return list;
    }
}
