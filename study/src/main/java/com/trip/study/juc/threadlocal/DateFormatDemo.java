package com.trip.study.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author xbguo
 * @createTime 2023年11月27日 21:17:00
 */
public class DateFormatDemo {
    private static SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    private static DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        String format = LocalDateTime.now().format(dateTimeFormatter);
        System.out.println(format);
        LocalDateTime parse1 = LocalDateTime.parse(format, dateTimeFormatter);
        System.out.println(parse1.getDayOfWeek().getValue());

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    Date parse = simpleDateFormat.parse("2023-11-11 21:18:18");
                    System.out.println(parse);
                }catch (Exception e){

                }
            }).start();
        }
    }
}
