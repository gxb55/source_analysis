package com.trip.algorithm.zuo.trainingcamp3.class01;

/**
 * 给定一个有序数组arr，从左到右依次表示X轴上从左往右点的位置
 * 给定一个正整数K，返回如果有一根长度为K的绳子，最多能盖住几个点
 * 绳子的边缘点碰到X轴上的点，也算盖住
 */
public class Code01_CordCoverMaxPoint {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7, 12, 23, 34};
        int l = 5;
        int i = maxPoint1(arr, l);
        System.out.println(i);
        int j = maxPoint2(arr, l);
        System.out.println(j);
        int k = maxPoint3(arr, l);
        int t = test(arr, l);
        System.out.println(k);
        System.out.println(t);
    }

    /**
     * 双层循环每次枚举绳子的开头位置
     *
     * @param arr
     * @param l
     * @return
     */
    public static int maxPoint1(int[] arr, int l) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] - arr[i] <= l) {
                    max = Math.max(j - i + 1, max);
                } else {
                    break;
                }
            }
        }
        return max;
    }

    /**
     * 滑动窗口方法
     *
     * @param arr
     * @param l
     * @return
     */
    public static int maxPoint3(int[] arr, int l) {
        int left = 0;
        int right = 0;
        int max = 0;
        int n = arr.length;
        while (left < n) {
            while (right < n && arr[right] - arr[left] <= l) {
                right++;
            }
            max = Math.max(right - left, max);
            left++;
        }
        return max;
    }

    // for test
    public static int test(int[] arr, int L) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int pre = i - 1;
            while (pre >= 0 && arr[i] - arr[pre] <= L) {
                pre--;
            }
            max = Math.max(max, i - pre);
        }
        return max;
    }

    /**
     * 二分法求
     *
     * @param arr
     * @param l
     * @return
     */
    public static int maxPoint2(int[] arr, int l) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int index = nearestIndex(arr, i, arr[i] - l);
            max = Math.max(max, (i - index + 1));
        }
        return max;
    }

    private static int nearestIndex(int[] arr, int i, int value) {
        int left = 0;
        int right = i;
        int index = -1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= value) {
                index = mid;
                right = mid - 1;
            } else {
                left = left + 1;
            }
        }
        return index;
    }
}
