package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/6/16  20:24
 * @description 187. 重复的DNA序列
 * 187. 重复的DNA序列
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 * <p>
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * <p>
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 * <p>
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 105
 * s[i]=='A'、'C'、'G' or 'T'
 * 通过次数103,449提交次数195,873
 */
public class Solution187 {
    public static void main(String[] args) {
        Solution187 solution187 = new Solution187();
        String str = "AAAAAAAAAAAAA";
        List<String> repeatedDnaSequences = solution187.findRepeatedDnaSequences(str);
        System.out.println(repeatedDnaSequences);

    }

    public List<String> findRepeatedDnaSequences(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        Map<String,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (stringBuilder.length() == 10) {
                String s1 = stringBuilder.toString();
                stringBuilder.setLength(0);
                stringBuilder.append(s1.substring(1)).append(aChar);
            } else {
                stringBuilder.append(aChar);
            }
            if (stringBuilder.length() == 10) {
                String s1 = stringBuilder.toString();
                Integer integer = map.get(s1);
                if(integer==null){
                    map.put(s1,1);
                }else{
                    map.put(s1,integer+1);
                }
            }
        }
        List<String> strings = new ArrayList<>();
        map.entrySet().stream().filter(x->x.getValue()>1).forEach(x->strings.add(x.getKey()));
        return strings;
    }
}
