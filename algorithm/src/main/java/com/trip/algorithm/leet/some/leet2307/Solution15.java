package com.trip.algorithm.leet.some.leet2307;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年07月09日 10:16:00
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution15 {
    public static void main(String[] args) {
        //int[] nums = {-1, 0, 1, 2, -1, -4};
      //  int[] nums = {0, 0, 0, 0};
        int[] nums = {-2,0,0,2,2};
        // int[] nums = {-2,0,1,1,2};
        List<List<Integer>> list = threeSum(nums);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 当前值大于0，后面的值也都大于0，不存在合法解
            if (num > 0) {
                continue;
            }
            // 如果当前值和上一值一样，则计算过了，直接跳过
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int res = 0 - num;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int leftVal = nums[left];
                int rightVal = nums[right];
                int val = leftVal + rightVal;
                if (val == res) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(num);
                    tempList.add(leftVal);
                    tempList.add(rightVal);
                    list.add(tempList);
                    while (left<nums.length&&leftVal==nums[left]){
                        left++;
                    }
                    while (right>=0&&rightVal==nums[right]){
                        right--;
                    }
                } else if (val > res) {
                    right--;
                } else if (val < res) {
                    left++;
                }
            }
        }
        return list;
    }
}
