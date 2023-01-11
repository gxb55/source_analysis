package com.trip.algorithm.leet.some.leet12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/12/30 10:50
 * @description Solution855
 */
public class Solution855 {
    public static void main(String[] args) {
        /**
         * ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
         * 输出：[null,0,9,4,2,null,5]
         */
     /*   ExamRoom room = new ExamRoom(10);
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        room.leave(4);
        System.out.println(room.seat());*/


        /**
         * ["ExamRoom","seat","seat","seat"," leave","leave","seat","seat","seat","seat","seat","seat","seat","seat","seat","leave"]
         * [[10],[],[],[],[0],[4],[],[],[],[],[],[],[],[],[],[0]]
         */
      /*  ExamRoom room = new ExamRoom(10);
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        room.leave(0);
        room.leave(4);
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        room.leave(0);*/

/*["ExamRoom","seat","seat","seat","leave","leave","seat","seat","seat","seat","seat","seat","seat","seat","seat","leave","leave","seat","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","leave","seat","seat","leave","leave","seat","seat","leave"]
[[10],[],[],[],[0],[4],[],[],[],[],[],[],[],[],[],[0],[4],[],[],[7],[],[3],[],[3],[],[9],[],[0],[8],[],[],[0],[8],[],[],[2]]*/


   /*     ["ExamRoom","seat","seat","seat","leave","leave","seat","seat","seat","seat","seat","seat","seat","seat","seat","leave","leave","seat","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","leave","seat","seat","leave","leave","seat","seat","leave"]
[[10],[],[],[],[0],[4],[],[],[],[],[],[],[],[],[],[0],[4],[],[],[7],[],[3],[],[3],[],[9],[],[0],[8],[],[],[0],[8],[],[],[2]]*/
        ExamRoom room = new ExamRoom(10);
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        room.leave(0);
        room.leave(4);
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        room.leave(0);
        room.leave(4);
        System.out.println(room.seat());
        System.out.println(room.seat());

    }
}

class ExamRoom {
    int len;
    List<Integer> list;

    public ExamRoom(int n) {
        len = n;
        list = new ArrayList<>();
    }

    public int seat() {
        list.sort(Comparator.comparingInt(x -> x));
        if (list.size() == 0) {
            list.add(0);
            return 0;
        } else {
            int index = -1;
            int step = -1;
            Integer cur = -1;
            Integer last = -1;
            for (int i = 0; i < len; i++) {
                if (list.contains(i)) {
                    if (last == -1) {
                        last = i;
                    } else if (cur == -1) {
                        cur = i;
                    } else if (!last.equals(cur) && cur != -1) {
                        int val = (cur - last) / 2;
                        if ((val) > step) {
                            step = val;
                            index = val + last;
                        }
                        last = cur;
                        cur = -1;
                    }
                }
            }
            if (!last.equals(cur) && cur != -1) {
                int val = (cur - last) / 2;
                if ((val) > step) {
                    step = val;
                    index = val + last;
                }
            }
            if (index != -1) {
                list.add(index);
                return index;
            } else if (index == -1) {
                Integer integer = list.get(0);
                if (Math.abs(integer - 0) > Math.abs(integer - len - 1)) {
                    list.add(0);
                    return 0;
                } else {
                    list.add(len - 1);
                    return len - 1;
                }
            }
            return index;
        }
    }

    public void leave(int p) {
        list.remove(Integer.valueOf(p));
    }
}