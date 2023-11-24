package com.trip.algorithm.leet.some.leet2311;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/11/21 19:11
 */
public class Solution2216 {
    public static void main(String[] args) {
        Solution2216 solution2216 =new Solution2216();
       // int[] arr={1,1,2,3,5};
        int[] arr={1,1,2,2,3,3};
        int i = solution2216.minDeletion(arr);
        System.out.println(i);
    }
    public int minDeletion(int[] nums) {
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int count=0;
        int index=0;
        while (true){
            int t=-1;
            for (int i = index; i < collect.size(); i++) {
                if(i%2==0&&i+1<collect.size()){
                    if(collect.get(i).equals(collect.get(i + 1))){
                     t=i+1;
                     index=i;
                     break;
                    }
                }
            }
            if(t==-1){
                break;
            }else{
                collect.remove(t);
                count++;
            }
        }
        if(collect.size()%2!=0){
            count++;
        }
        return count;
    }
}
