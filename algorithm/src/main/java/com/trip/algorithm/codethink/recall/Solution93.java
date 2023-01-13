package com.trip.algorithm.codethink.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/1/11 15:37
 * @description 93
 * 93. 复原 IP 地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * s 仅由数字组成
 * 通过次数297,811提交次数516,224
 */
public class Solution93 {
    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
       // String s = "25525511135";
      //  String s = "0000";
        String s = "101023";
        List<String> list = solution93.restoreIpAddresses(s);
        System.out.println(list);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        char[] chars = s.toCharArray();
        process(chars, 0, tempList, list);
        return list;
    }

    private void process(char[] chars, int index, List<String> tempList, List<String> list) {
        if (index >= chars.length && tempList.size() == 4) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String aChar : tempList) {
                stringBuilder.append(aChar).append(".");
            }
            stringBuilder.setLength(stringBuilder.length() - 1);
            list.add(stringBuilder.toString());
            return;
        } else if (tempList.size() >= 4 && index < chars.length) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index; i < chars.length; i++) {
            char aChar = chars[i];
            stringBuilder.append(aChar);
            if (check(stringBuilder)) {
                tempList.add(stringBuilder.toString());
                process(chars, i + 1, tempList, list);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private boolean check(StringBuilder stringBuilder) {
        String str = stringBuilder.toString();
        if (str.equals("0")) {
            return true;
        } else if (str.startsWith("0")) {
            return false;
        } else if (str.length() > 3) {
            return false;
        }
        Integer integer = Integer.valueOf(str);
        return integer >= 0 && integer <= 255;
    }
}
