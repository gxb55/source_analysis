package com.trip.algorithm.leet.l24.l08;

public class Solution3007 {
    public static void main(String[] args) {
        long k = 9;
        int x = 1;
         k = 7;
         x = 2;
        long maximumNumber = findMaximumNumber(k, x);
        System.out.println(maximumNumber);
    }

    public static long findMaximumNumber(long k, int x) {
        long count = 0;
        int cur = 0;
        while (count <= k) {
            cur++;
            String binaryString = Integer.toBinaryString(cur);
            String string = new StringBuffer(binaryString).reverse().toString();
            char[] charArray = string.toCharArray();
            int index = 1;
            int curCount = 0;
            while (((index * x) - 1) < charArray.length) {
                char c = charArray[((index * x) - 1)];
                if (c == '1') {
                    curCount++;
                }
                index++;
            }
            count = curCount + count;
        }
        return cur - 1;
    }
}
