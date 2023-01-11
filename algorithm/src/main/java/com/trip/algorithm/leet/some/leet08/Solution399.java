package com.trip.algorithm.leet.some.leet08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/8/11  13:59
 * @description 399. 除法求值
 */
public class Solution399 {
    public static void main(String[] args) {
        Solution399 solution399 = new Solution399();
        String[][] a = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double[] doubles = solution399.calcEquation(toList(a), values, toList(queries));

        System.out.println(Arrays.toString(doubles));
    }

    private static List<List<String>> toList(String[][] a) {
        List<List<String>> list = new ArrayList<>();
        for (String[] strings : a) {
            List<String> collect = Arrays.stream(strings).collect(Collectors.toList());
            list.add(collect);
        }
        return list;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        double[] result = new double[queries.size()];
        int size = equations.size();

        for (int i = 0; i < size; i++) {
            List<String> list = equations.get(i);
            double value = values[i];
            String x = list.get(0);
            String y = list.get(1);
            Map<String, Double> mapx = new HashMap<>();
            mapx.put(y, value);
           // map.put(x, mapx);
            if(map.get(x)!=null){
                Map<String, Double> stringDoubleMap = map.get(x);
                stringDoubleMap.put(y, value);
            }else{
                map.put(x, mapx);
            }

            Map<String, Double> mapy = new HashMap<>();
            mapy.put(x, 1 / value);
          //  map.put(y, mapy);
            if(map.get(y)!=null){
                Map<String, Double> stringDoubleMap = map.get(x);
                stringDoubleMap.put(x, 1 / value);
            }else{
                map.put(y, mapy);
            }
        }
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            List<String> list = new ArrayList<>();
            list.add(x);
            process(map, x, y, list);
            if (list.size() == 1) {
                result[i] = -1.0;
            } else {
                double val = 1;
                Map<String, Double> stringDoubleMap = map.get(x);
                list.remove(x);
                for (String str : list) {
                    Double aDouble = stringDoubleMap.get(str);
                    val = val * aDouble;
                    stringDoubleMap=map.get(str);
                }
                result[i] = val;
            }
        }
        return result;
    }

    private boolean process(Map<String, Map<String, Double>> map, String x, String y, List<String> list) {
        Map<String, Double> stringDoubleMap = map.get(x);
        if (stringDoubleMap != null) {
            for (Map.Entry<String, Double> entry : stringDoubleMap.entrySet()) {
                if(list.contains(entry.getKey())){
                    continue;
                }
                if (entry.getKey().equals(y)) {
                    list.add(y);
                    return true;
                }
                list.add(entry.getKey());
                boolean process = process(map, entry.getKey(), y, list);
                if (process) {
                    return true;
                } else {
                    list.remove(entry.getKey());
                }
            }
        }
        return false;
    }

}
