package com.ij34.oj.huawei.one.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * CPU算力分配
 * https://hydro.ac/d/HWOD2023/p/OD369
 *
 *  需要排序，如果有多个答案，选值最小的。
 *
 * @Author: ij34
 * @Date: 2024-06-17
 */

public class OD369 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),m= sc.nextInt();
        int[] a= new int[n],b=new int[m];
        for (int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for (int i=0;i<m;i++){
            b[i]= sc.nextInt();
        }
        int aSum = Arrays.stream(a).sum(),bSum= Arrays.stream(b).sum();
        int dif=(aSum-bSum)/2;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int aa :a){
            for (int bb:b){
                if (aa-dif==bb){
                    System.out.println(aa+" " +bb);
                    return;
                }
            }

        }





    }
}
