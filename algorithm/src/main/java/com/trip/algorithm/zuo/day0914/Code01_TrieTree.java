package com.trip.algorithm.zuo.day0914;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串转化为 前缀树
 */
public class Code01_TrieTree {
    /**
     * 前缀树的节点信息
     */
    public static class TrieNode {
        private int pass;
        private int end;
        private TrieNode[] nexts;// Map<char,TrieNode> map 如果字符过多可以用这种情况

        public TrieNode() {
            nexts = new TrieNode[26];
            // 多少个字符以它作为开始
            pass = 0;
            // 多少个字符以它作为结束
            end = 0;
        }
    }

    public static class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (StringUtils.isBlank(word)) {
                return;
            }
            char[] chars = word.toCharArray();
            root.pass++;
            TrieNode temp = root;
            for (char c : chars) {
                int index = c - 'a';
                if (temp.nexts[index] == null) {
                    temp.nexts[index] = new TrieNode();
                }
                temp.nexts[index].pass++;
                temp = temp.nexts[index];
            }
            temp.end++;
        }

        /**
         * 查找word这个单词出现过几次
         * 其实就是找到word这个单词对应node的end
         *
         * @param word
         */
        public int search(String word) {
            if (StringUtils.isBlank(word)) {
                return 0;
            }
            TrieNode temp = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int index = c - 'a';
                TrieNode next = temp.nexts[index];
                if (next == null) {
                    return 0;
                }
                temp = next;
            }
            return temp.end;
        }

        /**
         * 有多少字符串以word字符代表的字符作为开头
         *
         * @param word
         * @return
         */
        public int prefixNumber(String word) {
            if (StringUtils.isBlank(word)) {
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode temp = root;
            for (char c : chars) {
                int index = c - 'a';
                TrieNode next = temp.nexts[index];
                if (next == null) {
                    return 0;
                }
                temp = next;
            }
            return temp.pass;
        }

        /**
         * 删除word字符，其实就是沿途中的点p--最后一个点 end--
         *
         * @param word
         */
        public void delete(String word) {
            // 元素是空或者元素不存在直接结束
            if (StringUtils.isBlank(word)) {
                return;
            }
            if (search(word) == 0) {
                return;
            }
            char[] chars = word.toCharArray();
            root.pass--;
            TrieNode temp = root;
            for (char c : chars) {
                int index = c - 'a';
                TrieNode next = temp.nexts[index];
                next.pass--;
                // 如果删的过程中发现只有一个字符串经过这里则直接删除肯定是我们要找的字符串
                // 比如 abc ac ad ae，现在要删除abc 到b的时候b.pass-- ==0 即经过b的只有一个就是我们要找的直接干掉
                if (next.pass == 0) {
                    temp.nexts[index] = null;
                    return;
                }
                temp = next;
            }
            temp.end--;

        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        //trie.insert("abc");
        trie.insert("abc");
        trie.insert("babc");

        int abc = trie.search("abcdd");
        trie.delete("abc");
        System.out.println(abc);
        System.out.println(trie.root);
    }

}
