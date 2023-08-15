package com.trip.algorithm.leet.leet75.mapdfsproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/8/15 19:00
 */
public class Solution399 {
    public static void main(String[] args) {
        Solution399 solution399 = new Solution399();
        /*String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};*/


      /*  String[][] equations = {{"a", "b"}, {"b", "c"}, {"bc", "cd"}};
        double[] values = {1.5, 2.5, 5.0};
        String[][] queries = {{"a", "c"}, {"c", "b"}, {"bc", "cd"}, {"cd", "bc"}};*/


        String[][] equations = {{"x1", "x2"}, {"x2", "x3"}, {"x3", "x4"}, {"x4", "x5"}};
        double[] values = {3.0, 4.0, 5.0, 6.0};
        String[][] queries = {{"x1", "x5"}, {"x5", "x2"}, {"x2", "x4"}, {"x2", "x2"}, {"x2", "x9"}, {"x9", "x9"}};

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
        Map<String, List<Node399>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            String x = list.get(0);
            String y = list.get(1);
            List<Node399> orDefault = map.getOrDefault(x, new ArrayList<>());
            orDefault.add(new Node399(x, y, 1.0, values[i]));
            map.put(x, orDefault);

            List<Node399> list1 = map.getOrDefault(y, new ArrayList<>());
            list1.add(new Node399(y, x, values[i], 1.0));
            map.put(y, list1);
        }
        Set<String> set = new HashSet<>();
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            List<String> list1 = queries.get(i);
            String x = list1.get(0);
            String y = list1.get(1);
            if (x.equals(y) && map.containsKey(x)) {
                list.add(1.0);
            } else if (map.containsKey(x) && map.containsKey(y)) {
                set.clear();
                double process = process(map, x, y, set);
                if(process!=0){
                    list.add(process);
                }else{
                    list.add(-1.0);
                }
            } else {
                list.add(-1.0);
            }
        }

        double[] res = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private double process(Map<String, List<Node399>> map, String x, String y, Set<String> set) {
        List<Node399> node399s = map.get(x);
        if (node399s == null || set.contains(x)) {
            return 0;
        }
        Node399 node = node399s.stream().filter(z -> z.y.equals(y)).findFirst().orElse(null);
        if (node != null) {
            return node.yVal / node.xVal;
        }
        set.add(x);
        double res = -1.0;
        boolean flag = true;
        for (int i = 0; i < node399s.size(); i++) {
            Node399 node399 = node399s.get(i);
            double v = process(map, node399.y, y, set) * (node399.yVal / node399.xVal);
            if (v != 0) {
                res = v;
                flag = false;
                break;
            }
        }
        set.remove(x);
        double v = flag ? 0 : res;
        return v;
    }
}

class Node399 {
    public String x;
    public String y;
    public Double xVal;
    public Double yVal;

    /**
     * x*xVal =y*yVal
     * x=y*yVal/xVal
     * y=x*xVal/yVal;
     * <p>
     * x/y=yVal/xVal;
     */
    public Node399(String x, String y, Double xVal, Double yVal) {
        this.x = x;
        this.y = y;
        this.xVal = xVal;
        this.yVal = yVal;
    }

    @Override
    public String toString() {
        return "Node399{" +
                "x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", xVal=" + xVal +
                ", yVal=" + yVal +
                '}';
    }
}
