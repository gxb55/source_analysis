package com.trip.algorithm.leet.some.leet2209;

/**
 * @author xbguo
 * @createTime 2022年09月07日 08:23:00
 */
public class Solution2064 {
    public static void main(String[] args) {
        Solution2064 solution2064 = new Solution2064();
        int n = 6;
        int[] quantities = {11, 6};
        int i = solution2064.minimizedMaximum(n, quantities);
        System.out.println(i);
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int l = 0;
        int r = 1000000;
        int res = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int len = n;
            int i = 0;
            int min = Integer.MAX_VALUE;
            for (; i < quantities.length; ) {
                if (n <= 0) {
                    break;
                }
                int quantity = quantities[i];
                if (quantity > mid) {
                    quantity -= mid;
                    len--;
                    min = Math.min(min, mid);
                } else {
                    min = Math.min(min, quantity);
                    i++;
                    len--;
                }
            }
            if (len == 0 && i == quantities.length - 1) {
                res = Math.min(res, min);
            }
            if (len > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return res;
    }
}
