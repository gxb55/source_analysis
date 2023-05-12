package com.trip.algorithm.leet.some.leet2304;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2023年04月08日 11:11:00
 */
public class Solution1125 {
    public static void main(String[] args) {
        Solution1125 solution1125 = new Solution1125();
      /*  String[] req_skills = {"java", "nodejs", "reactjs"};
        String[][] people = {{"java"}, {"nodejs"}, {"nodejs", "reactjs"}};*/
/*
        String[] req_skills = {"algorithms", "math", "java", "reactjs", "csharp", "aws"};
        String[][] people = {{"algorithms", "math", "java"}, {"algorithms", "math", "reactjs"}, {"java", "csharp", "aws"}, {"reactjs", "csharp"}, {"csharp", "math"}, {"aws", "java"}};
   */
        String[] req_skills = {"gvp", "jgpzzicdvgxlfix", "kqcrfwerywbwi", "jzukdzrfgvdbrunw", "k"};
        String[][] people = {{}, {}, {}, {}, {"jgpzzicdvgxlfix"},
                {"jgpzzicdvgxlfix", "k"}, {"jgpzzicdvgxlfix", "kqcrfwerywbwi"}, {"gvp"}, {"jzukdzrfgvdbrunw"}, {"gvp", "kqcrfwerywbwi"}};


        List<List<String>> list = new ArrayList<>();
        for (String[] p : people) {
            List<String> list1 = new ArrayList<>();
            for (String s : p) {
                list1.add(s);
            }
            list.add(list1);
        }
        int[] ints = solution1125.smallestSufficientTeam2(req_skills, list);
        System.out.println(Arrays.toString(ints));
    }

    private long all;
    private int[] mask;
    private long[][] memo;

    public int[] smallestSufficientTeam1(String[] reqSkills, List<List<String>> people) {
        HashMap<String, Integer> sid = new HashMap<String, Integer>();
        int m = reqSkills.length;
        for (int i = 0; i < m; ++i) {
            sid.put(reqSkills[i], i); // 字符串映射到下标
        }

        int n = people.size();
        mask = new int[n];
        for (int i = 0; i < n; ++i) {
            for (String s : people.get(i)) // 把 people[i] 压缩成一个二进制数 mask[i]
            {
                mask[i] |= 1 << sid.get(s);
            }
        }

        int u = 1 << m;
        memo = new long[n][u];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1); // -1 表示还没有计算过
        }
        all = (1L << n) - 1;
        long res = dfs(n - 1, u - 1);

        int[] ans = new int[Long.bitCount(res)];
        for (int i = 0, j = 0; i < n; ++i) {
            if (((res >> i) & 1) > 0) {
                ans[j++] = i; // 所有在 res 中的下标
            }
        }
        return ans;
    }

    private long dfs(int i, int j) {
        if (j == 0) {
            return 0; // 背包已装满
        }
        if (i < 0) {
            return all; // 没法装满背包，返回全集，这样下面比较集合大小会取更小的
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 不选 mask[i]
        long res = dfs(i - 1, j);
        // 选 mask[i]
        long res2 = dfs(i - 1, j & ~mask[i]) | (1L << i);
        return memo[i][j] = Long.bitCount(res) < Long.bitCount(res2) ? res : res2;
    }


    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        List<String> list = new ArrayList<>();
        List<String> stringList1 = new ArrayList<>();
        for (String str : req_skills) {
            list.add(str);
            stringList1.add(str);
        }
        this.stringList = stringList1;
        List<Integer> tempList = new ArrayList<>();
        process(list, 0, people, tempList);
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    List<Integer> res;
    List<String> stringList;

    private void process(List<String> list, int index, List<List<String>> people, List<Integer> tempList) {
        if (list.isEmpty()) {
            if (res == null) {
                res = new ArrayList<>();
                tempList.forEach(x -> res.add(x));
            } else {
                if (tempList.size() < res.size()) {
                    res.clear();
                    tempList.forEach(x -> res.add(x));
                }
            }
        }
        if (index >= people.size()) {
            return;
        }
        for (int i = index; i < people.size(); i++) {
            List<String> list1 = people.get(i);
            List<String> temp = new ArrayList<>();
            list.forEach(x -> {
                if (list1.contains(x)) {
                    temp.add(x);
                }
            });
            list.removeAll(temp);
            tempList.add(Integer.valueOf(i));
            process(list, i + 1, people, tempList);
            tempList.remove(Integer.valueOf(i));
            list.addAll(temp);
        }
    }

    long[][] dp;
    Map<String, Integer> map;

    public int[] smallestSufficientTeam2(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
            map.put(req_skills[i], 1 << i);
        }
        int length = req_skills.length;
        int j = (1 << length) - 1;
        int i = people.size();
        List<Integer> param = new ArrayList<>();
        for (int k = 0; k < i; k++) {
            int val = 0;
            for (String s : people.get(k)) {
                val = val | map.get(s);
            }
            param.add(k, val);
        }

        int m = req_skills.length;
        int n = people.size();
        int u = 1 << m;
        dp = new long[n][u];
        for (long[] a:dp){
            Arrays.fill(a,-1);
        }
        this.map = map;
        long i1 = process1(i - 1, param, j);

        return getInts(length, i1);

    }

    private  int[] getInts(int length, long i1) {
        int[] ans = new int[Long.bitCount(i1)];
        for (int i = 0, j = 0; i < length; ++i) {
            if (((i1 >> i) & 1) > 0) {
                ans[j++] = i; // 所有在 res 中的下标
            }
        }
        return ans;
    }

    private long process1(int index, List<Integer> param, int j) {
        if (index < 0) {
            return Integer.MAX_VALUE;
        }
        if (j == 0) {
            return 0;
        }
        if (dp[index][j] != -1) {
            return dp[index][j];
        }
        long t1 = process1(index - 1, param, j);
        long t2 = (int) (process1(index - 1, param, j & ~param.get(index)) | (1L << index));
        return dp[index][j] = Math.min(t2, t1);
    }

}
