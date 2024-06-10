package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 园区参观路径
 * https://hydro.ac/d/HWOD2023/p/OD357
 * @Author: ij34
 * @Date: 2024-06-08
 */

public class OD357 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] s = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0],m=s[1];
        long[][] a = new long[n][m];
        for (int i=0;i<n;i++){
            a[i]=Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }
        if (a[0][0]!=0){
            System.out.println(0);
            return;
        }
        long[][] dp = new long[n][m];
        dp[0][0]=1;
        for (int i=1;i< dp.length;i++){
            dp[i][0]=a[i][0]==0?dp[i-1][0]:0;
        }

        for (int j=1;j< dp[0].length;j++){
            dp[0][j]=a[0][j]==0?dp[0][j-1]:0;
        }
        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
              dp[i][j]=a[i][j]==1?0:dp[i-1][j]+dp[i][j-1];
            }
        }

        System.out.println(dp[n-1][m-1]);










    }
}
