package com.trip.algorithm.leet.some.leet12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/12/15 10:01
 * @description Solution1945
 * 输入：s = "leetcode", k = 2
 * 输出：6
 * 解释：操作如下：
 * - 转化："leetcode" ➝ "(12)(5)(5)(20)(3)(15)(4)(5)" ➝ "12552031545" ➝ 12552031545
 * - 转换 #1：12552031545 ➝ 1 + 2 + 5 + 5 + 2 + 0 + 3 + 1 + 5 + 4 + 5 ➝ 33
 * - 转换 #2：33 ➝ 3 + 3 ➝ 6
 * 因此，结果整数为 6 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sum-of-digits-of-string-after-convert
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1945 {
    public static void main(String[] args) {
        Solution1945 solution1945 = new Solution1945();
        String s = "leetcode";
        int k = 2;
        int lucky = solution1945.getLucky(s, k);
        System.out.println(lucky);
    }

    public int getLucky(String s, int k) {
        List<Integer> list = new ArrayList<>();
        char[] chars1 = s.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            char c = chars1[i];
            list.add(c - 'a'+1);
        }
        for (int i = 0; i < k; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < list.size(); j++) {
                stringBuilder.append(list.get(j));
            }
            char[] chars2 = stringBuilder.toString().toCharArray();
            list.clear();
            int sum=0;
            for (Character character : chars2) {
               sum=sum+(character-'0');
            }
            char[] chars = String.valueOf(sum).toCharArray();
            for (Character character:chars){
                list.add(Integer.valueOf(character-'0'));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int x : list) {
            stringBuilder.append(x);
        }
        return Integer.valueOf(stringBuilder.toString());
    }
}
