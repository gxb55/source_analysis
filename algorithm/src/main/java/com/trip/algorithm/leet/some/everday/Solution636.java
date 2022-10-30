package com.trip.algorithm.leet.some.everday;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2022年08月07日 11:24:00
 */
public class Solution636 {
    public static void main(String[] args) {
        Solution636 solution636 = new Solution636();
       /* int n = 2;
        String[] logs = {"0:start:0", "1:start:2", "1:end:5", "0:end:6"};*/

       /* int n = 1;
        String[] logs = {"0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"};*/
      /*  int n = 2;
        String[] logs = {"0:start:0","1:start:2","1:end:5","0:end:6"};*/


        int n = 8;
        String[] logs = {"0:start:0", "1:start:5", "2:start:6", "3:start:9", "4:start:11", "5:start:12", "6:start:14", "7:start:15", "1:start:24", "1:end:29", "7:end:34", "6:end:37", "5:end:39", "4:end:40", "3:end:45", "0:start:49", "0:end:54", "5:start:55", "5:end:59", "4:start:63", "4:end:66", "2:start:69", "2:end:70", "2:start:74", "6:start:78", "0:start:79", "0:end:80", "6:end:85", "1:start:89", "1:end:93", "2:end:96", "2:end:100", "1:end:102", "2:start:105", "2:end:109", "0:end:114"};


        int[] ints = solution636.exclusiveTime3(n, List.of(logs));
        int[] ints2 = solution636.exclusiveTime1(n, List.of(logs));
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints2));
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int max = -1;
        int min = -1;
        Map<Integer, List<String>> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < logs.size(); i++) {
            String s = logs.get(i);
            String[] split = s.split(":");
            max = Math.max(max, Integer.parseInt(split[2]));
            min = Math.max(min, Integer.parseInt(split[2]));

            if (s.contains("end")) {
                String pop = stack.pop();
                String val = pop + "_" + s;
                Integer integer = Integer.valueOf(split[0]);
                if (map.containsKey(integer)) {
                    map.get(Integer.valueOf(split[0])).add(val);
                } else {
                    List<String> strings = new ArrayList<>();
                    strings.add(val);
                    map.put(integer, strings);
                }
            } else {
                stack.add(s);
            }
        }

        int[] dp = new int[max + 1];
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<String> value = entry.getValue();
            for (int i = 0; i < value.size(); i++) {
                String s = value.get(i);
                String[] s1 = s.split("_");
                String[] split1 = s1[0].split(":");
                String[] split2 = s1[1].split(":");
                for (int j = Integer.parseInt(split1[2]); j <= Integer.parseInt(split2[2]); j++) {
                    dp[j] = Integer.parseInt(split1[0]);
                }
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < dp.length; i++) {
            res[dp[i]]++;
        }
        return res;
    }


    public int[] exclusiveTime1(int n, List<String> logs) {
        Deque<int[]> stack = new ArrayDeque<int[]>(); // {idx, 开始运行的时间}
        int[] res = new int[n];
        for (String log : logs) {
            int idx = Integer.parseInt(log.substring(0, log.indexOf(':')));
            String type = log.substring(log.indexOf(':') + 1, log.lastIndexOf(':'));
            int timestamp = Integer.parseInt(log.substring(log.lastIndexOf(':') + 1));
            if ("start".equals(type)) {
                if (!stack.isEmpty()) {
                    int i = stack.peek()[0];
                    res[i] = res[i] + timestamp - stack.peek()[1];
                    stack.peek()[1] = timestamp;
                }
                stack.push(new int[]{idx, timestamp});
            } else {
                int[] t = stack.pop();
                res[t[0]] += timestamp - t[1] + 1;
                if (!stack.isEmpty()) {
                    stack.peek()[1] = timestamp + 1;
                }
            }
        }
        return res;
    }

    public int[] exclusiveTime3(int n, List<String> logs) {
        int[] dp = new int[n];
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < logs.size(); i++) {
            String[] split = logs.get(i).split(":");
            int index = Integer.parseInt(split[0]);
            String s1 = split[1];
            int start  = Integer.parseInt(split[2]);
            if (s1.equals("start")) {
                if (!deque.isEmpty()) {
                    int[] peek = deque.peek();
                    dp[peek[0]] = dp[peek[0]] +start - peek[1];
                    peek[1] = start;
                }
                deque.push(new int[]{index,start});
            } else {
                int[] ints = deque.pop();
                dp[ints[0]] =dp[ints[0]]+ start - ints[1] + 1;
                if (!deque.isEmpty()) {
                    deque.peek()[1] = start + 1 ;
                }
            }
        }
        return dp;
    }

}
