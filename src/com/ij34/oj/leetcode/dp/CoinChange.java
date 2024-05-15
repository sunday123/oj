package com.ij34.oj.leetcode.dp;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * https://leetcode.cn/problems/coin-change
 *
 * @Author: ij34
 * @Date: 2024-05-15
 */

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1]; //金额i所需的最少硬币数
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int coin : coins){
            for (int i=coin;i<=amount;i++){
                dp[i]=Math.min(dp[i],dp[i-coin]+1);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }
    /**
     * 完全背包思路，但是这道题不是常规完全背包
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for (int i=1;i<=coins.length;i++){
               for (int w=1;w<=amount;w++){
                   for (int k=1;k<=amount/coins[i-1];k++){
                       if (w-k*coins[i-1]>=0){
                           dp[i][w] =Math.max(dp[i][w],dp[i-1][w-k*coins[i-1]]+k*coins[i-1]);
                       }

                   }
               }
        }
        for (int[] d:dp){
            System.out.println(Arrays.toString(d));
        }
        return dp[coins.length][amount];
    }
}
