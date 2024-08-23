package com.trip.algorithm.leet.l24.l100;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2024/8/20 14:45
 */
public class QuickSortV1 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,3,3,3,5,5,6,7};
        System.out.println(Arrays.toString(arr));
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {7, 6, 5, 4, 3, 2, 1};
        quicksort(arr1, 0, arr1.length - 1);
        for (int num : arr1) {
            System.out.print(num + " ");
        }
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int point = arr[left];
        // 降序
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && arr[r] <= point) {
                r--;
            }
            while (l < r && arr[l] >= point) {
                l++;
            }

            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        int i = arr[left];
        arr[left] = arr[l];
        arr[l] = i;
        sort(arr, left, l - 1);
        sort(arr, l + 1, right);
    }




        public static void quicksort(int[] arr, int low, int high) {
            if (low < high) {
                int splitPoint = partition(arr, low, high);
                quicksort(arr, low, splitPoint - 1);
                quicksort(arr, splitPoint + 1, high);
            }
        }

        public static int partition(int[] arr, int low, int high) {
            int pivot = arr[low];  // 选择第一个元素作为基准
            int left = low + 1;
            int right = high;

            while (true) {
                while (right >= left && arr[right] >= pivot) {
                    right--;
                }
                while (left <= right && arr[left] <= pivot) {
                    left++;
                }


                if (left > right) {
                    break;
                } else {
                    // 交换 arr[left] 和 arr[right]
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
            }

            // 交换 arr[low] 和 arr[right]，使基准元素到正确的位置
            int temp = arr[low];
            arr[low] = arr[right];
            arr[right] = temp;

            return right;
        }
    }

