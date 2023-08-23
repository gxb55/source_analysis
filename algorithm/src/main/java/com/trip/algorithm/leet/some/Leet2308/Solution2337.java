package com.trip.algorithm.leet.some.Leet2308;

/**
 * @author xbguo
 * @date 2023/8/21 14:37
 * start = "_L__R__R_", target = "L______RR"
 */
public class Solution2337 {
    public static void main(String[] args) {
      /*  String start = "_L__R__R_";
        String target = "L______RR";
*/
      //  String  start = "R_L_", target = "__LR";
      //  String  start = "_R", target = "R_";
      //  String  start = "_L__R__RL", target = "L_____RLR";
      //  String  start = "_", target = "L";
      //  String  start = "____", target = "LR_R";
        String  start = "_L__R__RR", target = "L______RR";

        boolean b = canChange(start, target);
        System.out.println(b);
    }

    public static boolean canChange(String start, String target) {
        if(start.length()==0){
            return true;
        }
        if(start.length()==1){
            return start.equals(target);
        }
        char[] startArr = start.toCharArray();
        char[] targetArr = target.toCharArray();

        int i = 0;
        while (i < start.length()) {
            if (startArr[i] == targetArr[i]) {

            } else {
                char t = targetArr[i];
                char c = startArr[i];
                //l向左移动
                if (t == 'L' && c == '_') {
                    int k = i + 1;
                    for (; k < start.length(); k++) {
                        if (startArr[k] == '_') {
                            continue;
                        } else {
                            break;
                        }
                    }
                    if(k>=start.length()){
                        return false;
                    }
                    if (startArr[k] == 'L') {
                        char c1 = startArr[i];
                        startArr[i] = startArr[k];
                        startArr[k] = c1;
                    } else {
                        return false;
                    }
                } else if (t == '_' && c == 'R') {
                    // R向右移动
                    if (i + 1 < start.length()) {
                        if (startArr[i + 1] == '_') {
                            char c1 = startArr[i];
                            startArr[i] = startArr[i + 1];
                            startArr[i + 1] = c1;
                        } else if (startArr[i + 1] == 'R') {
                            int n = i + 1;
                            while (n < start.length() && startArr[n] == 'R') {
                                n++;
                            }
                            if(n>=start.length()){
                                return false;
                            }
                            if (startArr[n] == '_') {
                                char c1 = startArr[i];
                                startArr[i] = startArr[n];
                                startArr[n] = c1;
                            } else {
                                return false;
                            }

                        }else {
                            return false;
                        }

                    } else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
