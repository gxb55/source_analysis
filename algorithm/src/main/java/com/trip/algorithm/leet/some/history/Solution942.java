package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/5/9  23:03
 * @description 942
 * 942. 增减字符串匹配
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 *
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 *
 * 输入：s = "III"
 * 输出：[0,1,2,3]
 * 示例 3：
 *
 * 输入：s = "DDI"
 * 输出：[3,2,0,1]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s 只包含字符 "I" 或 "D"
 * 通过次数54,315提交次数70,355
 */
public class Solution942 {
    public static void main(String[] args) {
        Solution942 solution942 = new Solution942();
        int[] ints = solution942.diStringMatch("IDID");
        System.out.println(Arrays.toString(ints));
    }
    public int[] diStringMatch(String s) {
        int length = s.length();
        int[] arr =new int[length+1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length+1; i++) {
            list.add(i);
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='I'){
                arr[i]= list.get(0);
                list.remove(list.get(0));
            }else if(s.charAt(i)=='D'){
                arr[i]= list.get(list.size()-1);
                list.remove(list.get(list.size()-1));
            }
        }
        arr[length] = list.get(0);
        return arr;
    }
}
