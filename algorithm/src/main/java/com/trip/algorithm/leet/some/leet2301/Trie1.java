package com.trip.algorithm.leet.some.leet2301;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/1/5 11:16
 * @description 线段树
 */
public class Trie1 {

    public static void main(String[] args) {
        Trie1 trie = new Trie1();
        trie.insert("abc");
        trie.insert("abcdf");
        trie.insert("ca");
        System.out.println(trie);
    }

    Node rootNode;

    public Trie1() {
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

    static class Node {
        private Boolean isWord;
        private Map<Character, Node> map;

        public Node() {
            map = new HashMap<>();
            isWord = false;
        }
    }

}
