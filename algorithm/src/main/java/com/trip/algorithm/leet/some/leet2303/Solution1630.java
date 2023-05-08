package com.trip.algorithm.leet.some.leet2303;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年03月23日 20:25:00
 * 示例 1：
 * <p>
 * 输入：nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
 * 输出：[true,false,true]
 * 解释：
 * 第 0 个查询，对应子数组 [4,6,5] 。可以重新排列为等差数列 [6,5,4] 。
 * 第 1 个查询，对应子数组 [4,6,5,9] 。无法重新排列形成等差数列。
 * 第 2 个查询，对应子数组 [5,9,3,7] 。可以重新排列为等差数列 [3,5,7,9] 。
 * 示例 2：
 * <p>
 * 输入：nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
 * 输出：[false,true,false,false,true,true]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/arithmetic-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1630 {
    public static void main(String[] args) {
        //  int[] nums = {4, 6, 5, 9, 3, 7}, l = {0, 0, 2}, r = {2, 3, 5};
        int[] nums = {-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10}, l = {0, 1, 6, 4, 8, 7}, r = {4, 4, 9, 7, 9, 10};
        List<Boolean> list = checkArithmeticSubarrays(nums, l, r);
        System.out.println(list);
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new LinkedList<>();
        List<Integer> list1 = new LinkedList<>();
        for (int i = 0; i < l.length; i++) {
            list1.clear();
            for (int j = l[i]; j <= r[i]; j++) {
                list1.add(nums[j]);
            }
            list1.sort((o1, o2) -> o1.compareTo(o2));
            boolean flag = true;
            Integer c = null;
            Integer cur = null;
            for (int j = 0; j < list1.size(); j++) {
                Integer integer = list1.get(j);
                if (j == 0) {
                    cur = integer;
                } else {
                    if (c == null) {
                        c = integer - cur;
                    } else {
                        if (c != (integer - cur)) {
                            flag = false;
                            break;
                        }
                    }
                    cur = integer;
                }
            }
            list.add(flag);
        }
        return list;
    }
}
