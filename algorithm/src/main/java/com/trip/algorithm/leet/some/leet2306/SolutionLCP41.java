package com.trip.algorithm.leet.some.leet2306;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/6/21 09:53
 */
public class SolutionLCP41 {
    public static void main(String[] args) {
        SolutionLCP41 solutionLCP41 = new SolutionLCP41();
      /*  String[] chessboard= {
                "....X.",
                "....X.",
                "XOOO..",
                "......",
                "......"};  */

        String[] chessboard= {
                ".......",".......",".......","X......",".O.....","..O....","....OOX"};

       /* String[] chessboard= {
                ".X.",
                ".O.",
                "XO."};*/
        int i = solutionLCP41.flipChess(chessboard);
        System.out.println(i);
    }

    public int flipChess(String[] chessboard) {
        int[][] arr = {{1, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        String[][] strings = new String[chessboard.length][chessboard[0].toCharArray().length];
        for (int i = 0; i < strings.length; i++) {
            char[] split = chessboard[i].toCharArray();
            for (int j = 0; j < split.length; j++) {
                strings[i][j] = String.valueOf(split[j]);
            }
        }
        int max = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                String s = strings[i][j];
                if (s.equals(".")) {
                    max = Math.max(max, getRes(i, j, strings, arr));
                }
            }
        }
        return max;
    }

    private int getRes(int i, int j, String[][] strings, int[][] arr) {
        String[][] clone = new String[strings.length][strings[0].length];
        for (int k = 0; k < strings.length; k++) {
            for (int l = 0; l < strings[k].length; l++) {
                clone[k][l]=strings[k][l];
            }
        }
        int count = 0;
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{i, j});
        while (!list.isEmpty()) {
            int[] ints1 = list.pollFirst();
            clone[ints1[0]][ints1[1]] = "X";
            for (int k = 0; k < arr.length; k++) {
                int[] ints = arr[k];
                int x = ints1[0];
                int y = ints1[1];
                int anInt0 = ints[0];
                int anInt1 = ints[1];
                List<String> list1 = new ArrayList<>();
                LinkedList<int[]> curList = new LinkedList<>();
                int index=0;
                boolean flag =false;
                while ((x) >= 0 && (x ) < clone.length && (y ) >= 0 && (y ) < clone[0].length) {
                    list1.add(clone[x][y]);
                    curList.add(new int[]{x, y});
                    if(index!=0&&clone[x][y].equals("X")){
                        flag=true;
                        break;
                    }
                    x = x + anInt0;
                    y = y + anInt1;
                    index++;
                }
                if (flag&&list1.size() >= 3) {
                    String s = list1.remove(0);
                    String s1 = list1.remove(list1.size() - 1);
                    if (s.equals("X") && s1.equals("X") && list1.stream().allMatch(t -> t.equals("O"))) {
                        curList.pollFirst();
                        curList.pollLast();
                        list.addAll(curList);
                        curList.stream().forEach(t->clone[t[0]][t[1]]="X");
                        count += curList.size();
                    }
                }
            }
            clone[ints1[0]][ints1[1]] = ".";
        }
        return count;
    }
}
