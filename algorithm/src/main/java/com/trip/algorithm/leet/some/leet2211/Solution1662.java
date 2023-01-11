package com.trip.algorithm.leet.some.leet2211;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年11月01日 21:20:00
 */
public class Solution1662 {
    public static void main(String[] args) {

    }
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        Arrays.stream(word2).forEach(x->stringBuilder1.append(x));
        Arrays.stream(word1).forEach(x->stringBuilder2.append(x));
        return stringBuilder1.toString().equals(stringBuilder2.toString());
    }
}
