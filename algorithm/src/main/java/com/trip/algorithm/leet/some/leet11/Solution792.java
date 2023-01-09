package com.trip.algorithm.leet.some.leet11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xbguo
 * @date 2022/11/17 10:00
 * @description Solution792
 * 示例 1:
 * <p>
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 * Example 2:
 * <p>
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-matching-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution792 {
    public static void main(String[] args) {
        Solution792 solution792 = new Solution792();
     /*   String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};*/

        String s = "dsahjpjauf";
        String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        int i = solution792.numMatchingSubseq(s, words);
        System.out.println(i);
    }

    public int numMatchingSubseq(String s, String[] words) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (Character character : chars) {
            s.equals(character);
        }
        int count = 0;
        for (String str : words) {
            int index = 0;
            boolean flag = true;
            char[] chars1 = str.toCharArray();
            for (int i = 0; i < chars1.length; i++) {
                char c = chars1[i];
                if (set.contains(c)) {
                    flag = false;
                    break;
                }
                while (index < chars.length && chars[index] != c) {
                    index++;
                }
                index++;
                if (index >= chars.length && i < (chars1.length)) {
                    if(chars[chars.length -1] != c){
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }


    public int numMatchingSubseq1(String s, String[] words) {
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < s.length(); ++i) {
            pos[s.charAt(i) - 'a'].add(i);
        }
        int res = words.length;
        for (String w : words) {
            if (w.length() > s.length()) {
                --res;
                continue;
            }
            int p = -1;
            for (int i = 0; i < w.length(); ++i) {
                char c = w.charAt(i);
                if (pos[c - 'a'].isEmpty() || pos[c - 'a'].get(pos[c - 'a'].size() - 1) <= p) {
                    --res;
                    break;
                }
                p = binarySearch(pos[c - 'a'], p);
            }
        }
        return res;
    }

    public int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }

}
