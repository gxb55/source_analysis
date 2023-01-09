package com.trip.algorithm.leet.some.leet12;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/12/29 09:58
 * @description Solution30
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * <p>
 *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 * <p>
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联字串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
 * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
 * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
 * 输出顺序无关紧要。返回 [9,0] 也是可以的。
 * 示例 2：
 * <p>
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
 * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
 * 所以我们返回一个空数组。
 * 示例 3：
 * <p>
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
 * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
 * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
 * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] 和 s 由小写英文字母组成
 * 通过次数149,319提交次数377,464
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution30 {
    public static void main(String[] args) {
        Solution30 solution30 = new Solution30();
       /* String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"}; */

       /* String s = "wordgoodgoodgoodbestword";
        String[] words = {"bar","foo","the"};*/

    /*    String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};*/

        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};

        List<Integer> substring = solution30.findSubstring(s, words);
        System.out.println(substring);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        String word = words[0];
        int i = word.length() * words.length;
        if (s.length() < i) {
            return list;
        }
        List<String> strList1 = Arrays.stream(words).collect(Collectors.toList());
        Map<String, Integer> strMap = new HashMap<>();
        for (int j = 0; j < word.length(); j++) {
            strMap.clear();
            for (String str : words) {
                Integer integer = strMap.get(str);
                if (integer == null) {
                    strMap.put(str, 1);
                } else {
                    strMap.put(str, integer + 1);
                }
            }
            for (int k = j + word.length(); k <= s.length(); k += word.length()) {
                if ((k - i - word.length()) >= 0) {
                    String substring = s.substring(k - i - word.length(), k - i);
                    if (strList1.contains(substring)) {
                        strMap.put(substring, strMap.get(substring) + 1);
                    }
                }
                String substring = s.substring(k - word.length(), k);
                if (strList1.contains(substring)) {
                    strMap.put(substring, strMap.get(substring) - 1);
                }
                if (k >= i && strMap.values().stream().allMatch(x -> x == 0)) {
                    list.add(k - i);
                }
            }
        }
        return list;
    }
}
