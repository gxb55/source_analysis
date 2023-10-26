package com.trip.algorithm.leet.some.leet2310;

/**
 * @author xbguo
 * @date 2023/10/25 11:11
 */
public class Solution2698 {
    public static void main(String[] args) {
        Solution2698 solution2698 = new Solution2698();
        //int n = 37;
        int n = 994;
        int i = solution2698.punishmentNumber(n);
        System.out.println(i);
    }

    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int k = i * i;
            boolean process = process(String.valueOf(k), 0, 0, i);
            if (process) {
                System.out.println(k + "----" + i);
                sum = sum + k;
            }
        }
        System.out.println();
        return sum;
    }

    private boolean process(String toCharArray, int index, int sum, int k) {
        if (index >= toCharArray.length()) {
            if (sum == k) {
                return true;
            }
            return false;
        }
        if (sum > k) {
            return false;
        }
        boolean flag = false;
        char c = toCharArray.charAt(index);
        if (c == '0') {
            flag = flag || process(toCharArray, index + 1, sum + 0, k);
            if (flag) {
                return true;
            }
            return false;
        }
        for (int i = index; i < toCharArray.length(); i++) {
            String substring = toCharArray.substring(index, i + 1);
            flag = flag || process(toCharArray, i + 1, sum + Integer.valueOf(substring), k);
            if (flag) {
                return true;
            }

        }
        if (flag) {
            return true;
        }
        return false;
    }


}
