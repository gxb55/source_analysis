package com.trip.algorithm.leet.l24.l08;

import java.util.*;

public class Solution676 {
    public static void main(String[] args) {
        MagicDictionary dictionary = new MagicDictionary();
        String[] arr = {"hello", "leetcode"};
        dictionary.buildDict(arr);
        // System.out.println(dictionary.search("hello"));
        System.out.println(dictionary.search("hhllo"));
        System.out.println(dictionary.search("leetcoded"));
    }
}

class MagicDictionary1 {
    DictTree tree;
    Set<Integer> set;


    public MagicDictionary1() {
        tree = new DictTree();
        set = new HashSet<>();
        tree.setCharacter(' ');

    }

    public void buildDict(String[] dictionary) {
        DictTree dictTree = tree;
        DictTree tree1 = tree;
        for (String s : dictionary) {
            set.add(s.length());
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                DictTree dictTree2 = null;
                if (i == 0) {
                    dictTree2 = tree1.getDictTreeMap().get(c);
                    dictTree = tree1;
                } else {
                    dictTree2 = dictTree.getDictTreeMap().get(c);
                }

                if (dictTree2 != null) {
                    dictTree = dictTree2;
                } else {
                    DictTree dictTree1 = new DictTree(c);
                    dictTree.getDictTreeMap().put(c, dictTree1);
                    dictTree.getList().add(c);
                    dictTree = dictTree1;
                }
                if (i == charArray.length - 1) {
                    dictTree.setEndFlag(true);
                }
            }
        }
    }

    public boolean search(String searchWord) {
        if(!set.contains(searchWord.length())){
            return false;
        }

        char[] charArray = searchWord.toCharArray();
        DictTree dictTree = tree;
        boolean flag = false;
        for (int i = 0; i < charArray.length; i++) {
            Character c = charArray[i];
            DictTree dictTree1 = dictTree.getDictTreeMap().get(c);
            if (dictTree1 != null) {
                dictTree = dictTree1;
            } else {
                for (Map.Entry<Character, DictTree> entry : dictTree.getDictTreeMap().entrySet()) {
                    flag = flag || check(i + 1, entry.getValue(), charArray);
                    if (flag) {
                        return true;
                    }
                }

            }
        }
        return flag;
    }

    private boolean check(int index, DictTree dictTree, char[] charArray) {
        for (int i = index; i < charArray.length; i++) {
            Character c = charArray[i];
            DictTree dictTree1 = dictTree.getDictTreeMap().get(c);
            if (dictTree1 != null) {
                dictTree = dictTree1;
            } else {
                return false;
            }
        }
        return dictTree.isEndFlag();
    }
}

class DictTree {
    private Character character;
    private List<Character> list;
    private boolean endFlag;
    private Map<Character, DictTree> dictTreeMap;

    public DictTree(Character character) {
        this.list = new ArrayList<>();
        this.character = character;
        this.dictTreeMap = new HashMap<>();
        this.endFlag = false;
    }

    public DictTree() {
        this.list = new ArrayList<>();
        this.dictTreeMap = new HashMap<>();
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public List<Character> getList() {
        return list;
    }

    public void setList(List<Character> list) {
        this.list = list;
    }

    public Map<Character, DictTree> getDictTreeMap() {
        return dictTreeMap;
    }

    public void setDictTreeMap(Map<Character, DictTree> dictTreeMap) {
        this.dictTreeMap = dictTreeMap;
    }

    public boolean isEndFlag() {
        return endFlag;
    }

    public void setEndFlag(boolean endFlag) {
        this.endFlag = endFlag;
    }
}