package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 结队编程
 * https://hydro.ac/d/HWOD2023/p/OD385
 * @Author: ij34
 * @Date: 2024-06-04
 */

public class OD385 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =Integer.valueOf(sc.nextLine());
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int res = 0;
        for (int i=0;i<n-2;i++){
            for (int j=i+1;j<n-1;j++){
                for (int k=j+1;k<n;k++){
                    if ((a[j]>a[i] && a[j]<a[k])||(a[j]>a[k] && a[j]<a[i])){
                        res++;
                    }
                }
            }
        }
        System.out.println(res);

    }


   //方法2
    public static void main2(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        long[] a = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        if (a.length<3){
            System.out.println(0);
            return;
        }
        long count=process(a)+process2(a);

        System.out.println(count);

    }
    //大到小
    private static long process2(long[] a) {
        long[] b = new long[a.length];
        for (int i=1;i<b.length-1;i++){
            long count = 0 ;
            for (int j=i+1;j<b.length;j++){
                if (a[j]<a[i]){
                    count++;
                }
            }
            b[i]=count;
        }
        long res=0;
        for (int i=0;i<b.length-1;i++){
            for (int j=i+1;j<b.length;j++){
                if (a[j]<a[i]){
                    res+=b[j];
                }
            }
        }

        return res;
    }

    private static long process(long[] a) {
        long[] b = new long[a.length];
        for (int i=0;i<b.length-1;i++){
            long count = 0 ;
            for (int j=i+1;j<b.length;j++){
                if (a[j]>a[i]){
                    count++;
                }
            }
            b[i]=count;
        }
        long res=0;
        for (int i=0;i<b.length-1;i++){
            for (int j=i+1;j<b.length;j++){
                if (a[j]>a[i]){
                    res+=b[j];
                }
            }
        }

        return res;
    }
}
