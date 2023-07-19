package com.trip.algorithm.leet.some.leet2307;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年07月15日 17:28:00
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution18 {
    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
       /* int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0; */

        /* int[] nums = {2,2,2,2,2};
        int target = 8;*/

       /* int[] nums = {-4, -3, -2, -1, 0, 0, 1, 2, 3, 4};
        int target = 0;*/

       /* int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
        int target = -9;*/

        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target =   -294967296;

        List<List<Integer>> list = solution18.fourSum(nums, target);
        for (List<Integer> temp : list) {
            System.out.println(temp);
        }
        System.out.println(list.size());


        int r=0;
        int w=0;
        List<String> list1 = new ArrayList<>();
        for (int i = r; i <w; ) {

        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long x = nums[i];
                long y = nums[j];
                list.remove(j);
                list.remove(i);
                List<int[]> res = getRes(target - x - y, list);
                list.add(i, (int) x);
                list.add(j, (int) y);
                if (!res.isEmpty()) {
                    for (int k = 0; k < res.size(); k++) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add((int) x);
                        tempList.add((int) y);
                        tempList.add(res.get(k)[0]);
                        tempList.add(res.get(k)[1]);
                        tempList.sort(Integer::compareTo);
                        resList.add(tempList);
                    }
                }
            }
        }
        return resList.stream().distinct().collect(Collectors.toList());
    }

    private List<int[]> getRes(long val, List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        List<int[]> list1 = new ArrayList<>();
        while (left < right) {
            Integer leftVal = list.get(left);
            Integer rightVal = list.get(right);
            long curVal = leftVal + rightVal;
            if (leftVal > val) {
              //  break;
            }
            if (curVal > val) {
                right--;
            } else if (curVal < val) {
                left++;
            } else {
                list1.add(new int[]{leftVal, rightVal});
                while (left < right && leftVal.equals(list.get(left))) {
                    left++;
                }
                while (left < right && rightVal.equals(list.get(right))) {
                    right--;
                }
            }
        }
        return list1;
    }
}
