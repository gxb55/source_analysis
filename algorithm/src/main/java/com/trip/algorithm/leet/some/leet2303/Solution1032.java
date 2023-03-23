package com.trip.algorithm.leet.some.leet2303;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/3/24 02:55
 * 1032. 字符流
 * 设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 words 中的一个字符串。
 *
 * 例如，words = ["abc", "xyz"] 且字符流中逐个依次加入 4 个字符 'a'、'x'、'y' 和 'z' ，你所设计的算法应当可以检测到 "axyz" 的后缀 "xyz" 与 words 中的字符串 "xyz" 匹配。
 *
 * 按下述要求实现 StreamChecker 类：
 *
 * StreamChecker(String[] words) ：构造函数，用字符串数组 words 初始化数据结构。
 * boolean query(char letter)：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 words 中的某一字符串，返回 true ；否则，返回 false。
 *
 *
 * 示例：
 *
 * 输入：
 * ["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
 * [[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
 * 输出：
 * [null, false, false, false, true, false, true, false, false, false, false, false, true]
 *
 * 解释：
 * StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
 * streamChecker.query("a"); // 返回 False
 * streamChecker.query("b"); // 返回 False
 * streamChecker.query("c"); // 返回n False
 * streamChecker.query("d"); // 返回 True ，因为 'cd' 在 words 中
 * streamChecker.query("e"); // 返回 False
 * streamChecker.query("f"); // 返回 True ，因为 'f' 在 words 中
 * streamChecker.query("g"); // 返回 False
 * streamChecker.query("h"); // 返回 False
 * streamChecker.query("i"); // 返回 False
 * streamChecker.query("j"); // 返回 False
 * streamChecker.query("k"); // 返回 False
 * streamChecker.query("l"); // 返回 True ，因为 'kl' 在 words 中
 */
public class Solution1032 {
    public static void main(String[] args) {
        String[] words = {"cd", "f", "kl"};
        StreamChecker streamChecker = new StreamChecker(words);
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('c'));
        System.out.println(streamChecker.query('d'));
        System.out.println(streamChecker.query('e'));
        System.out.println(streamChecker.query('f'));
        System.out.println(streamChecker.query('g'));
        System.out.println(streamChecker.query('h'));
        System.out.println(streamChecker.query('i'));
        System.out.println(streamChecker.query('j'));
        System.out.println(streamChecker.query('k'));
        System.out.println(streamChecker.query('l'));
        }
}

class StreamChecker {
    Map<Integer, List<String>> map;
    int max = 0;
    String str = "";

    public StreamChecker(String[] words) {
        map = new HashMap<>();

        for (String w : words) {
            int length = w.length();
            max = Math.max(max, length);
            if (map.containsKey(length)) {
                map.get(length).add(w);
            } else {
                List<String> list = new ArrayList<>();
                list.add(w);
                map.put(length, list);
            }
        }
    }

    public boolean query(char letter) {
        str = str + letter;
        if (str.length() > max) {
            str = str.substring(1);
        }
        Set<Map.Entry<Integer, List<String>>> entries = map.entrySet();
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            if (entry.getKey() > str.length()) {
                continue;
            }
            List<String> value = entry.getValue();
            boolean b = value.stream().anyMatch(x -> str.endsWith(x));
            if (b) {
                return true;
            }
        }
        return false;
    }
}


class StreamChecker1 {
    PathTrie pathTrie = new PathTrie();
    StringBuilder stringBuilder = new StringBuilder();

    public StreamChecker1(String[] words) {
        for (String word : words) {
            pathTrie.insert(word);
        }
    }

    public boolean query(char letter) {
        stringBuilder.append(letter);
        return pathTrie.canFind(stringBuilder);
    }

    class PathTrie {
        TrieNode root;

        PathTrie() {
            this.root = new TrieNode();
        }

        private boolean canFind(StringBuilder stringBuilder) {
            TrieNode cur = root;
            for (int i = stringBuilder.length()-1;i>=0;i--) {
                char c = stringBuilder.charAt(i);
                if (cur.childNode[c - 'a'] == null) {
                    return false;
                }
                cur = cur.childNode[c - 'a'];
                if (cur.isWord) {
                    return true;
                }
            }

            return false;
        }

        private void insert(String word) {
            TrieNode cur = root;
            for (int i = word.length()-1;i>=0;i--) {
                char c = word.charAt(i);
                if (cur.childNode[c - 'a'] == null) {
                    cur.childNode[c - 'a'] = new TrieNode();
                }
                cur = cur.childNode[c - 'a'];
            }
            cur.isWord = true;
        }
    }

    class TrieNode {

        TrieNode[] childNode;
        boolean isWord;

        TrieNode() {
            this.childNode = new TrieNode[26];
            this.isWord = false;
        }
    }
}
