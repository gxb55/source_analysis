package com.trip.algorithm.leet.some.leet10;

/**
 * @auther: xbguo
 * @date: 2022/10/31 10:03
 * @description: 481
 */
public class Solution481 {
    public static void main(String[] args) {
        Solution481 solution481 = new Solution481();
        int n = 4;
        int i = solution481.magicalString(n);
        System.out.println(i);
    }

    public int magicalString(int n) {
        if (n <= 3) {
            return 1;
        }
        Character[] str = new Character[n];
        Character[] indexStr = new Character[n];
        str[0] = '1';
        str[1] = '2';
        str[2] = '2';
        indexStr[0] = '1';
        indexStr[1] = '2';
        int index1 = 3;
        int index2 = 2;
        int res = 1;
        while (index1 < n) {
            Character character = str[index2];
            if (character == '1') {
                Character character1 = str[index1 - 1];
                if (character1 == '1') {
                    str[index1] = '2';
                } else {
                    str[index1] = '1';
                    res++;
                }
                indexStr[index2] = '1';
                index2++;
                index1++;
            } else {
                Character character1 = str[index1 - 1];
                if (character1 == '1') {
                    str[index1] = '2';
                    index1++;
                    if(index1>=str.length){
                        break;
                    }
                    str[index1] = '2';
                    index1++;
                } else {
                    str[index1] = '1';
                    index1++;
                    res++;
                    if(index1>=str.length){
                        break;
                    }
                    str[index1] = '1';
                    index1++;
                    res++;
                }
                indexStr[index2] = '2';
                index2++;
            }
        }
        return res;
    }
}