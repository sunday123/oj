package com.ij34.oj.leetcode;

/**
 * 279. 完全平方数
 * https://leetcode.cn/problems/perfect-squares/description/?envType=study-plan-v2&envId=top-100-liked
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class NumSquaresOj {
    public static void main(String[] args) {
        System.out.println(new NumSquaresOj().numSquares(13));
    }

    public int numSquares(int n) {
       int[] dp = new int[n+1];
       for (int i=1;i<=n;i++){
           dp[i]=i;
           for (int j=1;j*j<=i;j++){
               dp[i]=Math.min(dp[i],dp[i-j*j]+1);
           }
       }
        return dp[n];
    }
}
