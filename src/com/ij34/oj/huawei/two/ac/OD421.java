package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最小矩阵宽度
 * https://hydro.ac/d/HWOD2023/p/OD421
 *
 * @Author: ij34
 * @Date: 2024-06-10
 */

public class OD421 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nm = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n=nm[0],m=nm[1];
        int[][] a = new int[n][m];
        int[] aa = new int[1000];

        for (int i=0;i<n;i++){
            a[i]=Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for (int j : a[i]){
                aa[j]++;
            }
        }
        int k = Integer.valueOf(sc.nextLine());
        int[] bb = new int[1000];
        for (int i=0;i<k;i++){
            bb[sc.nextInt()]++;
        }
        for (int i=0;i<1000;i++){
            if (aa[i]<bb[i]){
                System.out.println(-1);
                return;
            }
        }

        for (int len=1;len<m;len++){
            for (int j=0;j+len<=m;j++){
                int[] win= new int[1000];
                for (int jj=j;jj<j+len;jj++){
                    for (int i=0;i<n;i++){
                        win[a[i][jj]]++;
                    }
                }
                boolean isOk=true;
                for (int t=0;t<1000;t++){
                    if (win[t]<bb[t]){
                        isOk=false;
                        break;
                    }
                }
                if (isOk){
                    System.out.println(len);
                    return;
                }
            }
        }


        System.out.println(m);
    }
}
