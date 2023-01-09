package com.trip.algorithm.leet.some.history;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/5/17  17:14
 * @description 953
 * 953. 验证外星语词典
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * <p>
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 * <p>
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 示例 3：
 * <p>
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 在 words[i] 和 order 中的所有字符都是英文小写字母。
 * 通过次数37,658提交次数65,155
 */
public class Solution953 {
    public static void main(String[] args) {
        Solution953 solution953 = new Solution953();
        /*String[] words = {"app", "apple"};
        String order = "abcdefghijklmnopqrstuvwxyz";*/
       /* String[] words = {"apple", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz";*/
        String[] words = {"word", "world", "row"};
        String order = "worldabcefghijkmnpqstuvxyz";
       /* String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";*/

      /*  String[] words = {"iekm", "tpnhnbe"};
        String order = "loxbzapnmstkhijfcuqdewyvrg";*/

      /*  String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";*/
        boolean alienSorted = solution953.isAlienSorted(words, order);
        System.out.println(alienSorted);
    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = order.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], i);
        }

        List<String> collect = Arrays.stream(words).sorted((x, y) -> {
            char[] chars1 = x.toCharArray();
            char[] chars2 = y.toCharArray();
            int len1 = chars1.length;
            int len2 = chars2.length;
            int xIndex = 0;
            int yIndex = 0;
            while (xIndex < len1 && yIndex < len2) {
                Integer integer = map.get(chars1[xIndex]);
                Integer integer1 = map.get(chars2[yIndex]);
                if (integer.equals(integer1)) {
                    return integer - integer1;
                }
                xIndex++;
                yIndex++;
            }

            return len1 - len2;
        }).collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            if (!collect.get(i).equals(words[i])) {
                return false;
            }
        }
        return true;
    }

}
