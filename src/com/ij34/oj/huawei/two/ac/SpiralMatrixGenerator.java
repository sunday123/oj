package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 螺旋数字矩阵
 * @Author: ij34
 * @Date: 2024-05-04
 */

public class SpiralMatrixGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt(),m= sc.nextInt();
        int col = (n+m-1)/m;
        String[][] a = new String[m][col];
        int count=m*col;
        int k=1;
        int i=0,j=0;
        while (k<=n){
            while (k<=n&&j<col && a[i][j]==null){
                a[i][j]= String.valueOf(k);
                k++;
                j++;
            }
            j--;
            i++;

            while (k<=n&&i<m&& a[i][j]==null){
                a[i][j]= String.valueOf(k);
                i++;
                k++;
            }
            i--;
            j--;
            while (k<=n&&j>=0&& a[i][j]==null){
                a[i][j]= String.valueOf(k);
                j--;
                k++;
            }
            j++;
            i--;
            while (k<=n&&i>0&& a[i][j]==null){
                a[i][j]= String.valueOf(k);
                i--;
                k++;
            }
            i++;
            j++;

        }
        for ( i = 0; i < a.length; i++) {
            for ( j = 0; j < a[i].length; j++) {
                if (a[i][j]==null){
                    a[i][j]="*";
                }
            }
            System.out.println(Arrays.stream(a[i]).collect(Collectors.joining(" ")));
        }
    }

}
