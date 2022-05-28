package com.trip.algorithm.zuo.trainingcamp3.class02;

import java.util.Arrays;

/**
 * 给定一个数组arr，已知其中所有的值都是非负的，将这个数组看作一个容器， 请返回容器能装多少水
 * 比如，arr = {3，1，2，5，2，4}，根据值画出的直方图就是容器形状，该容 器可以装下5格水
 * 再比如，arr = {4，5，1，3，2}，该容器可以装下2格水
 */
public class Code04_TrappingRainWater {
    // for test
    public static int[] generateRandomArray(int len, int value) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * value) + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
       /* int[] arr = {142, 155, 8, 192, 83, 179, 57, 20, 151, 78, 20, 180, 20, 182, 35, 139, 9, 2, 197, 62};
        Arrays.stream(arr).forEach(x -> System.out.println(x));
        System.out.println("test begin");
        int ans1 = water1(arr);
        int ans4 = water4(arr);
        int ans3 = water3(arr);
        System.out.println(ans1);
        System.out.println(ans4);
        System.out.println(ans3);*/

       int len = 100;
        int value = 200;
        int testTimes = 100000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(len, value);
            int ans1 = water1(arr);
            int ans4 = water4(arr);
            if (ans1 != ans4 ) {
                System.out.println(Arrays.toString(arr));
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("test finish");
    }

    public static int water1(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int n = arr.length;
        // 从左到右依次递增的数组，即某个数左边的最大值是多少
        int[] leftMax = new int[n];
        // 从右到左依次递增的数组，即某个数右边的最大值是多少
        int[] rightMax = new int[n];
        int left = arr[0];
        int right = arr[n - 1];
        for (int i = 0; i < n; i++) {
            if (arr[i] > left) {
                leftMax[i] = arr[i];
                left = arr[i];
            } else {
                leftMax[i] = left;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > right) {
                rightMax[i] = arr[i];
                right = arr[i];
            } else {
                rightMax[i] = right;
            }
        }
        // 一个数，左边和右边的最大求小的哪个，跟当前数比较，大于当前数则认为是有水
        int water = 0;
        for (int i = 1; i < n - 1; i++) {
            int leftMaxValue = leftMax[i - 1];
            int rightMaxValue = rightMax[i + 1];
            int max = Math.min(leftMaxValue, rightMaxValue);
            int val = max - arr[i];
            water = water + ((val > 0) ? val : 0);
        }
        return water;
    }

    /**
     * 1.左右分别从头开始找
     * 2.找到小的哪个作为开始的点向对应的方向移动
     *
     * @param arr 数组
     * @return
     */
    public static int water4(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int n = arr.length;

        int leftMax = arr[0];
        int rightMax = arr[n - 1];

        int l = 1;
        int r = n - 2;
        int water = 0;
        while (l <= r) {
            if (leftMax < rightMax) {
                water = water + Math.max(0, leftMax - arr[l]);
                leftMax = Math.max(leftMax, arr[l]);
                l++;
            } else {
                water = water + Math.max(0, rightMax - arr[r]);
                rightMax = Math.max(rightMax, arr[r]);
                r--;
            }
        }
        return water;
    }

    /**
     * 老师的
     *
     * @param arr
     * @return
     */
    public static int water3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int N = arr.length;
        int[] rightMaxs = new int[N];
        rightMaxs[N - 1] = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            rightMaxs[i] = Math.max(rightMaxs[i + 1], arr[i]);
        }
        int water = 0;
        int leftMax = arr[0];
        for (int i = 1; i < N - 1; i++) {
            water += Math.max(Math.min(leftMax, rightMaxs[i + 1]) - arr[i], 0);
            leftMax = Math.max(leftMax, arr[i]);
        }
        return water;
    }
}
