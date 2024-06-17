package com.ij34.oj.huawei.one.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 找座位
 *
 * https://hydro.ac/d/HWOD2023/p/OD344
 *
 * 先处理左右两边
 *
 * @Author: ij34
 * @Date: 2024-06-17
 */

public class OD344 {
    public static void main(String[] args) {
        int[] a = Arrays.stream(new Scanner(System.in).nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        if (a.length==1){
            System.out.println(a[0]==0?1:0);
            return;
        }
        if (a.length==2){
            for (int aa:a){
                if (aa==1){
                    System.out.println(0);
                    return;
                }
            }
            System.out.println(1);
            return;
        }

        int count=0;
        if (a[0]==0 && a[1]==0){
            count++;
            a[0]=1;

        }
        if (a[a.length-1]==0 && a[a.length-2]==0){
            count++;
            a[a.length-1]=1;

        }
        for (int i=1;i<a.length-1;i++){
            if (a[i]==0 && a[i-1]==0 && a[i+1]==0){
                count++;
                a[i]=1;
            }
        }
        System.out.println(count);




    }
}
