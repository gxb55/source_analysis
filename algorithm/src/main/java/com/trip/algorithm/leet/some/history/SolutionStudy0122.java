package com.trip.algorithm.leet.some.history;

import java.util.Objects;

/**
 * 动态规划问题，思路
 * @Author xbguo
 * @date 2021/1/22  11:30
 */
public class SolutionStudy0122 {
    static int[] arr = null;
    public static void main(String[] args) {
        int MAX = 5;
        //存储数字三角形
        int[][] ints = new int[MAX][MAX];
        ints[0][0] =7;
        ints[1][0] =3;
        ints[1][1] =8;
        ints[2][0] =8;
        ints[2][1] =1;
        ints[2][2] =0;
        ints[3][0] =2;
        ints[3][1] =7;
        ints[3][2] =4;
        ints[3][3] =4;
        ints[4][0] =4;
        ints[4][1] =5;
        ints[4][2] =2;
        ints[4][3] =6;
        ints[4][4] =5;
        for(int i=0;i<ints.length;i++){
            for (int j=0;j<ints[i].length;j++){
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
        //n表示层数
        int n = 4;
        int i = 0; int j = 0;
       /* int maxSum = getMaxSum(ints,n,i,j);
        System.out.println(maxSum);*/
        int feibo = getFeibo(10);
        System.out.println(feibo);

        int feibo1 = getFeibo1(10);
        System.out.println(feibo1);

    }
    public static int getMaxSum(int[][] D,int n,int i,int j){
        if(i == n){
            return D[i][j];
        }
        int x = getMaxSum(D,n,i+1,j);
        int y = getMaxSum(D,n,i+1,j+1);
        return Math.max(x,y)+D[i][j];
    }

    public static int getFeibo(int n){
        if(Objects.isNull(arr)){
            arr = new int[n+1];
        }
        if(arr[n]!=0){
            return arr[n];
        }
        if(n==1 ||n==2){
            return 1;
        }
        arr[n] = getFeibo(n-1)+getFeibo(n-2);
        return arr[n];
    }

    public static int getFeibo1(int n){
        int arr[] = new int[n+1];
        arr[1] = 1;
        arr[2] =1;
        for(int i=3;i<=n;i++){
            arr[i] =arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

       /* public static int getMax(){
        int MAX = 5;
        int[][] D = new int[MAX][MAX];   //存储数字三角形
        int n = 0;              //n表示层数
        int i = 0; int j = 0;
        int maxSum = getMaxSum(D,n,i,j);
        return maxSum;
    }*/
}
