package com.trip.algorithm.leet.some.history;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2022/3/16  17:22
 * @description TODO
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * 通过次数141,774提交次数345,298
 */
public class Solution179 {
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        Solution179 solution179 = new Solution179();
        String s = solution179.largestNumber(arr);
        System.out.println(s);
    }

    public String largestNumber(int[] nums) {
        String[] list = new String[nums.length];
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            list[i] = String.valueOf(nums[i]);
            if (nums[i] != 0) {
                flag = false;
            }
        }
        if(flag){
            return "0";
        }
        Arrays.sort(list, (o1, o2) -> {
            return (o2 + o1).compareTo((o1 + o2));
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }
}
