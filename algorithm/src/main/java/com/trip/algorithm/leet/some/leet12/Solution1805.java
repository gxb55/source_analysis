package com.trip.algorithm.leet.some.leet12;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @date 2022/12/6 10:06
 * @description Solution1805
 * 1805. 字符串中不同整数的数目
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 * <p>
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 * <p>
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 * <p>
 * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "a123bc34d8ef34"
 * 输出：3
 * 解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
 * 示例 2：
 * <p>
 * 输入：word = "leet1234code234"
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：word = "a1b01c001"
 * 输出：1
 * 解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 1000
 * word 由数字和小写英文字母组成
 * 通过次数19,823提交次数44,482
 */
public class Solution1805 {
    public static void main(String[] args) {
        Solution1805 solution1805 = new Solution1805();
        // String word = "a123bc34d8ef34";
        //  String word = "a1b01c001";
        //  String word = "leet1234code234";
         //String word = "0a0";
        // String word = "a123bc34d8ef34";
        String word = "xtimt5kqkz9osexe56ezwwninlyeeqsq5m99904os3ygs12t31n1et4uwzmt5kvv6teisobuxt10k33v1aaxysg4y8nsivxdp3fo9dr7x58m8uc4ofm41ai77u8cvzr5r3s97f5otns59ubqk57xwl00xsp9w2oodt6yxcbscloyr9c2su8gca1ly6rrjufm25luhxhesxwn7bk1as9na4cbabxk";
       /* int i = solution1805.numDifferentIntegers(word);
        System.out.println(i);*/
        System.out.println(solution1805.numDifferentIntegers1(word));
        System.out.println(solution1805.numDifferentIntegersq(word));
    }

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        char[] chars = word.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int aChar = chars[i] - '0';
            if (aChar >= 0 && aChar <= 9) {
                stringBuilder.append(aChar);
            } else {
                if (stringBuilder.length() > 0) {
                    String s = stringBuilder.toString();
                    int begin = 0;
                    for (int j = 0; j < s.length() && s.length() != 1; j++) {
                        if (s.charAt(j) == '0') {
                            begin++;
                        } else {
                            break;
                        }
                    }
                    s = s.substring(begin);
                    if (s.length() > 0) {
                        set.add(s);
                    }else{
                        set.add("0");
                    }
                    stringBuilder.setLength(0);
                }
            }
        }
        if (stringBuilder.length() > 0) {
            String s = stringBuilder.toString();
            int begin = 0;
            for (int j = 0; j < s.length() && s.length() != 1; j++) {
                if (s.charAt(j) == '0') {
                    begin++;
                } else {
                    break;
                }
            }
            s = s.substring(begin);
            if (s.length() > 0) {
                set.add(s);
            }else{
                set.add("0");
            }
        }

        return set.size();
    }

    public Set<String>  numDifferentIntegers1(String word) {
        Set<String> set = new HashSet<>();
        char[] chars = word.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            int aChar = chars[i] - '0';
            if (aChar >= 0 && aChar <= 9) {
                stringBuilder.append(aChar);
                flag = true;
            } else {
                if (flag) {
                    stringBuilder.append("-");
                }
                flag = false;
            }
        }
        String[] split = stringBuilder.toString().split("-");
        for (String s : split) {

            if (s.length() > 1) {
                int begin = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '0') {
                        begin++;
                    } else {
                        break;
                    }
                }
                s = s.substring(begin);
                if(s.length()>0){
                    set.add(s);
                }
            }else{
                if(s.length()>0){
                    set.add(s);
                }
            }
        }
        return set;
    }

    public Set<String> numDifferentIntegersq(String word) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) <= '9') {
                int j = i;
                while (j < word.length() && word.charAt(j) <= '9') j++;
                while (i < j && word.charAt(i) == '0') i++;
                String substring = word.substring(i, j);
                set.add(substring);
                i = j;
            }
        }
        return set;
    }
}
