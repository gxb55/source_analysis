package com.trip.algorithm.leet.some.history;

import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年06月05日 21:38:00
 * 524. 通过删除字母匹配到字典里最长单词
 * 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * <p>
 * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 * <p>
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 * 通过次数87,090提交次数174,642
 */
public class Solution524 {
    public static void main(String[] args) {
        Solution524 solution524 = new Solution524();
       /* String s = "abpcplea";
        String[] dictionary = {"ale", "apple", "monkey", "plea"}; */

       /* String s = "abpcplea";
        String[] dictionary = {"a","b","c"}; */

        String s = "wsmzffsupzgauxwokahurhhikapmqitytvcgrfpavbxbmmzdhnrazartkzrnsmoovmiofmilihynvqlmwcihkfskwozyjlnpkgdkayioieztjswgwckmuqnhbvsfoevdynyejihombjppgdgjbqtlauoapqldkuhfbynopisrjsdelsfspzcknfwuwdcgnaxpevwodoegzeisyrlrfqqavfziermslnlclbaejzqglzjzmuprpksjpqgnohjjrpdlofruutojzfmianxsbzfeuabhgeflyhjnyugcnhteicsvjajludwizklkkosrpvhhrgkzctzwcghpxnbsmkxfydkvfevyewqnzniofhsriadsoxjmsswgpiabcbpdjjuffnbvoiwotrbvylmnryckpnyemzkiofwdnpnbhkapsktrkkkakxetvdpfkdlwqhfjyhvlxgywavtmezbgpobhikrnebmevthlzgajyrmnbougmrirsxi";
        String[] dictionary = {"jpthiudqzzeugzwwsngebdeai","nbmxgkduynigvzuyblwjepn","c"};
        String longestWord = solution524.findLongestWord(s, List.of(dictionary));
        System.out.println(longestWord);
    }

    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (int i = 0; i < dictionary.size(); i++) {
            String s1 = dictionary.get(i);
            if (s1.length() > s.length()) {
                continue;
            }
            if(res.length()>s1.length()){
                continue;
            }
            int index1 = 0;
            int index2 = 0;

            while (index2 < s1.length()) {
                char c = s1.charAt(index2);
                boolean flag = false;
                while (index1 < s.length()) {
                    if (c == s.charAt(index1)) {
                        flag = true;
                        index1++;
                        break;
                    }
                    index1++;
                }

                if (!flag) {
                    break;
                }
                index2++;
            }
            // 找到了一个
            if (index2 == s1.length()) {
                if (res.equals("")) {
                    res = s1;
                } else if (s1.length() > res.length()) {
                    res = s1;
                } else if (s1.length() == res.length()) {
                    res = res.compareTo(s1) > 0 ? s1 : res;
                }
            }
        }
        return res;
    }
}
