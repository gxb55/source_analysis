package com.trip.algorithm.leet.some.leet2312;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/12/20 18:39
 * @description TODO
 */
public class Solution2828 {
    public static void main(String[] args) {

        LocalDateTime localDateTime =LocalDateTime.now();

        LocalDateTime localDateTime1 =localDateTime.plusMinutes(61);
        Duration between = Duration.between(localDateTime, localDateTime1);
        SimpleDateFormat formatter = new SimpleDateFormat("HH时mm分");
        String format = formatter.format(new Date(between.toMillis()));
        System.out.println(format);

        long hours = between.toHours();
        long minutes = between.toMinutes() % 60;

        String formattedDuration = String.format("%02d时%02d分", hours, minutes);
        System.out.println(formattedDuration);
    }
    public boolean isAcronym(List<String> words, String s) {
        if(words.size()!=s.length()){
            return false;
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i <s.length(); i++) {
            boolean b = words.get(i).charAt(0) == charArray[i];
            if(!b){
                return false;
            }
        }
        return true;
    }
}
