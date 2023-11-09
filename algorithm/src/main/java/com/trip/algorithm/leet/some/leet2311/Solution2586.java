package com.trip.algorithm.leet.some.leet2311;

/**
 * @author xbguo
 * @date 2023/11/7 16:54
 * @description TODO
 */
public class Solution2586 {
    public static void main(String[] args) {

    }
    public int vowelStrings(String[] words, int left, int right) {
        int count=0;
        for (int i = left; i <=right; i++) {
            String word = words[i];
            boolean b = word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o") || word.startsWith("u");
            boolean a = word.endsWith("a") || word.endsWith("e") || word.endsWith("i") || word.endsWith("o") || word.endsWith("u");
            if(a&b){
                count++;
            }
        }
        return count;
    }
}
