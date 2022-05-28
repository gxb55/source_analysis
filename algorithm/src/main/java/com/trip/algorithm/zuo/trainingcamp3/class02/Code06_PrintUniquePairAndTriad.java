package com.trip.algorithm.zuo.trainingcamp3.class02;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个有序数组arr，给定一个正数aim
 * <p>
 * 1）返回累加和为aim的，所有不同二元组
 * <p>
 * 2）返回累加和为aim的，所有不同三元组
 * <p>
 * 注意要去重
 */
public class Code06_PrintUniquePairAndTriad {
    public static void main(String[] args) {
        int sum = 10;
        int[] arr = {-8, -4, -3, 0, 1, 1, 2, 3, 4, 5, 8, 9};
        /*List<List<Integer>> twoNum = getTwoNum(arr, sum);
        twoNum.stream().forEach(x -> {
            System.out.println(x);
        });*/
        List<List<Integer>> thereNum = getThereNum(arr, sum);
        thereNum.stream().forEach(x -> {
            System.out.println(x);
        });
    }

    public static List<List<Integer>> getThereNum(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int l = 0;
        int n = arr.length;
        int r = n - 1;
        for (int i = 0; i < n; i++) {
            // 算过一遍就不用再算一次了
            if (i - 1 > -1 && arr[i] != arr[i - 1]) {
                List<List<Integer>> cur = getResult(i + 1, n - 1, k - arr[i], arr[i], arr);
                if (cur != null && cur.size() > 0) {
                    result.addAll(cur);
                }
            }
        }
        return result;
    }

    /**
     * @param l   左边下标
     * @param r   右边下标
     * @param k   目标值
     * @param cur 前一个值
     * @param arr 数组
     * @return
     */
    private static List<List<Integer>> getResult(int l, int r, int k, int cur, int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        while (l < r) {
            if (arr[l] + arr[r] > k) {
                r--;
            } else if (arr[l] + arr[r] < k) {
                l++;
            } else {
                if (l - 1 >= 0 && arr[l] != arr[l - 1]) {
                    result.add(List.of(cur, arr[l], arr[r]));
                }
                l++;
            }
        }
        return result;
    }

    public static List<List<Integer>> getTwoNum(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int lVal = arr[l];
            int rVal = arr[r];
            if (lVal + rVal > k) {
                r--;
            } else if (lVal + rVal < k) {
                l++;
            } else {
                if (l - 1 >= 0 && arr[l] != arr[l - 1]) {
                    result.add(List.of(arr[l], arr[r]));
                }
                l++;
            }
        }
        return result;
    }
}
