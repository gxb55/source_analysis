package com.trip.algorithm.leet.some.leet08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/8/11  14:24
 * @description 208. 实现 Trie (前缀树)
 * 208. 实现 Trie (前缀树)
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 *
 * 示例：
 *
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 *
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 *
 *
 * 提示：
 *
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 */
public class Solution208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

   static class Trie {
        Node rootNode;

        public Trie() {
            rootNode = new Node();
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            Node curNode = rootNode;
            for (Character character : chars) {
                if (curNode.map.get(character) == null) {
                    curNode.map.put(character, new Node());
                }
                curNode = curNode.map.get(character);
            }
            curNode.isWord = true;
        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();
            Node curNode = rootNode;
            for (Character character : chars) {
                curNode = curNode.map.get(character);
                if (curNode == null) {
                    return false;
                }
            }
            return curNode.isWord;
        }

        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            Node curNode = rootNode;
            for (Character character : chars) {
                curNode = curNode.map.get(character);
                if (curNode == null) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Node {
        private Boolean isWord;
        private Map<Character, Node> map;

        public Node() {
            map = new HashMap<>();
            isWord=false;
        }
    }
}
