package com.trip.algorithm.leet.some.leet2302;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/2/7 10:59
 * 1604. 警告一小时内使用相同员工卡大于等于三次的人
 * 力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告 。
 * <p>
 * 给你字符串数组 keyName 和 keyTime ，其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡的时间。
 * <p>
 * 使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。
 * <p>
 * 请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。
 * <p>
 * 请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使用情况。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
 * 输出：["daniel"]
 * 解释："daniel" 在一小时内使用了 3 次员工卡（"10:00"，"10:40"，"11:00"）。
 * 示例 2：
 * <p>
 * 输入：keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
 * 输出：["bob"]
 * 解释："bob" 在一小时内使用了 3 次员工卡（"21:00"，"21:20"，"21:30"）。
 * 示例 3：
 * <p>
 * 输入：keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"]
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：keyName = ["leslie","leslie","leslie","clare","clare","clare","clare"], keyTime = ["13:00","13:20","14:00","18:00","18:51","19:30","19:49"]
 * 输出：["clare","leslie"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= keyName.length, keyTime.length <= 105
 * keyName.length == keyTime.length
 * keyTime 格式为 "HH:MM" 。
 * 保证 [keyName[i], keyTime[i]] 形成的二元对 互不相同 。
 * 1 <= keyName[i].length <= 10
 * keyName[i] 只包含小写英文字母。
 * 通过次数12,093提交次数24,956
 *
 *
 * 时间转分钟，处理器来更快
 */
public class Solution1604 {
    public static void main(String[] args) {
        // String[] keyName = {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"}, keyTime = {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        //   String[] keyName = {"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"}, keyTime = {"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"};
        // String[] keyName = {"alice","alice","alice","bob","bob","bob","bob"}, keyTime = {"12:01","12:00","18:00","21:00","21:20","21:30","23:00"};
      //  String[] keyName = {"a", "a", "a", "b", "b", "b", "b", "b", "b", "b", "c", "c", "c", "c", "c", "c", "c", "d", "d", "d", "d", "d", "d", "d"}, keyTime = {"13:14", "12:21", "14:32", "04:10", "01:36", "13:06", "23:55", "09:33", "20:39", "15:47", "01:57", "16:43", "20:33", "08:42", "06:05", "21:56", "17:12", "20:41", "19:53", "20:13", "02:49", "18:56", "16:48", "08:37"};

        String[] keyName = {"a","a","a","a","a","b","b","b","b","b","b","b","b","c","c","c","c","c","c","c","c","c","d","d","d","d","d","d","d","d","d","e","e","e","e","e","e","f","f","f","f","f","f","f","g","g","g","g","g","g","g","h","h","h","h","h","h","h","h","h"};
        String[] keyTime = {"07:18","08:37","12:41","00:59","17:05","17:29","10:39","07:53","04:30","11:30","02:31","11:29","19:09","21:54","07:08","22:09","23:44","10:12","10:08","05:37","02:19","22:29","07:06","02:48","01:40","10:16","01:36","14:53","10:32","09:50","07:16","12:41","19:43","06:06","18:50","19:18","12:14","20:53","10:54","10:46","14:57","06:46","15:57","02:41","06:16","03:46","12:48","00:52","13:28","05:00","10:09","01:19","15:00","11:00","11:24","05:45","21:48","02:09","16:51","19:05"};
        List<String> list = alertNames(keyName, keyTime);
        System.out.println(list);
    }

    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String s = keyName[i];
            String s1 = keyTime[i];
            if (map.containsKey(s)) {
                map.get(s).add(s1);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(s1);
                map.put(s, strings);
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String na = entry.getKey();
            List<String> collect = entry.getValue().stream().sorted().collect(Collectors.toList());
            for (int i = 0; i < collect.size(); i++) {
                String s = collect.get(i);
                String s2 = null;
                if ((i + 2) < collect.size()) {
                    s2 = collect.get(i + 2);
                }
                String substring = s.substring(0, 2);
                if(substring.startsWith("0")){
                    int i1 = Integer.valueOf(s.substring(1, 2)) + 1;
                    if(i1>=10){
                        substring = (Integer.valueOf(s.substring(1, 2))+1)+"";
                    }else{
                        substring = "0"+(Integer.valueOf(s.substring(1, 2))+1);
                    }

                }else{
                    substring=Integer.valueOf(substring)+1+"";
                }
                String s3 =  substring + s.substring(2, s.length());
                if ((s2 != null) && (s2.compareTo(s3) <= 0)) {
                    list.add(na);
                    break;
                }
            }
        }

        List<String> collect = list.stream().sorted().collect(Collectors.toList());
        return collect;
    }
}
