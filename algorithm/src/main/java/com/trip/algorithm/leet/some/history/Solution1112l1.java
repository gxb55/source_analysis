package com.trip.algorithm.leet.some.history;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo 郭晓兵
 * @date 2020-11-12 19:20
 */
public class Solution1112l1 {
    public static void main(String[] args) {
        Solution1112l1 solution = new Solution1112l1();
        int[] a={4,2,5,7};
        int[] ints = solution.sortArrayByParityII(a);
        System.out.println(JSON.toJSONString(ints));
    }
    /**
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     *
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     *
     * 你可以返回任何满足上述条件的数组作为答案。
     *
     *  
     *
     * 示例：
     *
     * 输入：[4,2,5,7]
     * 输出：[4,5,2,7]
     * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     *  
     *
     * 提示：
     *
     * 2 <= A.length <= 20000
     * A.length % 2 == 0
     * 0 <= A[i] <= 1000
     *
     */
    public int[] sortArrayByParityII(int[] A) {
        //偶数
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                list1.add(A[i]);
            }else{
                list2.add(A[i]);
            }
        }
        int[] arr = new int[A.length];
        for (int i = 0; i <arr.length; i++) {
            if(i%2==0){
                arr[i]=list1.remove(0);
            }else{
                arr[i]=list2.remove(0);
            }
        }
        return arr;
    }
}
