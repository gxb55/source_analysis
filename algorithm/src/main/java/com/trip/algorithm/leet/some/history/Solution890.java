package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2022年06月12日 15:53:00
 * 890. 查找和替换模式
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 * <p>
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 * <p>
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 * <p>
 * 返回 words 中与给定模式匹配的单词列表。
 * <p>
 * 你可以按任何顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 * 通过次数19,770提交次数25,350
 */
public class Solution890 {
    public static void main(String[] args) {
        Solution890 solution890 = new Solution890();
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        List<String> list = solution890.findAndReplacePattern(words, pattern);
        System.out.println(list);
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        char[] chars = pattern.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (String s : words) {
            map.clear();
            if (s.length() != pattern.length()) {
                continue;
            } else if (s.equals(pattern)) {
                list.add(s);
            } else {
                boolean tempFlag = true;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    // pattern
                    char aChar = chars[i];
                    if (map.containsKey(aChar)) {
                        boolean flag = map.get(aChar).equals(c);
                        if (!flag) {
                            tempFlag = false;
                            break;
                        }
                    } else {
                        map.put(aChar, c);
                    }
                }
                if (tempFlag && map.values().stream().distinct().collect(Collectors.toList()).size() == map.size()) {
                    list.add(s);
                }
            }
        }
        return list;


    }
}
