package com.trip.algorithm.leet.l24.l06;

/**
 * @author xbguo
 * @date 2024/6/18 10:40
 */
public class Solution2288 {
    public static void main(String[] args) {
      // String sentence = "there are $1 $2 and 5$ candies in the shop";int discount = 100;
      // String sentence = "ka3caz4837h6ada4 r1 $602";int discount = 9;
       String sentence = "$76111 ab $6 $";int discount = 48;
        String string = discountPrices(sentence, discount);
        System.out.println(string);
    }

    public static String discountPrices(String sentence, int discount) {
        double v = 0.00;
        if (discount != 100) {
            v = discount/ 100.0;
        }
        String[] split = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String string = split[i];
            if (string.startsWith("$")&&string.length()>1) {
                String substring = string.substring(1, string.length());
                if (substring.startsWith("0")) {
                    stringBuilder.append(string).append(" ");
                } else {
                    boolean flag = true;
                    char[] charArray = substring.toCharArray();
                    for (char c : charArray) {
                        if (c >= '0' && c <= '9') {
                            continue;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        if(discount==100){
                            stringBuilder.append("$").append("0.00").append(" ");
                        }else {
                            double integer = Double.valueOf(substring);
                            double v1 = integer * v;
                            integer=integer-v1;
                            stringBuilder.append("$").append(String.format("%.2f",integer)).append(" ");
                        }
                        
                    } else {
                        stringBuilder.append(string).append(" ");
                    }
                }
            } else {
                stringBuilder.append(string).append(" ");
            }
        }
        return stringBuilder.toString().substring(0,stringBuilder.length()-1);
    }
}
