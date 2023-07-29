package com.trip.algorithm.leet.some.leet2307;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/7/19 15:55
 */
public class Solution874 {
    public static void main(String[] args) {
      /*  int[] commands = {4,-1,3};
        int[][] obstacles = {};*/

        /*int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};*/

       /* int[] commands = {-2, 8, 3, 7, -1};
        int[][] obstacles = {{-4, -1}, {1, -1}, {1, 4}, {5, 0}, {4, 5}, {-2, -1}, {2, -5}, {5, 1}, {-3, -1}, {5, -3}}; */

       /* int[] commands = {-2,-1,-2,3,7};
        int[][] obstacles = {{1,-3},{2,-3},{4,0},{-2,5},{-5,2},{0,0},{4,-4},{-2,-5},{-1,-2},{0,2}};*/

        int[] commands = {1, 2, -2, 5, -1, -2, -1, 8, 3, -1, 9, 4, -2, 3, 2, 4, 3, 9, 2, -1, -1, -2, 1, 3, -2, 4, 1, 4, -1, 1, 9, -1, -2, 5, -1, 5, 5, -2, 6, 6, 7, 7, 2, 8, 9, -1, 7, 4, 6, 9, 9, 9, -1, 5, 1, 3, 3, -1, 5, 9, 7, 4, 8, -1, -2, 1, 3, 2, 9, 3, -1, -2, 8, 8, 7, 5, -2, 6, 8, 4, 6, 2, 7, 2, -1, 7, -2, 3, 3, 2, -2, 6, 9, 8, 1, -2, -1, 1, 4, 7};
        int[][] obstacles = {{-57, -58}, {-72, 91}, {-55, 35}, {-20, 29}, {51, 70}, {-61, 88}, {-62, 99}, {52, 17}, {-75, -32}, {91, -22}, {54, 33}, {-45, -59}, {47, -48}, {53, -98}, {-91, 83}, {81, 12}, {-34, -90}, {-79, -82}, {-15, -86}, {-24, 66}, {-35, 35}, {3, 31}, {87, 93}, {2, -19}, {87, -93}, {24, -10}, {84, -53}, {86, 87}, {-88, -18}, {-51, 89}, {96, 66}, {-77, -94}, {-39, -1}, {89, 51}, {-23, -72}, {27, 24}, {53, -80}, {52, -33}, {32, 4}, {78, -55}, {-25, 18}, {-23, 47}, {79, -5}, {-23, -22}, {14, -25}, {-11, 69}, {63, 36}, {35, -99}, {-24, 82}, {-29, -98}, {-50, -70}, {72, 95}, {80, 80}, {-68, -40}, {65, 70}, {-92, 78}, {-45, -63}, {1, 34}, {81, 50}, {14, 91}, {-77, -54}, {13, -88}, {24, 37}, {-12, 59}, {-48, -62}, {57, -22}, {-8, 85}, {48, 71}, {12, 1}, {-20, 36}, {-32, -14}, {39, 46}, {-41, 75}, {13, -23}, {98, 10}, {-88, 64}, {50, 37}, {-95, -32}, {46, -91}, {10, 79}, {-11, 43}, {-94, 98}, {79, 42}, {51, 71}, {4, -30}, {2, 74}, {4, 10}, {61, 98}, {57, 98}, {46, 43}, {-16, 72}, {53, -69}, {54, -96}, {22, 0}, {-7, 92}, {-69, 80}, {68, -73}, {-24, -92}, {-21, 82}, {32, -1}, {-6, 16}, {15, -29}, {70, -66}, {-85, 80}, {50, -3}, {6, 13}, {-30, -98}, {-30, 59}, {-67, 40}, {17, 72}, {79, 82}, {89, -100}, {2, 79}, {-95, -46}, {17, 68}, {-46, 81}, {-5, -57}, {7, 58}, {-42, 68}, {19, -95}, {-17, -76}, {81, -86}, {79, 78}, {-82, -67}, {6, 0}, {35, -16}, {98, 83}, {-81, 100}, {-11, 46}, {-21, -38}, {-30, -41}, {86, 18}, {-68, 6}, {80, 75}, {-96, -44}, {-19, 66}, {21, 84}, {-56, -64}, {39, -15}, {0, 45}, {-81, -54}, {-66, -93}, {-4, 2}, {-42, -67}, {-15, -33}, {1, -32}, {-74, -24}, {7, 18}, {-62, 84}, {19, 61}, {39, 79}, {60, -98}, {-76, 45}, {58, -98}, {33, 26}, {-74, -95}, {22, 30}, {-68, -62}, {-59, 4}, {-62, 35}, {-78, 80}, {-82, 54}, {-42, 81}, {56, -15}, {32, -19}, {34, 93}, {57, -100}, {-1, -87}, {68, -26}, {18, 86}, {-55, -19}, {-68, -99}, {-9, 47}, {24, 94}, {92, 97}, {5, 67}, {97, -71}, {63, -57}, {-52, -14}, {-86, -78}, {-17, 92}, {-61, -83}, {-84, -10}, {20, 13}, {-68, -47}, {7, 28}, {66, 89}, {-41, -17}, {-14, -46}, {-72, -91}, {4, 52}, {-17, -59}, {-85, -46}, {-94, -23}, {-48, -3}, {-64, -37}, {2, 26}, {76, 88}, {-8, -46}, {-19, -68}};
        Solution874 solution874 = new Solution874();
        int i = solution874.robotSim1(commands, obstacles);
        System.out.println(i);
        int k = solution874.robotSim(commands, obstacles);
        System.out.println(k);

        System.out.println(list.size());
        System.out.println(list1.size());
        int index = 0;
        int index1 = 0;
        while (index < list.size() || index1 < list1.size()) {
            if (index < list.size()) {
                System.out.print(list.get(index) + "------");
            }
            if (index1 < list1.size()) {
                System.out.print(list1.get(index1));
            }
            System.out.println();
            index1++;
            index++;
        }
    }

    private static List<String> list = new ArrayList<>();
    private static List<String> list1 = new ArrayList<>();

    public int robotSim1(int[] commands, int[][] obstacles) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int px = 0, py = 0, d = 1;
        Set<Integer> set = new HashSet<Integer>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] * 60001 + obstacle[1]);
        }
        int res = 0;
        for (int c : commands) {
            if (c < 0) {
                d += c == -1 ? 1 : -1;
                d %= 4;
                if (d < 0) {
                    d += 4;
                }
            } else {
                for (int i = 0; i < c; i++) {
                    if (set.contains((px + dirs[d][0]) * 60001 + py + dirs[d][1])) {
                        break;
                    }
                    px += dirs[d][0];
                    py += dirs[d][1];
                    res = Math.max(res, px * px + py * py);
                }
                list1.add(px + "," + py+","+(px*px+py*py));
            }
        }
        return res;
    }


    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            int[] obstacle = obstacles[i];
            if (obstacle[0] == obstacle[1] && obstacle[0] == 0) {
                continue;
            }
            set.add(obstacle[0] + "|" + obstacle[1]);
        }
        int res = 0;
        int x = 0;
        int curX = 0;
        int curY = 0;
        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];
            /**
             * -2 ：向左转 90 度
             * -1 ：向右转 90 度
             */
            if (command == -1) {
                x = (x - 1) % 4;
                if (x < 0) {
                    x = x + 4;
                }
            } else if (command == -2) {
                x = (x + 1) % 4;
            } else {
                if (x == 0) {
                    for (int z=0;z<command;z++) {
                        if (set.contains(curX + "|" + (curY+1))) {
                            break;
                        }
                        curY+=1;
                        res = Math.max(res, curX * curX + curY * curY );
                    }
                } else if (x == 1) {
                    for (int z=0;z<command;z++) {
                        if (set.contains((curX-1) + "|" + curY)) {
                            break;
                        }
                        curX-=1;
                        res = Math.max(res, curX * curX + curY * curY );
                    }
                } else if (x == 2) {
                    for (int z=0;z<command;z++) {
                        if (set.contains(curX + "|" + (curY-1))) {
                            break;
                        }
                        curY-=1;
                        res = Math.max(res, curX * curX + curY * curY );
                    }
                } else if (x == 3) {
                    for (int z=0;z<command;z++) {
                        if (set.contains((curX+1) + "|" + curY)) {
                            break;
                        }
                        curX+=1;
                        res = Math.max(res, curX * curX + curY * curY );
                    }
                }
            }
            /*int b = Math.abs(curX);
            int a = Math.abs(curY);
            if (command != -1 && command != -2) {
                list.add(curX + "," + curY+","+(a*a+b*b));
                int i1 = a * a + b * b;
                int t=i1;
            }*/

        }
        return res;
    }

    private String getRes(int x, int command) {
        String mes = "向{0}，{1}个单位";
        String k = "";
        if (x == 0) {
            k = "上";
        } else if (x == 1) {
            k = "左";
        } else if (x == 2) {
            k = "下";
        } else {
            k = "右";
        }
        return MessageFormat.format(mes, k, command);
    }
}
