package com.trip.algorithm.leet.l24.l100;

public class Demo {
    public static void main(String[] args) {
      extracted(3443.75,9.57);
      extracted(3443.75,11.48);
      extracted(3443.75,19.13);
    }

    private static void extracted(double a,double b) {
        double sum=0;
        for (int i = 0; i < 36; i++) {
            sum+=a;
            a-=b;
        }
        System.out.println(sum);
    }
}
