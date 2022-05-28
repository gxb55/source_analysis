package com.trip.algorithm.leet.some;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年03月26日 21:09:00
 * <p>
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * <p>
 *  
 * 示例 1 ：
 * <p>
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 示例 2 ：
 * <p>
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 ：
 * <p>
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet_402 {
    public static void main(String[] args) {
        Leet_402 leet_402 = new Leet_402();
        String num = "10001";
        int k = 4;
        String s = leet_402.removeKdigits1(num, k);
        System.out.println(s);
    }

    public String removeKdigits1(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        List<Character> list = new ArrayList<Character>();
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character aChar = chars[i];
            if (list.isEmpty()) {
                list.add(aChar);
            } else {
                while (!list.isEmpty()) {
                    Character character = list.get(list.size() - 1);
                    if (character.compareTo(aChar) > 0 && k > 0) {
                        list.remove(list.size() - 1);
                        k--;
                    } else {
                        break;
                    }
                }
                list.add(aChar);
            }
        }
        boolean b = list.stream().allMatch(x -> x.equals('0'));
        if(b){
            return "0";
        }
        boolean falg = true;
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : list) {
            if (falg && character.equals('0')) {
                continue;
            }
            falg = false;
            stringBuilder.append(character);
        }
        if (k > 0) {
            if(k>=stringBuilder.length()){
                return "0";
            }
            return stringBuilder.substring(0, stringBuilder.length() - k);
        }
        return stringBuilder.toString();
    }

    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        String temp = num;
        String min = num;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < temp.length(); j++) {
                String str = null;
                if (j == 0) {
                    str = temp.substring(1);
                } else {
                    str = temp.substring(0, j) + temp.substring(j + 1);
                }
                while (true) {
                    if (str.equals("0") || str.equals("")) {
                        return "0";
                    }
                    if (str.substring(0, 1).equals("0")) {
                        str = str.substring(1);
                    } else {
                        break;
                    }
                }
                if (str.length() < min.length()) {
                    min = str;
                } else if (str.length() == min.length()) {
                    if (min.compareTo(str) > 0) {
                        min = str;
                    }
                }

            }
            temp = min;
        }
        return min;
    }
}
