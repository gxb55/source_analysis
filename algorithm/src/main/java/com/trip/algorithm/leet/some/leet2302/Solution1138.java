package com.trip.algorithm.leet.some.leet2302;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年02月12日 21:47:00
 * 示例 1：
 *
 * 输入：target = "leet"
 * 输出："DDR!UURRR!!DDD!"
 * 示例 2：
 *
 * 输入：target = "code"
 * 输出："RR!DDRR!UUL!R!"
 *
 *
 * 如果方格存在，'U' 意味着将我们的位置上移一行；
 * 如果方格存在，'D' 意味着将我们的位置下移一行；
 * 如果方格存在，'L' 意味着将我们的位置左移一列；
 * 如果方格存在，'R' 意味着将我们的位置右移一列；
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/alphabet-board-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1138 {
    public static void main(String[] args) {
        String target = "leet";
         target = "code";
         target = "zdz";
         target = "leet";
         target = "grfgruuzjrktmqkziczvhezkpjzzxrdofdsksssvqoqpvwybrfigkfekcuzqdopwkgwtajelpkpxymvzikrcyoglzejtgsgzstun";
        String s = Solution1138.alphabetBoardPath(target);
        System.out.println(s);
    }

    public static String alphabetBoardPath(String target) {
        String[][] arr = {
                {"a", "b", "c", "d", "e"},
                {"f", "g", "h", "i", "j"},
                {"k", "l", "m", "n", "o"},
                {"p", "q", "r", "s", "t"},
                {"u", "v", "w", "x", "y"},
                {"z", "", "", "", ""}
        };
        Map<String, int[]> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                String s = arr[i][j];
                if (!s.equals("")) {
                    map.put(s, new int[]{i, j});
                }
            }
        }
        char[] chars = target.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int x = 0;
        int y = 0;
        for (int i = 0; i < chars.length; i++) {
            Character character = chars[i];
            int[] ints = map.get(String.valueOf(character));
            int x1 = ints[0];
            int y1 = ints[1];
            String s1=arr[x][y];
            while (!String.valueOf(character).equals(s1)){
                int j1=x;
                int t1=y;
                if (x > x1) {
                    for (int j = x1; j < x&&!arr[j1][t1].equals(""); j++) {
                        stringBuilder.append("U");
                        j1--;
                    }
                } else {
                    for (int j = x; j < x1; j++) {
                        if((j1+1)<6&&arr[j1+1][t1].equals("")){
                            break;
                        }
                        stringBuilder.append("D");
                        j1++;
                    }
                }

                if (y > y1) {
                    for ( int t = y1; t < y&&!arr[j1][t1].equals(""); t++) {
                        stringBuilder.append("L");
                        t1--;
                    }
                } else {
                    for ( int t = y; t < y1; t++) {
                        if((t1+1)<5&&arr[j1][t1+1].equals("")){
                            break;
                        }
                        stringBuilder.append("R");
                        t1++;
                    }
                }
                s1=arr[j1][t1];
                x=j1;
                y=t1;
            }
            stringBuilder.append("!");
            if (i <chars.length-1 && chars[i + 1] == character) {
                stringBuilder.append("!");
                i++;
            }
            x=x1;
            y=y1;
        }
        return stringBuilder.toString();
    }


    int[] curArr = new int[]{0, 0};

    private String getRes(String val, String[][] arr, int x, int y) {
        if (val.equals(arr[x][y])) {
            curArr = new int[]{x, y};
            return "";
        }


        return "";
    }
}
