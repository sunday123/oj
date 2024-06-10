package com.ij34.oj.huawei.one.ac;

import java.util.Scanner;

/**
 *  最多购买宝石数目
 *  https://hydro.ac/d/HWOD2023/p/OD366
 * @Author: ij34
 * @Date: 2024-06-08
 */

public class OD366 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        if (n<1){
            sc.nextInt();
            System.out.println(0);
            return;
        }
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int v= sc.nextInt();

        int l=0,r=1,win=a[0];
        int res=win<=v?1:0;
        while (r<a.length){
            win+=a[r];
            if (win<=v){
                res=Math.max(r-l+1,res);
            }else {
                win-=a[l];
                l++;
            }
            r++;
        }

        System.out.println(res);





    }
}
