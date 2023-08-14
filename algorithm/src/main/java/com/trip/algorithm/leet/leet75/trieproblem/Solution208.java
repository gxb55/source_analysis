package com.trip.algorithm.leet.leet75.trieproblem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/8/14 15:57
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 */
public class Solution208 {
    public static void main(String[] args) {
        Trie trie =new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode(false, null, new HashMap<>());
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            TrieNode trieNode = cur.getMap().get(aChar);
            if (trieNode == null) {
                boolean flag = i == chars.length - 1;
                TrieNode node = new TrieNode(flag, aChar, new HashMap<>());
                cur.getMap().put(aChar, node);
            }else{
                if(i == chars.length - 1){
                    trieNode.setEndFlag(true);
                }
            }
            cur = cur.getMap().get(aChar);
        }
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            TrieNode trieNode = cur.getMap().get(aChar);
            if (trieNode == null) {
                return false;
            }
            cur = cur.getMap().get(aChar);
        }
        if (cur == null) {
            return false;
        }
        return cur.getEndFlag();
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            TrieNode trieNode = cur.getMap().get(aChar);
            if (trieNode == null) {
                return false;
            }
            cur = cur.getMap().get(aChar);
        }
        if (cur == null) {
            return false;
        }
        return true;
    }
}

class TrieNode {
    private Boolean endFlag;
    private Character character;
    private Map<Character, TrieNode> map;

    public TrieNode(Boolean endFlag, Character character, Map<Character, TrieNode> map) {
        this.endFlag = endFlag;
        this.character = character;
        this.map = map;
    }

    public Boolean getEndFlag() {
        return endFlag;
    }

    public void setEndFlag(Boolean endFlag) {
        this.endFlag = endFlag;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Map<Character, TrieNode> getMap() {
        return map;
    }

    public void setMap(Map<Character, TrieNode> map) {
        this.map = map;
    }
}