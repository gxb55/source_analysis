package com.trip.algorithm.leet.l24.l05;

import java.util.*;
import java.util.stream.Collectors;

public class Solution826 {
    public static void main(String[] args) {
        // int[] difficulty = {2, 4, 6, 8, 10}, profit = {10, 20, 30, 40, 50}, worker = {4, 5, 6, 7};
        int[] difficulty = {85, 25}, profit = {24, 12}, worker = {40, 25, 25};
       // int[] difficulty = {13, 37, 58}, profit = {4, 90, 96}, worker = {34, 73, 45};

        int i = maxProfitAssignment1(difficulty, profit, worker);
        System.out.println(i);
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            list.add(new int[]{difficulty[i], profit[i]});
        }
        // 按照钱排序
        list.sort((x, y) -> y[1] - x[1]);
        // difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益
        for (int i = 0; i < difficulty.length; i++) {
            int di = difficulty[i];
            map.put(di, 0);
            Optional<int[]> first = list.stream().filter(x -> di >= x[0]).findFirst();
            if (first.isPresent()) {
                map.put(di, first.get()[1]);
            }
        }
        List<Integer> list1 = map.keySet().stream().sorted().sorted((x, y) -> x - y).collect(Collectors.toList());
        int count = 0;
        for (int i = 0; i < worker.length; i++) {
            int val = worker[i];
            int res = -1;
            int left = 0;
            int right = list1.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (list1.get(mid) <= val) {
                    res = Math.max(res, mid);
                }
                if (list1.get(mid) >= val) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            Integer orDefault = 0;
            if (res == -1) {
                System.out.println(val + ":" + -1);
            } else {
                Integer hard = list1.get(res);
                System.out.println(val + ":" + hard);
                orDefault = map.get(hard);
            }
            count = count + orDefault;
        }

        return count;
    }

    public static int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            list.add(new int[]{difficulty[i], profit[i]});
        }

        list.sort((x, y) -> x[0] - y[0]);
        int count = 0;
        int t=0;
        int n=difficulty.length;
        Arrays.sort(worker);
        int v=0;
        // difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益
        for (int i = 0; i < worker.length; i++) {
            int di = worker[i];
            while (t<n&&di>=list.get(t)[0]){
                v=Math.max(v,list.get(t)[1]);
                t++;
            }
            count+=v;
        }
        return count;
    }
}
