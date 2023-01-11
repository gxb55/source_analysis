package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/4/27  21:59
 * @description 676
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * <p>
 * 实现 MagicDictionary 类：
 * <p>
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * 输出
 * [null, null, false, true, false, false]
 * <p>
 * 解释
 * MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // 返回 False
 * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
 * magicDictionary.search("hell"); // 返回 False
 * magicDictionary.search("leetcoded"); // 返回 False
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= dictionary.length <= 100
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写英文字母组成
 * dictionary 中的所有字符串 互不相同
 * 1 <= searchWord.length <= 100
 * searchWord 仅由小写英文字母组成
 * buildDict 仅在 search 之前调用一次
 * 最多调用 100 次 search
 * 通过次数10,335提交次数17,300
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-magic-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution676 {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] str = {"hello", "leetcode"};
        magicDictionary.buildDict(str);
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("aello"));
    }
}

class MagicDictionary {
    Map<Integer, List<String>> map;

    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            int length = s.length();
            if (map.containsKey(length)) {
                map.get(length).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(length, list);
            }
        }
    }

    public boolean search(String searchWord) {
        int length = searchWord.length();
        List<String> list = map.get(length);
        if (list == null) {
            return false;
        }
        for (String str : list) {
            if (check(str, searchWord)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(String str, String searchWord) {
        if (str.equals(searchWord)) {
            return false;
        }
        char[] chars1 = str.toCharArray();
        char[] chars2 = searchWord.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                sum++;
            }
            if (sum > 1) {
                break;
            }
        }
        if (sum == 1) {
            return true;
        } else {
            return false;
        }
    }

}