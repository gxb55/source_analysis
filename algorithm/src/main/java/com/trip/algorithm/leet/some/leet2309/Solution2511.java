package com.trip.algorithm.leet.some.leet2309;

/**
 * @author xbguo
 * @createTime 2023年09月02日 10:25:00
 */
public class Solution2511 {
    public static void main(String[] args) {
       // int[] forts = {1, 0, 0, -1, 0, 0, 0, 0, 1};
       // int[] forts = {0,0,1,-1};
        int[] forts = {-1,0,-1,0,1,1,1,-1,-1,-1};
        int i = Solution2511.captureForts(forts);
        System.out.println(i);
    }

    public static int captureForts(int[] forts) {
        int count = 0;
        for (int i = 0; i < forts.length; i++) {
            int fort = forts[i];
            if (fort == -1) {
                int left = i - 1;
                while (left >= 0 && forts[left] == 0) {
                    left--;
                }
                if (left >= 0 &&forts[left] == 1) {
                    count = Math.max(count, i - left - 1);
                }
                int right = i + 1;
                while (right < forts.length && forts[right] == 0) {
                    right++;
                }
                if (right < forts.length&&forts[right] == 1) {
                    count = Math.max(count, right - i - 1);
                }
                i = right-1;
            }
        }
        return count;
    }

}
