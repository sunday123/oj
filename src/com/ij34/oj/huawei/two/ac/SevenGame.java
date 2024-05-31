package com.ij34.oj.huawei.two.ac;

import java.math.BigInteger;

/**
 * 抢7游戏
 * https://hydro.ac/d/HWOD2023/p/OD426
 * @Author: ij34
 * @Date: 2024-05-31
 */

public class SevenGame {

    private static BigInteger sevenGameDp(int n) {
        if (n <= 7) {
            return BigInteger.ZERO;
        }
        BigInteger[][] dp = new BigInteger[n + 1][2];
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                dp[i][j]=BigInteger.ZERO;
            }
        }
        dp[n][0] = BigInteger.ONE; // A开始
        dp[n][1] = BigInteger.ZERO;

        for (int i = n ; i >= 7; i--) {
            if (i+1<=n){
                dp[i][0] = dp[i][0].add(dp[i + 1][1]);
                dp[i][1] = dp[i][1].add(dp[i + 1][0]);
            }
            if (i+2<=n){
                dp[i][0] = dp[i][0].add(dp[i + 2][1]);
                dp[i][1] = dp[i][1].add(dp[i + 2][0]);
            }
        }
        return dp[7][1];
    }

    private static int sevenGame(int n, boolean isB) {
        if (n<7){
            return 0;
        }
        if (n == 7) {
            return isB ? 1 : 0;
        }
        int res = 0;
        if (n > 1) {
            res += sevenGame(n - 1, !isB);
        }
        if (n > 2) {
            res += sevenGame(n - 2, !isB);
        }
        return res;
    }

}
