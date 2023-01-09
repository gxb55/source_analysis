package com.trip.algorithm.leet.some.leet12;

/**
 * @author xbguo
 * @date 2022/12/13 14:52
 * @description Solution1832
 * 1832. 判断句子是否为全字母句
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * <p>
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 * <p>
 * 如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 * 示例 2：
 * <p>
 * 输入：sentence = "leetcode"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= sentence.length <= 1000
 * sentence 由小写英语字母组成
 * 通过次数36,873提交次数43,264
 */
public class Solution1832 {
    public static void main(String[] args) {

    }

    public boolean checkIfPangram(String sentence) {
        if(sentence.length()<26){
            return false;
        }
        char[] chars = sentence.toCharArray();
        int[] dp = new int[26];
        for (Character character:chars){
            int i = character - 'a';
            dp[i]++;
        }
        for (int x:dp){
            if(x==0){
                return false;
            }
        }
        return true;
    }
}
