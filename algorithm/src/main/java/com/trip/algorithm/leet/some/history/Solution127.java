package com.trip.algorithm.leet.some.history;

import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年06月03日 12:55:00
 * 127. 单词接龙
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 * <p>
 * 每一对相邻的单词只差一个字母。
 * 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 示例 2：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 * 通过次数151,944提交次数319,188
 */
public class Solution127 {
    public static void main(String[] args) {
        Solution127 solution127 = new Solution127();
       /* String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log"};*/


      /*  String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};*/
        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        int i = solution127.ladderLength(beginWord, endWord, List.of(wordList));
        System.out.println(i);
    }

    int res = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        boolean[] vis = new boolean[wordList.size()];
        bfs(beginWord, endWord, wordList, vis);
        if (res == Integer.MAX_VALUE) {
            return 0;
        }
        return res + 1;
    }


    private void bfs(String beginWord, String endWord, List<String> wordList, boolean[] vis) {
        if (beginWord == endWord) {
            int i = 0;
            for (boolean f : vis) {
                if (f) {
                    i++;
                }
            }
            res = Math.min(res, i);
            return;
        }

        for (int i = 0; i < wordList.size(); i++) {
            if (vis[i]) {
                continue;
            }
            if (check(wordList.get(i), beginWord)) {
                vis[i] = true;
                bfs(wordList.get(i), endWord, wordList, vis);
                vis[i] = false;
            }
        }

    }

    private boolean check(String s, String beginWord) {
        if (s.length() == beginWord.length()) {
            int i = 0;
            int sum = 0;
            while (i < s.length()) {
                if (s.charAt(i) != beginWord.charAt(i)) {
                    sum++;
                }
                i++;
                if (sum > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
