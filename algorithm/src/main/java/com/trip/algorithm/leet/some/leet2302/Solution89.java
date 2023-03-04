package com.trip.algorithm.leet.some.leet2302;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年02月23日 07:50:00
 * 110
 * 1100
 */
public class Solution89 {
    public static void main(String[] args) {
        System.out.println(1<<3);
       /* List<Integer> list = grayCode(5);
        System.out.println(list);*/
    }

    public List<Integer> grayCode1(int n) {
        List<Integer> result = new ArrayList<>();
        // 先将0加入
        result.add(0);
        if (n == 0) {
            return result;
        }
        // 由于最高位前默认为 0 所以只需将当前result 按照倒叙输出并在每一个二进制前面加first即可
        int first = 1;
        for (int i = 0; i < n; i++) {
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(first + result.get(j));
            }
            // 左移一位
            first = first << 1;
        }
        return result;
    }


    public static List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                ret.add(ret.get(j) | (1 << (i - 1)));
            }
        }
        return ret;

    }
}
