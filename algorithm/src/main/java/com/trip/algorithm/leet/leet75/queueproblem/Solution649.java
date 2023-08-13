package com.trip.algorithm.leet.leet75.queueproblem;

/**
 * @author xbguo
 * @createTime 2023年08月12日 12:43:00
 * Radiant（天辉）和 Dire（夜魇）
 * 输入：senate = "RD"
 * 输出："Radiant"
 * 解释：
 * 第 1 轮时，第一个参议员来自 Radiant 阵营，他可以使用第一项权利让第二个参议员失去所有权利。
 * 这一轮中，第二个参议员将会被跳过，因为他的权利被禁止了。
 * 第 2 轮时，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人。
 * 示例 2：
 * <p>
 * 输入：senate = "RDD"
 * 输出："Dire"
 */
public class Solution649 {
    public static void main(String[] args) {
        Solution649 solution649 = new Solution649();
      //  String senate = "RD";
        String senate = "RDD";
        String s = solution649.predictPartyVictory(senate);
        System.out.println(s);
    }

    public String predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();
        boolean flag ;
        int next ;
        while (true) {
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                if (aChar == 'R') {
                    next = i + 1;
                    flag = true;
                    while (next % chars.length != i) {
                        if (chars[next % chars.length] == 'D') {
                            chars[next % chars.length] = 'X';
                            flag = false;
                            break;
                        }
                        next++;
                    }
                    if (flag) {
                        return "Radiant";
                    }
                } else if (aChar == 'D') {
                    next = i + 1;
                    flag = true;
                    while (next % chars.length != i) {
                        if (chars[next % chars.length] == 'R') {
                            chars[next % chars.length] = 'X';
                            flag = false;
                            break;
                        }
                        next++;
                    }
                    if (flag) {
                        return "Dire";
                    }
                }
            }
        }


    }
}
