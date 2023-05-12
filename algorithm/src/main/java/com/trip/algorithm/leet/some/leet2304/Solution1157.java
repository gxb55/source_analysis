package com.trip.algorithm.leet.some.leet2304;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年04月16日 08:27:00
 * ["MajorityChecker", "query", "query", "query"]
 * [[[1, 1, 2, 2, 1, 1]], [0, 5, 4], [0, 3, 3], [2, 3, 2]]
 * 输出：
 * [null, 1, -1, 2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/online-majority-element-in-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1157 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 1, 1};
        MajorityChecker majorityChecker = new MajorityChecker(arr);
        int query = majorityChecker.query(0, 5, 4);
        System.out.println(query);
        System.out.println(majorityChecker.query(0, 3, 3));
        System.out.println(majorityChecker.query(2, 3, 2));

    }
}

class MajorityChecker {

    int[] arr;

    public MajorityChecker(int[] arr) {
        this.arr = arr;
    }

    public int query(int left, int right, int threshold) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = left; i <= right; i++) {
            int i1 = arr[i];
            map1.put(i1, map1.getOrDefault(i1, 0) + 1);
            if (map1.get(i1) >= threshold) {
                return i1;
            }
        }
        return -1;
    }
}