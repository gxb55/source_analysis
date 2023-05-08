package com.trip.algorithm.leet.some.leet2304;

/**
 * @author xbguo
 * @createTime 2023年04月17日 22:16:00
 */
public class Solution2409 {
    public static void main(String[] args) {
       /* Solution2409 solution2409 = new Solution2409();
        // String arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19";
        //String arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31";
        String arriveAlice = "09-01", leaveAlice = "10-19", arriveBob = "06-19", leaveBob = "10-20";


        int i = solution2409.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);
        System.out.println(i);*/
        Solution2409 solution2409 = new Solution2409();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("b");
        solution2409.x(stringBuilder,stringBuilder1);
        System.out.println(stringBuilder+"+"+stringBuilder1);

    }
    public void x(StringBuilder stringBuilder,StringBuilder s1){
        stringBuilder.append(s1);
        s1=stringBuilder;
        System.out.println(s1);
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int arrive = extracted(arriveAlice, arr);
        int leave = extracted(leaveAlice, arr);
        int arrive1 = extracted(arriveBob, arr);
        int leave1 = extracted(leaveBob, arr);

        if (arrive > leave1 || leave < arrive1) {
            return 0;
        } else {
           return Math.min(leave1,leave)-Math.max(arrive1,arrive)+1;
        }
    }

    private int extracted(String arriveAlice, int[] arr) {
        String[] split = arriveAlice.split("-");
        String s = split[0].startsWith("0") ? split[0].substring(1, split.length) : split[0];
        String s1 = split[1].startsWith("0") ? split[1].substring(1, split.length) : split[1];
        Integer month = Integer.valueOf(s);
        Integer day = Integer.valueOf(s1);
        int begin = 0;
        for (int i = 0; i < month-1; i++) {
            begin += arr[i];
        }
        begin += day;
        return begin;
    }
}
