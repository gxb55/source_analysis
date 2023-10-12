package com.trip.algorithm.leet.some.leet2310;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/10/11 10:25
 */
public class Solution2512 {
    public static void main(String[] args) {
       /* String[] positive_feedback = {"smart", "brilliant", "studious"};
        String[] negative_feedback = {"not"};
        String[] report = {"this student is studious", "the student is smart"};
        int[] student_id = {1, 2};
        int k = 2;*/

        String[] positive_feedback = {"fkeofjpc","qq","iio"};
        String[] negative_feedback = {"jdh","khj","eget","rjstbhe","yzyoatfyx","wlinrrgcm"};
        String[] report = {"rjstbhe eget kctxcoub urrmkhlmi yniqafy fkeofjpc iio yzyoatfyx khj iio",
                "gpnhgabl qq qq fkeofjpc dflidshdb qq iio khj qq yzyoatfyx",
                "tizpzhlbyb eget z rjstbhe iio jdh jdh iptxh qq rjstbhe","jtlghe wlinrrgcm jnkdbd k iio et rjstbhe iio qq jdh",
                "yp fkeofjpc lkhypcebox rjstbhe ewwykishv egzhne jdh y qq qq",
                "fu ql iio fkeofjpc jdh luspuy yzyoatfyx li qq v",
                "wlinrrgcm iio qq omnc sgkt tzgev iio iio qq qq",
                "d vhg qlj khj wlinrrgcm qq f jp zsmhkjokmb rjstbhe"};
        int[] student_id = {96537918,589204657,765963609,613766496,43871615,189209587,239084671,908938263};
        int k = 3;

        Solution2512 solution2512 =new Solution2512();
        List<Integer> list = solution2512.topStudents(positive_feedback, negative_feedback, report, student_id, k);
        System.out.println(list);
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        List<int[]> list = new ArrayList<>();
        Map<String,Integer> positiveMap =new HashMap<>();
        for (String x:positive_feedback){
            int i = positiveMap.getOrDefault(x, 0) + 1;
            positiveMap.put(x,i);
        }
        Map<String,Integer> negativeMap =new HashMap<>();
        for (String x:negative_feedback){
            int i = negativeMap.getOrDefault(x, 0) + 1;
            negativeMap.put(x,i);
        }
        for (int i = 0; i < student_id.length; i++) {
            String s = report[i];
            int sum = 0;
            int index = student_id[i];
            String[] s1 = s.split(" ");
            for (String x : s1) {
                if (positiveMap.containsKey(x)) {
                    sum += 3;
                }
                if (negativeMap.containsKey(x)) {
                    sum -= 1;
                }
            }
            list.add(new int[]{index, sum});
        }
        //[239084671,589204657,43871615]
        List<int[]> collect = list.stream().sorted((x, y) -> {
            if (x[1] == y[1]) {
                return x[0] - y[0];
            } else {
                return y[1] - x[1];
            }
        }).collect(Collectors.toList());
        List<Integer> collect1 = collect.stream().limit(k).map(x -> x[0]).collect(Collectors.toList());
        return collect1;
    }
}
