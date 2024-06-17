package com.ij34.oj.huawei.one.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 求最多可以派出多少支团队
 * https://hydro.ac/d/HWOD2023/p/OD226
 *
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int min=sc.nextInt();
        Arrays.sort(a);
        int l=0,r=a.length-1,count=0;
        while(r>=0 && a[r]>=min){
            count++;
            r--;
        }

        while (l<r){
            if (a[l]+a[r]>=min){
                count++;
                r--;
            }

            l++;
        }
        System.out.println(count);

    }
}
