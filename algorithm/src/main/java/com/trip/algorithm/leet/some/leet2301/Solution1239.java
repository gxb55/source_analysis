package com.trip.algorithm.leet.some.leet2301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xbguo
 * @createTime 2023年01月04日 21:34:00
 * 示例 1：
 *
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是：
 * - ""
 * - "un"
 * - "iq"
 * - "ue"
 * - "uniq" ("un" + "iq")
 * - "ique" ("iq" + "ue")
 * 最大长度为 4。
 * 示例 2：
 *
 * 输入：arr = ["cha","r","act","ers"]
 * 输出：6
 * 解释：可能的解答有 "chaers" 和 "acters"。
 * 示例 3：
 *
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
 * 输出：26
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-length-of-a-concatenated-string-with-unique-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1239 {
    public static void main(String[] args) {
        Solution1239 solution1239 = new Solution1239();
       // String[] arr = {"un","iq","ue"};
        String[] arr = {"cha","r","act","ers"};
      //  String[] arr = {"abcdefghijklmnopqrstuvwxyz"};
        int i = solution1239.maxLength(List.of(arr));
        System.out.println(i);
    }


    public int maxLength(List<String> arr) {
        List<String> list = new ArrayList<>();
        process(arr, 0, list);
        return max;
    }
    int max = 0;
    Set<Character> set = new HashSet<>();
    private boolean process(List<String> arr, int index, List<String> list) {
        boolean flag1 = true;
        set.clear();
        int len = 0;
       /* if(!list.isEmpty()){
            System.out.println(list);
        }*/
        flag:
        for (String s : list) {
            char[] chars = s.toCharArray();
            len = len + s.length();
            for (Character character : chars) {
                boolean add = set.add(character);
                if (!add) {
                    flag1 = false;
                    break flag;
                }
            }
        }
        if (!flag1) {
            return false;
        } else {
            max = Math.max(max, len);
        }
        if (index >= arr.size()) {
            return false;
        }
        for (int i = index; i < arr.size(); i++) {
            String s = arr.get(i);
            list.add(s);
            boolean process = process(arr, i + 1, list);
            list.remove(s);
           /* if (!process) {
                return false;
            }*/
        }
        return true;
    }
}
