package com.trip.algorithm.leet.l24.l100;

public class Solution41 {
    public static void main(String[] args) {
        int[] arr={3,4,-1,1};
        int i = firstMissingPositive(arr);
        System.out.println(i);
    }

    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        // 从1 到 length 对应下标要-1；
        for (int i = 0; i < nums.length; i++) {
            // 不用处理这些
            if (nums[i] <= 0 || nums[i] > length) {
                continue;
            }
            //对应的下标是 val-1
            int t = i;
            while (true) {
                // 如果他的值，不是下标+1，即下标0，存的是1，下标1存的是2
                if (nums[t] != t + 1) {
                    int val = nums[t];
                    int nextVal = nums[val-1];
                    if (nextVal <= 0 || nextVal > length||val==nextVal) {
                        int num = nums[t];
                        nums[t] = nums[val-1];
                        nums[val-1] = num;
                        break;
                    }
                    int num = nums[t];
                    nums[t] = nums[val-1];
                    nums[val-1] = num;
                   // t = val-1;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if(nums[i]!=(i+1)){
                return i+1;
            }
        }
        return length+1;
    }
}
