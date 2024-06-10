package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 高效货运
 * https://hydro.ac/d/HWOD2023/p/OD389
 * @Author: ij34
 * @Date: 2024-06-08
 */

public class OD389 {
    public static void main(String[] args) {
        int[] a = Arrays.stream(new Scanner(System.in).nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int wa = a[0], pa = a[3], wb = a[1], pb = a[4], wt = a[2];
        int max=0;
        for (int i=1;i<=wt/wa;i++){
            if (wt-(i*wa)<wb){
                continue;
            }
            int j = (wt-(i*wa))/wb;
            if (wa*i+wb*j==wt){
                int temp = i*pa +j*pb;
                max=max>temp?max:temp;
            }
        }
        System.out.println(max);
    }
}
