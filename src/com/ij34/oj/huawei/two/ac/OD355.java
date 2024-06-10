package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小明找位置
 * https://hydro.ac/d/HWOD2023/p/OD355
 * @Author: ij34
 * @Date: 2024-06-01
 */

public class OD355 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.valueOf(sc.nextLine());
        int l=0,r=a.length-1;
        while (l<=r){
            int mid = (l+r)/2;
            if (a[mid]>k){
                if (mid==0){
                    System.out.println(1);
                    return;
                }
                if (a[mid-1]<k){
                    System.out.println(mid+1);
                    return;
                }
                r=mid;
            }

            if (a[mid]<k){
                if (mid==a.length-1){
                    System.out.println(a.length+1);
                    return;
                }
                if (a[mid+1]>k){
                    System.out.println(mid+2);
                    return;
                }
                l=mid;
            }
        }
    }
}
