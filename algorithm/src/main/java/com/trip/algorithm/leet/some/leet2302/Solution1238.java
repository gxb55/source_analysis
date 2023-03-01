package com.trip.algorithm.leet.some.leet2302;

import com.trip.algorithm.leet.some.codeThink.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/2/23 19:40
 * n = 2, start = 3
 * 输出：[3,2,0,1]
 * 解释：这个排列的二进制表示是 (11,10,00,01)
 *      所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
 * 示例 2：
 *
 * 输出：n = 3, start = 2
 * 输出：[2,6,7,5,4,0,1,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/circular-permutation-in-binary-representation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1238 {
    public static void main(String[] args) {
        Solution1238.circularPermutation1(3);
        //int n = 2, start = 3;
        int n = 3, start = 2;
        List<Integer> list = Solution1238.circularPermutation(n, start);
        System.out.println(list);
    }
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i);
        }
        return ret;
    }



    public static List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int t = 1 << i;
            for (int j = list.size() - 1; j >= 0; j--) {
                Integer integer = list.get(j);
                list.add(integer|t);
            }
        }
        int index=0;
        for (int i = 0; i < list.size(); i++) {
            if(start==list.get(i)){
                index=i;
                break;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = index; i <list.size() ; i++) {
            res.add(list.get(i));
        }
        for (int i = 0; i < index; i++) {
            res.add(list.get(i));
        }
        return res;
    }

    public static List<Integer> circularPermutation1(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int t = 1 << i;
            for (int j = list.size() - 1; j >= 0; j--) {
                Integer integer = list.get(j);
                list.add(integer|t);
            }
        }
        list.forEach(x-> System.out.println(Integer.toBinaryString(x)));
        return null;
    }
}
