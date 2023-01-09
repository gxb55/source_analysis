package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xbguo
 * @date 2022/4/19  14:16
 * @description 139
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 * 通过次数281,061提交次数531,629
 */
public class Solution139 {
    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
       /* "leetcode"
                ["leet","code"]*/
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("aaa");
        list.add("aaaa");
       /* list.add("sand");
        list.add("and");
        list.add("cat");*/

        boolean b = solution139.wordBreak(s, list);
        System.out.println(b);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        int min = wordDict.get(0).length();
        int max = wordDict.get(0).length();
        for (String s1 : wordDict) {
            max = Math.max(s1.length(), max);
            min = Math.min(s1.length(), min);
        }
        Set<String> set = new HashSet<>();
        return getResult(s, wordDict, 0, min, max, set);
    }

    private boolean getResult(String str, List<String> result, int index, int min, int max, Set<String> set) {
        if (index == str.length()) {
            return true;
        }

        for (int i = min; i <= max && index + i <= str.length(); i++) {
            String substring = str.substring(index, index + i);
            if (result.contains(substring)) {
                if (!set.contains(str.substring(index + i)) && getResult(str, result, index + i, min, max, set)) {
                    return true;
                } else {
                    set.add(str.substring(index + i));
                }
            }
        }
        return false;
    }
}
