package com.trip.algorithm.zuo.trainingcamp3.class02;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 长度为N的数组arr，一定可以组成N^2个数值对。
 * 例如arr = [3,1,2]，
 * 数值对有(3,3) (3,1) (3,2) (1,3) (1,1) (1,2) (2,3) (2,1) (2,2)，
 * 也就是任意两个数都有数值对，而且自己和自己也算数值对。
 * 数值对怎么排序？规定，第一维数据从小到大，第一维数据一样的，第二维数组也从小到大。所以上面的数值对排序的结果为：
 * (1,1)(1,2)(1,3)(2,1)(2,2)(2,3)(3,1)(3,2)(3,3)
 * <p>
 * 给定一个数组arr，和整数k，返回第k小的数值对。
 */
public class Code07_KthMinPair {
    public static void main(String[] args) {
       /* int[] arr = {3, 1, 1, 2};
        int[] ints1 = kthMinPair1(arr, 5);
        System.out.println();
        int[] ints = kthMinPair2(arr, 7);
        System.out.println(Arrays.toString(ints));
        System.out.println();*/
        /*int[] kArr = {3, 1, 1, 2};
        QuickSort(kArr, 0, kArr.length - 1);
        System.out.println(Arrays.toString(kArr));
        int kMin = getKMin(kArr, 4);
        System.out.println(kMin);*/



        int[] arr = {3, 1, 1, 2};
        int[] ints1 = kthMinPair1(arr, 7);
        System.out.println(Arrays.toString(ints1));
        System.out.println();
        int[] ints = kthMinPair2(arr, 7);
        System.out.println(Arrays.toString(ints));
        System.out.println();
        int[] ints3 = kthMinPair3(arr, 7);
        System.out.println(Arrays.toString(ints3));
    }

    public static class Pair {
        public int x;
        public int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static class PairComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair arg0, Pair arg1) {
            return arg0.x != arg1.x ? arg0.x - arg1.x : arg0.y - arg1.y;
        }

    }

    // O(N^2 * log (N^2))的复杂度，你肯定过不了
    // 返回的int[]  长度是2，{3,1}  int[2] = [3,1]
    public static int[] kthMinPair1(int[] arr, int k) {
        int N = arr.length;
        if (k > N * N) {
            return null;
        }
        Pair[] pairs = new Pair[N * N];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pairs[index++] = new Pair(arr[i], arr[j]);
            }
        }
        Arrays.sort(pairs, new PairComparator());
        System.out.println(Arrays.toString(pairs));
        return new int[]{pairs[k - 1].x, pairs[k - 1].y};
    }

    /**
     * 1.排序
     * 2.找到以哪个数字开头 k / n -1
     * 3.找到第二个数字
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] kthMinPair2(int[] arr, int k) {
        if (arr == null || arr.length * arr.length < k) {
            return null;
        }
        int[] result = new int[2];
        Arrays.sort(arr);
        int n = arr.length;
        int first = (k - 1) / n;
        int firstVal = arr[first];
        int less = 0, equals = 0;
        for (int x : arr) {
            if (x < firstVal) {
                less++;
            } else if (firstVal == x) {
                equals++;
            } else {
                break;
            }
        }
        int seconds = (k - 1 - less * n) / equals;
        result[0] = firstVal;
        result[1] = arr[seconds];
        return result;
    }

    /**
     * 利用快排 从数组中找到第k大的数字
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] kthMinPair3(int[] arr, int k) {
        if (arr == null || k > arr.length * arr.length) {
            return null;
        }
        int n = arr.length;
        int first = (k-1)/n;
        int kMin = getKMin(arr, first);
        int less=0;
        int equals=0;
        for (int i = 0; i < n; i++) {
            if(arr[i]<kMin){
                less++;
            }else if(arr[i]==kMin){
                equals++;
            }
        }
        int e = equals > 0 ? equals : 1;
        int i = (k - (less * n) - 1) / e;
        int kMin1 = getKMin(arr, i);
        return new int[]{kMin,kMin1};
    }

    public static int quickSort(int arr[], int low, int high, int k) {
        int val = arr[low];
        int left = low;
        int right = high;
        while (left < right) {
            while (right > left && arr[right] >= val) {
                right--;
            }
            while (right > left && arr[left] <= val) {
                left++;
            }
            if (right > left) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[low] = arr[left];
        arr[left] = val;

        if (left == k - 1) {
            return arr[left];
        } else if (k > left) {
            return quickSort(arr, left + 1, high, k);
        } else {
            return quickSort(arr, low, left - 1, k);
        }
    }

    public static int getKMin(int arr[], int k) {
        if (arr == null || arr.length < k) {
            return Integer.MIN_VALUE;
        }
        return quickSort(arr, 0, arr.length - 1, k);
    }

    private static void QuickSort(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if (left >= right) {
            return;
        }
        //设置最左边的元素为基准值
        int key = num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i = left;
        int j = right;
        while (i < j) {
            //j向左移，直到遇到比key小的值
            while (num[j] >= key && i < j) {
                j--;
            }
            //i向右移，直到遇到比key大的值
            while (num[i] <= key && i < j) {
                i++;
            }
            //i和j指向的元素交换
            if (i < j) {
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
        num[left] = num[i];
        num[i] = key;
        QuickSort(num, left, i - 1);
        QuickSort(num, i + 1, right);
    }

}
