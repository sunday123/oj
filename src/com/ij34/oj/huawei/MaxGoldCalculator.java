package com.ij34.oj.huawei;

import java.util.Scanner;

/**
 * 小华最多能得到多少克黄金、小华地图寻宝
 * @Author: ij34
 * @Date: 2024-05-04
 */

public class MaxGoldCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(),n = sc.nextInt(),k = sc.nextInt();
        int max =maxGold(0,0,m,n,k,new int[m][n]);
        System.out.println(max);
    }

    private static int maxGold(int i, int j, int m, int n,int k, int[][] array) {
        if (i < 0 || i >= m || j < 0 || j >= n || (getDigitSum(i) + getDigitSum(j) > k) || array[i][j] == 1) {
            return 0;
        }
        array[i][j]=1;
        return  1+maxGold(i+1,j,m,n,k,array)+maxGold(i-1,j,m,n,k,array)
                +maxGold(i,j+1,m,n,k,array)+maxGold(i,j-1,m,n,k,array);
    }


    private static int getDigitSum(int n){
        int sum=0;
        while (n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}
