package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/6/23  15:23
 * @description 30. 串联所有单词的子串
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] 由小写英文字母组成
 */
public class Solution32 {
    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
      /*  String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"}; */

      /*  String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"}; */
/*

        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
*/


        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = {"fooo","barr","wing","ding","wing"};

    /*    String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "word"};
*/
        List<Integer> substring = solution32.findSubstring(s, words);
        System.out.println(substring);

    }

    public List<Integer> findSubstring(String s, String[] words) {
        int len = words.length;
        int x = words[0].length();
        int sum = len * x;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i += x) {
            if ((sum + i) > s.length()) {
                break;
            }
            boolean flag = true;
            String substring = s.substring(i, i + sum);
            for (String str : words) {
                int length = substring.length();
                substring = substring.replaceFirst(str, "");
                if (substring.length() == length) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(i);
            }
        }
        return list;
    }


}
