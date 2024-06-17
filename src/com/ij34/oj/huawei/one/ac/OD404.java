package com.ij34.oj.huawei.one.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 灰度图存储
 * https://hydro.ac/d/HWOD2023/p/OD404
 *
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int i= sc.nextInt(),j=sc.nextInt(),k=i*a[1]+j;
        for (int t=2;t<a.length;t+=2){
            k-=a[t+1];
            if (k<0){
                System.out.println(a[t]);
                return;
            }
        }

    }
}
