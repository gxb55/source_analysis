package com.trip.algorithm.leet.some.leet2307;

/**
 * @author xbguo
 * @createTime 2023年07月05日 22:22:00
 */
public class Solution2600 {
    public static void main(String[] args) {

    }
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(k<numOnes){
            return k;
        }else if(k<(numOnes+numZeros)){
            return numOnes;
        }else {
            return numOnes-(k-(numOnes+numZeros));
        }
    }
}
