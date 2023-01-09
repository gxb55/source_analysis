package com.trip.algorithm.leet.some.history;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/4/27  21:45
 * @description TODO
 * 面试题 16.02. 单词频率
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 *
 * 你的实现应该支持如下操作：
 *
 * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 * get(word)查询指定单词在书中出现的频率
 * 示例：
 *
 * WordsFrequency wordsFrequency = new WordsFrequency({"i", "have", "an", "apple", "he", "have", "a", "pen"});
 * wordsFrequency.get("you"); //返回0，"you"没有出现过
 * wordsFrequency.get("have"); //返回2，"have"出现2次
 * wordsFrequency.get("an"); //返回1
 * wordsFrequency.get("apple"); //返回1
 * wordsFrequency.get("pen"); //返回1
 * 提示：
 *
 * book[i]中只包含小写字母
 * 1 <= book.length <= 100000
 * 1 <= book[i].length <= 10
 * get函数的调用次数不会超过100000
 * 通过次数18,562提交次数24,181
 */
public class Solution1602 {
    public static void main(String[] args) {
       Character[] characters = new Character[1];
       StringBuilder stringBuilder = new StringBuilder();
       String str="aa";
       stringBuilder.append(str, 2, 8);

    }
}

class WordsFrequency {
    public Map<String, Integer> map;

    public WordsFrequency(String[] book) {
        map = new HashMap();
        for (String str : book) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
    }

    public int get(String word) {
        Integer integer = map.get(word);
        if (integer == null) {
            return 0;
        }
        return integer;
    }
}
