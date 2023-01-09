package com.trip.algorithm.leet.some.leet11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/11/21 10:05
 * 有 A 和 B 两种类型 的汤。一开始每种类型的汤有 n 毫升。有四种分配操作：
 * <p>
 * 提供 100ml 的 汤A 和 0ml 的 汤B 。
 * 提供 75ml 的 汤A 和 25ml 的 汤B 。
 * 提供 50ml 的 汤A 和 50ml 的 汤B 。
 * 提供 25ml 的 汤A 和 75ml 的 汤B 。
 * 当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为 0.25 的操作中进行分配选择。如果汤的剩余量不足以完成某次操作，我们将尽可能分配。当两种类型的汤都分配完时，停止操作。
 * <p>
 * 注意 不存在先分配 100 ml 汤B 的操作。
 * <p>
 * 需要返回的值： 汤A 先分配完的概率 +  汤A和汤B 同时分配完的概率 / 2。返回值在正确答案 10-5 的范围内将被认为是正确的。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 50
 * 输出: 0.62500
 * 解释:如果我们选择前两个操作，A 首先将变为空。
 * 对于第三个操作，A 和 B 会同时变为空。
 * 对于第四个操作，B 首先将变为空。
 * 所以 A 变为空的总概率加上 A 和 B 同时变为空的概率的一半是 0.25 *(1 + 1 + 0.5 + 0)= 0.625。
 * 示例 2:
 * <p>
 * 输入: n = 100
 * 输出: 0.71875
 *  
 * <p>
 * 提示:
 * <p>
 * 0 <= n <= 109​​​​​​​
 * 通过次数8,859提交次数16,396
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/soup-servings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution808 {
    public static void main(String[] args) {
        Solution808 solution808 = new Solution808();
        // int n = 50;
        //  int n = 100;
        int n = 850;
        double v = solution808.soupServings1(n);
        System.out.println(v);
        System.out.println("======");
        System.out.println(solution808.soupServings(n));
    }


    public double soupServings(int n) {
        process(n, n, 1);
        double v = aVal + bVal / 2;
        return v;
    }

    double aVal = 0;
    double bVal = 0;
    /**
     * * 提供 100ml 的 汤A 和 0ml 的 汤B 。
     * * 提供 75ml 的 汤A 和 25ml 的 汤B 。
     * * 提供 50ml 的 汤A 和 50ml 的 汤B 。
     * * 提供 25ml 的 汤A 和 75ml 的 汤B 。
     */
    Map<String, double[]> map = new HashMap<>();

    private void process(int a, int b, double i1) {
        String s = a + "_" + b;
        if (map.containsKey(s)) {
            double[] doubles = map.get(s);
            aVal = aVal + doubles[0];
            bVal = bVal + doubles[1];
            return;
        }
        if (a > 0 && b <= 0) {
            return;
        }
        if (a <= 0 && b > 0) {
            aVal = aVal + i1;
            map.put(s, new double[]{aVal, bVal});
            return;
        }
        if (a <= 0 && b <= 0) {
            bVal = bVal + i1;
            map.put(s, new double[]{aVal, bVal});
            return;
        }
        if (a > 0) {
            process(a - 100, b, i1 * 0.25);
        }
        if (a > 0 && b > 0) {
            process(a - 75, b - 25, i1 * 0.25);
            process(a - 50, b - 50, i1 * 0.25);
            process(a - 25, b - 75, i1 * 0.25);
        }

    }

    private double[][] f = new double[200][200];

    public double soupServings1(int n) {
        return n > 4800 ? 1 : dfs((n + 24) / 25, (n + 24) / 25);
    }

    private double dfs(int i, int j) {
        if (i <= 0 && j <= 0) {
            return 0.5;
        }
        if (i <= 0) {
            return 1.0;
        }
        if (j <= 0) {
            return 0;
        }
        if (f[i][j] > 0) {
            return f[i][j];
        }
        double ans = 0.25 * (dfs(i - 4, j) + dfs(i - 3, j - 1) + dfs(i - 2, j - 2) + dfs(i - 1, j - 3));
        f[i][j] = ans;
        return ans;
    }


}
