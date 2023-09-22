package com.trip.algorithm.leet.leet75.backtrackproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/9/8 16:20
 */
public class Solution216 {
    public static void main(String[] args) {
        Solution216 solution216 =new Solution216();
       // int k = 3, n = 7;
        int k = 3, n = 9;
        List<List<Integer>> list = solution216.combinationSum3(k,n);
       /* for (List<Integer> integers:list){
            System.out.println(integers);
        }*/
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k >= n) {
            return res;
        }
        boolean[] vis = new boolean[10];
        Arrays.fill(vis,false);
        process(k, n, new LinkedList<Integer>(), 0, vis,1);
        System.out.println(res);
        List<List<Integer>> collect = res.stream().peek(x->x.sort((o1, o2) -> o1.compareTo(o2))).distinct().collect(Collectors.toList());
        return collect;
    }
    List<List<Integer>> res = new ArrayList<>();
    private void process(int k, int n, LinkedList<Integer> integers, int sum, boolean[] vis,int index) {
        if (sum > n) {
            return;
        }
        if (k == 0) {
            if (n == sum) {
                res.add(new ArrayList<>(integers));
            }
            return;
        }
        for (int i = index; i <= 9; i++) {
            if(vis[i]){
                continue;
            }
            integers.addLast(i);
            vis[i]=true;
            process(k-1,n,integers,sum+i,vis,i+1);
            vis[i]=false;
            integers.pollLast();
        }
    }


}
