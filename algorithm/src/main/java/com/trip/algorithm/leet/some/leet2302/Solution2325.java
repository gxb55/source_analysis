package com.trip.algorithm.leet.some.leet2302;

import java.util.*;

/**
 * @author xbguo
 * @date 2023/2/1 09:31
 * 2325. 解密消息
 * 给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
 * <p>
 * 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
 * 将替换表与普通英文字母表对齐，形成对照表。
 * 按照对照表 替换 message 中的每个字母。
 * 空格 ' ' 保持不变。
 * 例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次），据此，可以得到部分对照表（'h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
 * 返回解密后的消息。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
 * 输出："this is a secret"
 * 解释：对照表如上图所示。
 * 提取 "the quick brown fox jumps over the lazy dog" 中每个字母的首次出现可以得到替换表。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
 * 输出："the five boxing wizards jump quickly"
 * 解释：对照表如上图所示。
 * 提取 "eljuxhpwnyrdgtqkviszcfmabo" 中每个字母的首次出现可以得到替换表。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 26 <= key.length <= 2000
 * key 由小写英文字母及 ' ' 组成
 * key 包含英文字母表中每个字符（'a' 到 'z'）至少一次
 * 1 <= message.length <= 2000
 * message 由小写英文字母和 ' ' 组成
 * 通过次数16,189提交次数19,117
 */
public class Solution2325 {
    public static void main(String[] args) {
        Solution2325 solution2325 = new Solution2325();
      //  String key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        String key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv";


        String message1 = solution2325.decodeMessage(key, message);
        System.out.println(message1);
    }

    public String decodeMessage(String key, String message) {
        char[] chars = key.toCharArray();
        Set<Character> set = new HashSet<>();
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');
        list.add('f');
        list.add('g');
        list.add('h');
        list.add('i');
        list.add('j');
        list.add('k');
        list.add('l');
        list.add('m');
        list.add('n');
        list.add('o');
        list.add('p');
        list.add('q');
        list.add('r');
        list.add('s');
        list.add('t');
        list.add('u');
        list.add('v');
        list.add('w');
        list.add('x');
        list.add('y');
        list.add('z');
        int index = 0;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(aChar==' '){
                continue;
            }
            if (set.add(aChar)) {
                map.put(aChar,list.get(index));
                index++;
            }
            if(set.size()>=26){
                break;
            }
        }
        char[] chars1 = message.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : chars1) {
            stringBuilder.append(map.getOrDefault(character, ' '));
        }
        return stringBuilder.toString();
    }
}
