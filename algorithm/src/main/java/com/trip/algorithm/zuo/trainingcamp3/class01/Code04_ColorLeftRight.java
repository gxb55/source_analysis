package com.trip.algorithm.zuo.trainingcamp3.class01;

/**
 * 有一些排成一行的正方形。每个正方形已经被染成红色或者绿色。
 * 现在可以选择任意一个正方形然后用这两种颜色的任意一种进行染色,这个正方形的颜色将 会被覆盖。目标是在完成染色之后,每个红色R都比每个绿色G距离最左侧近。 返回最少需要涂染几个正方形。
 * 如样例所示: s = RGRGR 我们涂染之后变成RRRGG满足要求了,涂染的个数为2,没有比这个更好的涂染方案。
 */
public class Code04_ColorLeftRight {
    public static void main(String[] args) {
        String str= "GRRRRRG";
        System.out.println(minPaint(str));
        System.out.println(minPaint1(str));
    }

    // RGRGR -> RRRGG

    /**
     * RGRGR
     * 左边全是R 右边全是G；
     * 从左到右找G
     * 从右到左找R
     * 1.求分割线，分割线左边全是R，右边全是G
     * 2.两个数组分别对应某个index位置符合要求时候要涂的数量
     *
     * @param s
     * @return
     */
    public static int minPaint(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int left[] = new int[n];
        int right[] = new int[n];
        for (int i = 0; i < n; i++) {
            int last = i > 0 ? left[i - 1] : 0;
            left[i] = last + (chars[i] == 'G' ? 1 : 0);
        }

        right[n - 1] = chars[n - 1] == 'R' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (chars[i] == 'R' ? 1 : 0);
        }
        int min = n;
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, left[i] + right[i + 1]);
        }
        min = Math.min(min, left[n - 1]);
        min = Math.min(min, right[0]);
        return min;
    }

    /**
     * 左边全是R 右边全是G；
     *
     * @param s
     * @return
     */
    public static int minPaint1(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;

        int right[] = new int[n];
        right[n - 1] = chars[n - 1] == 'R' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (chars[i] == 'R' ? 1 : 0);
        }
        int left = 0;
        int ans = n;
        for (int i = 0; i < n - 1; i++) {
            left = left + (chars[i] == 'G' ? 1 : 0);
            ans = Math.min(left + right[i + 1], ans);
        }
        ans = Math.min(left + (chars[n - 1] == 'G' ? 1 : 0), ans);
        return ans;
    }
}
