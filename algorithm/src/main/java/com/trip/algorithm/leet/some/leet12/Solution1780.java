package com.trip.algorithm.leet.some.leet12;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @date 2022/12/9 09:39
 * @description Solution1780
 * 1780. 判断一个数字是否可以表示成三的幂的和
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 * <p>
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：true
 * 解释：12 = 31 + 32
 * 示例 2：
 * <p>
 * 输入：n = 91
 * 输出：true
 * 解释：91 = 30 + 32 + 34
 * 示例 3：
 * <p>
 * 输入：n = 21
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 107
 */
public class Solution1780 {
    public static void main(String[] args) {
        Solution1780 solution1780 = new Solution1780();
       //int n = 12;
       // int n = 18;
        int n = 21;
        boolean b = solution1780.checkPowersOfThree(n);
        boolean b1 = solution1780.checkPowersOfThree1(n);
        System.out.println(b);
        System.out.println(b1);
    }

    public boolean checkPowersOfThree(int n) {
        if(n==2){
            return false;
        }else if(n==3){
            return true;
        }
        Set<Integer> set = new HashSet<>();
        int temp = n;
        int cur = 1;
        int index = 0;
        while (true) {
            while (temp >= cur) {
                cur = cur * 3;
                index++;
            }
            temp = temp - (cur / 3);
            index--;
            if (!set.add(index)) {
                return false;
            }
            cur = 1;
            index=0;
            if(temp<3){
                break;
            }
        }
        if(temp==2){
            return false;
        }
        return true;
    }

    public boolean checkPowersOfThree1(int n) {
        while (n != 0) {
            if (n % 3 == 0 || n % 3 == 1) {
                n = n / 3; // 满足三进制
            } else {
                return false; // 不满足三进制，返回false
            }
        }
        return true;
    }




}
