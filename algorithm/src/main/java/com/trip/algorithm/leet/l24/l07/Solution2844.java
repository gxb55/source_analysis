package com.trip.algorithm.leet.l24.l07;

/**
 * @author xbguo
 * @date 2024/7/25 19:23
 */
public class Solution2844 {

    public static void main(String[] args) {
        //String string="2245047";
        String string="25";
         string="6525479784667";
        int i = minimumOperations(string);
        System.out.println(i);
    }

    public static int minimumOperations(String num) {
//  25 75 50 00
        int s1 = num.length();
        int s2 = num.length();
        int i = num.length()-1;
        char[] charArray = num.toCharArray();
        while (i >= 0 && charArray[i] != '0') {
            i--;
        }
        boolean flag1 =false;
        boolean flag2 =false;

        int j = i - 1;
        while (j >= 0 && charArray[j] != '0' && charArray[j] != '5') {
            j--;
        }

        if (j >= 0) {
            flag1=true;
            s1 = num.length() - j-2;
        }

         i = num.length()-1;
        while (i >= 0 && charArray[i] != '5') {
            i--;
        }

        j = i - 1;
        while (j >= 0 && charArray[j] != '2' && charArray[j] != '7') {
            j--;
        }
        if (j >= 0) {
            flag2=true;
            s2 = num.length() - j-2;
        }

        if(!flag2&&!flag1){
            if(num.contains("0")){
                return num.length()-1;
            }
            return num.length();
        }


        return Math.min(s2,s1);
    }
}
