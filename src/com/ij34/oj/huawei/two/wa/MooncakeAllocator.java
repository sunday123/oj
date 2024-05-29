package com.ij34.oj.huawei.two.wa;

import java.util.Scanner;

/**
 * 分月饼
 * @Author: ij34
 * @Date: 2024-05-07
 */

public class MooncakeAllocator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();
        int res = processCake(m,n,1);
        System.out.println(res);
    }

    private static int processCake(int m, int n, int min) {
        if (m==1){
            return n>=min &&  n<=min+3?1:0;
        }
        int count = 0;
        for (int j=min ;j<=n/m && j<=min+3;j++){
            count+=processCake(m-1,n-j,j);
        }
         return count;
    }
}