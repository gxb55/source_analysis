package com.trip.algorithm.leet.some.Leet2308;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/8/15 10:58
 */
public class Solution833 {
    public static void main(String[] args) {
        Solution833 solution833 = new Solution833();
       /* String s = "abcd";
        int[] indexes = {0, 2};
        String[] sources = {"a", "cd"}, targets = {"eee", "ffff"}; */

      /*  String s = "abcd";
        int[] indexes = {0, 2};
        String[] sources = {"ab","ec"}, targets = {"eee", "ffff"};
*/
        String s = "wreorttvosuidhrxvmvo";
        int[] indexes = {14,12,10,5,0,18};
        String[] sources = {"rxv","dh","ui","ttv","wreor","vo"}, targets = {"frs","c","ql","qpir","gwbeve","n"};

        String replaceString = solution833.findReplaceString(s,indexes,sources,targets);
        System.out.println(replaceString);
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<int[], String> map = new HashMap<>();
        for (int i = 0; i < sources.length; i++) {
            String source = sources[i];
            int index = indices[i];
            if(index>=s.length()||(index + source.length())>s.length()){
                continue;
            }
            String substring = s.substring(index, index + source.length());
            String target = targets[i];
            if (substring.equals(source)) {
                map.put(new int[]{index, index + source.length()}, target);
            }
        }
        if (map.size() == 0) {
            return s;
        }
        List<Map.Entry<int[], String>> collect = map.entrySet().stream().sorted((x, y) -> x.getKey()[0] - y.getKey()[0]).collect(Collectors.toList());
        List<String> list = new ArrayList<>();
        int begin = 0;
        for (Map.Entry<int[], String> entry : collect) {
            int[] key = entry.getKey();
            int i = key[0];
            int j = key[1];
            String substring = s.substring(begin, i);
            if (substring.length() > 0) {
                list.add(substring);
            }
            list.add(entry.getValue());
            begin = j;
        }
        if (begin != s.length()) {
            String substring = s.substring(begin, s.length());
            list.add(substring);
        }
        String res = list.stream().collect(Collectors.joining());
        return res;
    }
}
