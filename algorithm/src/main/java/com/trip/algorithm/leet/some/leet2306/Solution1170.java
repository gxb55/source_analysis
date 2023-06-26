package com.trip.algorithm.leet.some.leet2306;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2023年06月10日 10:16:00
 * 1170. 比较字符串最小字母出现频次
 * 定义一个函数 f(s)，统计 s  中（按字典序比较）最小字母的出现频次 ，其中 s 是一个非空字符串。
 * <p>
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为字典序最小字母是 "c"，它出现了 2 次。
 * <p>
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words 。对于每次查询 queries[i] ，
 * 需统计 words 中满足 f(queries[i]) < f(W) 的 词的数目 ，W 表示词汇表 words 中的每个词。
 * <p>
 * 请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是第 i 次查询的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * 示例 2：
 * <p>
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j]、words[i][j] 都由小写英文字母组成
 * 通过次数19,341提交次数30,580
 */
public class Solution1170 {
    public static void main(String[] args) {
        Solution1170 solution1170 = new Solution1170();
       /* String[] queries = {"bbb", "cc"};
        String[] words = {"a", "aa", "aaa", "aaaa"};*/
        String[] queries = {"cbd"};
        String[] words = {"zaaaz"};
        int[] ints = solution1170.numSmallerByFrequency(queries, words);
        System.out.println(Arrays.toString(ints));
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] arr = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            Character cur = chars[0];
            int sum = 0;
            for (Character character : chars) {
                if (character.equals(cur)) {
                    sum++;
                } else {
                    break;
                }
            }
            arr[i] = sum;
        }
        Arrays.sort(arr);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String word = queries[i];
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            Character cur = chars[0];
            int sum = 0;
            for (Character character : chars) {
                if (character.equals(cur)) {
                    sum++;
                } else {
                    break;
                }
            }
            int s = get(arr, sum);
            res[i] = s;
        }
        return res;
    }

    private int get(int[] arr, int sum) {
        int left = 0;
        int res=-1;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] > sum) {
                right = mid - 1;
            } else {
                res=mid;
                left = mid + 1;
            }
        }
        int t = res+1;

        return arr.length - t;
    }
}
