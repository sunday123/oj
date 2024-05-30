package com.ij34.oj.huawei.two.ac;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 分月饼
 * https://hydro.ac/d/HWOD2023/p/OD348
 *
 * @Author: ij34
 * @Date: 2024-05-07
 */

public class MooncakeAllocator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();
        for (int i=1;i<=n/m;i++){
            processCake(m,n,1,i,i);
        }

        System.out.println(c);
    }
    private static int c=0;
    private static void processCake(int len, int n, int start,int sum,int pre ) {
        if (start==len) {
            if (sum==n){
                c++;
            }
            return;
        }

        for (int i = pre; i<=pre+3 && i<=n-len+1; i++) {
            if (i+sum<=n){
                processCake(len, n,start+1,i+sum,i);
            }
        }
    }
}