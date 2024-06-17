package com.trip.algorithm.leet.l24.l06;

public class Solution2806 {
    public static void main(String[] args) {

    }

    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int i = purchaseAmount % 10;
        if(i<5){
            purchaseAmount-=i;

        }else {
            purchaseAmount-=i;
            purchaseAmount+=10;
        }

        return 100 - purchaseAmount;
    }
}
