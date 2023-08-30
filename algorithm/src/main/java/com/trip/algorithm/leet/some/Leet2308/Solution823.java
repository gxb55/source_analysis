package com.trip.algorithm.leet.some.Leet2308;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/8/29 11:22
 * 满足条件的二叉树一共有多少个？答案可能很大，返回 对 109 + 7 取余 的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: arr = [2, 4]
 * 输出: 3
 * 解释: 可以得到这些二叉树: [2], [4], [4, 2, 2]
 * 示例 2:
 * <p>
 * 输入: arr = [2, 4, 5, 10]
 * 输出: 7
 * 解释: 可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 */
public class Solution823 {
    public static void main(String[] args) {
        Solution823 solution823 = new Solution823();
         int[] arr = {2, 4,16};
        // int[] arr = {2, 4, 5, 10};
     //   int[] arr = {45, 42, 2, 18, 23, 1170, 12, 41, 40, 9, 47, 24, 33, 28, 10, 32, 29, 17, 46, 11, 759, 37, 6, 26, 21, 49, 31, 14, 19, 8, 13, 7, 27, 22, 3, 36, 34, 38, 39, 30, 43, 15, 4, 16, 35, 25, 20, 44, 5, 48};
        //  int[] arr = {18,3,6,2};
        int i = solution823.numFactoredBinaryTrees(arr);
        System.out.println(i);
        System.out.println(solution823.numFactoredBinaryTrees1(arr));
    }

    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 100000007;
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(x -> map.put(x, 1));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                Integer xVal = map.get(arr[i]);
                Integer yVal = map.get(arr[j]);
                int x = arr[i];
                int y = arr[j];
                Integer integer = map.get(x * y);
                if (integer!=null) {
                    int v = xVal * yVal;
                    if (i != j) {
                        v=v*2;
                    }
                    v = v % mod;
                    v = (v+integer) % mod;
                    map.put(x*y,v);
                }
            }
        }
        int count=0;
        for (int x:map.values()){
            count+=x;
            count=count%mod;
        }
        return count;
    }

    public int numFactoredBinaryTrees1(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        int n = arr.length, mod = (int) (1e9 + 7);
        long ans = 0L;
        for (int i = 0; i < n; i++) {
            map.put(arr[i], 1);
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                    long res = (1L * map.get(arr[j]) * map.get(arr[i] / arr[j])) % mod;
                    res = (res + map.get(arr[i])) % mod;
                    map.put(arr[i], (int) res);
                }
            }
            ans += map.get(arr[i]);
            ans %= mod;
        }
        return (int) ans;
    }
}
