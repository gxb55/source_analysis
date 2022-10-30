package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年05月30日 22:39:00
 * 383. 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 * 通过次数177,317提交次数277,149
 */
public class Solution383 {
    public static void main(String[] args) {
        Solution383 solution383 = new Solution383();
        String ransomNote = "aa", magazine = "aab";
        boolean b = solution383.canConstruct(ransomNote, magazine);
        System.out.println(b);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        char[] chars = magazine.toCharArray();
        for (Character character : chars) {
            arr[character - 'a']++;
        }
        char[] chars1 = ransomNote.toCharArray();
        for (Character character : chars1) {
            int i = character - 'a';
            arr[i]--;
            if (arr[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
