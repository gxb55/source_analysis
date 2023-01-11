package com.trip.algorithm.leet.some.leet09;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname Solution698
 * @Description Solution698
 * @Date 2022/9/20 14:40
 * @Created by xbguo
 */
public class Solution698 {
    public static void main(String[] args) {
        Solution698 solution698 = new Solution698();
     /*   int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        */
     /*   int[] nums = {1,2,3,4};
        int k = 3;  */

    /*    int[] nums = {1,1,1,1,2,2,2,2};
        int k = 2;  */

        int[] nums = {4,5,9,3,10,2,10,7,10,8,5,9,4,6,4,9};
        int k = 5;
      /*  int[] nums = {4, 4, 6, 2, 3, 8, 10, 2, 10, 7};
        int k = 4;*/


        boolean b = solution698.canPartitionKSubsets1(nums, k);
        System.out.println(b);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        int cur = sum / k;
        Arrays.sort(nums);
        Integer left = 0;
        Integer right = nums.length - 1;
        while (left < right) {
            int rightVal = nums[right];
            int leftVal = nums[left];
            if (rightVal > cur) {
                return false;
            } else if (rightVal == cur) {
                right--;
            } else {
                if ((leftVal + rightVal) > cur) {
                    return false;
                } else if ((leftVal + rightVal) == cur) {
                    left++;
                    right--;
                } else {
                    sum = 0;
                    while (left < right) {
                        left++;
                        right--;
                        sum = sum + rightVal + leftVal;
                        if (cur == sum) {
                            break;
                        } else if (cur < sum) {
                            if ((sum - leftVal) == cur) {
                                left--;
                                break;
                            } else if ((sum - rightVal) == cur) {
                                right++;
                                break;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }


    public boolean canPartitionKSubsets1(int[] nums, int k) {

        return true;
    }

    private int process(List<Integer> nums, int index, int cur, boolean[] dp, int t) {

        if (t == cur) {
            return 0;
        } else if (t > cur) {
            return 1;
        }
        for (int i = index; i < nums.size(); i++) {
            if (!dp[i]) {
                t=t+nums.get(i);
                dp[i] = true;
                int process = process(nums, index + 1, cur, dp, t);
                if (process == 0) {
                    return 0;
                } else {
                    t=t-nums.get(i);
                    dp[i] = false;
                }
            }
        }
        return -1;
    }
    int[] nums;
    int n, t, k;
    public boolean canPartitionKSubsets3(int[] _nums, int _k) {
        nums = _nums;
        k = _k;
        int tot = 0;
        for (int x : nums) {
            tot += x;
        }
        if (tot % k != 0) {
            return false; // 可行性剪枝
        }
        Arrays.sort(nums);
        n = nums.length;
        t = tot / k;
        return dfs(n - 1, 0, 0, new boolean[n]);
    }

    /**
     * @param idx 下标
     * @param cur 当前元素的和
     * @param cnt 当前的次数
     * @param vis 访问过的元素
     * @return
     */
    boolean dfs(int idx, int cur, int cnt, boolean[] vis) {
        if (cnt == k) {
            return true;
        }
        if (cur == t) {
            return dfs(n - 1, 0, cnt + 1, vis);
        }
        for (int i = idx; i >= 0; i--) {  // 顺序性剪枝
            if (vis[i] || cur + nums[i] > t) {
                continue;  // 可行性剪枝
            }
            vis[i] = true;
            if (dfs(i - 1, cur + nums[i], cnt, vis)) {
                return true;
            }
            vis[i] = false;
            if (cur == 0) {
                return false; // 可行性剪枝
            }
        }
        return false;
    }

}
