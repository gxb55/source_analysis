package com.trip.algorithm.codethink.stringcode;

/**
 * @author xbguo
 * @date 2022/11/11 14:21
 * @description TODO
 */
public class Solution_Offer_05 {
    public static void main(String[] args) {

    }

    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (Character character : chars) {
            if (character == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }
}
