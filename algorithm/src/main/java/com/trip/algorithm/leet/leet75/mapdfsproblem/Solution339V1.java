package com.trip.algorithm.leet.leet75.mapdfsproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/8/16 14:08
 */
public class Solution339V1 {
    public static void main(String[] args) {
        Solution339V1 solution399 = new Solution339V1();
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double[] doubles = solution399.calcEquation(getRes(equations), values, getRes(queries));
        System.out.println(Arrays.toString(doubles));
    }

    private static List<List<String>> getRes(String[][] queries) {
        List<List<String>> list = new ArrayList<>();
        for (String[] arr : queries) {
            list.add(Arrays.stream(arr).collect(Collectors.toList()));
        }
        return list;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        int equationsSize = equations.size();

        UnionFind339 unionFind = new UnionFind339(2 * equationsSize);
        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }
}

class UnionFind339 {

    public Integer[] parent;
    public double[] weight;

    public UnionFind339(int x) {
        this.parent = new Integer[x];
        this.weight = new double[x];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            weight[i] = 1.0;
        }
    }

    /**
     * x/y=val
     * 就说明有一条 x->y的边，权重是val
     * x->y->z
     * 权重分别是 x1 x2 则x->z 就是x1*x2
     */
    public void union(int x, int y, double value) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }

        parent[rootX] = rootY;
        // 关系式的推导请见「参考代码」下方的示意图
        weight[rootX] = weight[y] * value / weight[x];
    }

    public int find(int x) {
        if (parent[x] != x) {
            Integer origin = parent[x];
            int i = find(parent[x]);
            parent[x] = i;
            weight[x] = weight[x] * weight[origin];
        }
        return parent[x];
    }

    public double isConnected(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return weight[x] / weight[y];
        } else {
            return -1.0d;
        }
    }

}

